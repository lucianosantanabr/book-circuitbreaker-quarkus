package tech.reviews.application.exception.impl;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import tech.reviews.application.exception.BusinessException;

@Getter
@RegisterForReflection
public class ReviewNotFoundException extends BusinessException {

  public static final String CODE = "exception.review.notFound";
  public static final Integer STATUS = 412;
  public static final String MESSAGE = "Review with id=[reviewId] was not found";

  public ReviewNotFoundException(Long reviewId) {
    super(STATUS, CODE, MESSAGE);
    param("reviewId", reviewId);
  }
}
