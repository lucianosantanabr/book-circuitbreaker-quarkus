package tech.book.domain.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.book.application.exceptions.impl.BookNotFoundException;
import tech.book.application.util.ResponseUtility;
import tech.book.domain.entity.BookService;

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
}
