package tech.reviews.domain.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import tech.reviews.application.exception.impl.ReviewNotFoundException;
import tech.reviews.application.util.ResponseUtility;
import tech.reviews.domain.entity.ReviewService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Reviews", description = "Review endpoint")
@Path("/reviews")
public class ReviewResource implements ResponseUtility {

  @Inject ReviewService reviewService;

  @GET
  public Response getAll() {
    return ok(reviewService.getAll());
  }

  @GET
  @Path("/book/{book-id}")
  public Response getReviewsOfBook(@PathParam("book-id") Long bookId) {
    return ok(reviewService.getReviewOfBook(bookId));
  }

  @GET
  @Path("/{id}")
  public Response getOne(@QueryParam("id") Long id) throws ReviewNotFoundException {
    return ok(reviewService.getOne(id));
  }
}
