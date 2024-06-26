package tech.book.domain.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Random;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.book.application.exceptions.handler.CircuitBreakerFallback;
import tech.book.application.exceptions.impl.BookNotFoundException;
import tech.book.application.util.ResponseUtility;
import tech.book.domain.entity.BookService;

@Slf4j
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Books", description = "Book manipulation endpoint")
@Path("/books")
public class BookResource implements ResponseUtility {

  @Inject BookService bookService;

  @GET
  public Response getAll() {
    return ok(bookService.getAll());
  }

  @GET
  @Path("/{id}")
  public Response getId(@PathParam("id") Long id) throws BookNotFoundException {
    return ok(bookService.getBookReviews(id));
  }

  @GET
  @Path("/circuit")
  @Produces(MediaType.TEXT_PLAIN)
  @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.1, delay = 9000)
  @Fallback(CircuitBreakerFallback.class)
  public String circuitBreaker() {
    var rd = new Random().nextInt(3);

    if (rd >= 2 ) {
      log.error("Number={} is >= 2", rd);
      throw new NullPointerException();
    }
    return "Hello circuit RD="+rd;
  }

  private String fallback() {
    return "Message Fallback";
  }
}
