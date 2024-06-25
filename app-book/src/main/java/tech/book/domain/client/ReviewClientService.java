package tech.book.domain.client;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.WebApplicationException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import tech.book.application.exceptions.impl.ReviewBusinessErrorException;

@Slf4j
@ApplicationScoped
public class ReviewClientService {

  @Inject @RestClient ReviewsClient client;

  public List<ReviewResponse> getById(Long id) {

    try {
      log.info("searching reviews");
      return client.getById(id);
    } catch (ReviewBusinessErrorException ex) {
      log.error("Error no review");
      return List.of();
    } catch (WebApplicationException e) {
      log.error("Error when searching for reviews");
      throw e;
    }
  }
}
