package tech.book.domain.client;

import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import tech.book.application.exceptions.handler.ErrorResponse;
import tech.book.application.exceptions.impl.ReviewBusinessErrorException;

@Slf4j
@Provider
public class ReviewBusinessErrorHandler
    implements ResponseExceptionMapper<ReviewBusinessErrorException> {

  public ReviewBusinessErrorHandler() {
    super();
  }

  @Override
  public boolean handles(int statusCode, MultivaluedMap<String, Object> headers) {
    return statusCode >= 400 && statusCode < 500;
  }

  public ReviewBusinessErrorException toThrowable(Response response) {
    try {
      return new ReviewBusinessErrorException(response.readEntity(ErrorResponse.class));
    } catch (Exception e) {
      log.error("Error handling ReviewBusinessErrorException: {}", e.getLocalizedMessage());
      return null;
    }
  }
}
