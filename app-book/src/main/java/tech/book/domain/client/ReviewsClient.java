package tech.book.domain.client;

import io.quarkus.logging.Log;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import tech.book.application.exceptions.impl.ReviewBusinessErrorException;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient(configKey = "reviews")
@RegisterProvider(ReviewBusinessErrorHandler.class)
public interface ReviewsClient {

  @GET
  @Path("/reviews/book/{book-id}")
  @Fallback(fallbackMethod = "fallback")
  @CircuitBreaker(
      requestVolumeThreshold = 6,
      delay = 1000,
      successThreshold = 3)
  List<ReviewResponse> getById(@PathParam("book-id") Long bookId)
      throws ReviewBusinessErrorException;

  default List<ReviewResponse> fallback(Long booKId) {
    Log.info("Lista vazia do fallback");
    return List.of();
  }
}
