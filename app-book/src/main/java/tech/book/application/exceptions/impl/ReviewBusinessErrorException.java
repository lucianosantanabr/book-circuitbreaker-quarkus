package tech.book.application.exceptions.impl;

import static tech.book.application.util.CheckUtils.notEmpty;
import static tech.book.application.util.CheckUtils.notNull;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.io.Serial;
import lombok.Getter;
import tech.book.application.exceptions.BusinessException;
import tech.book.application.exceptions.Hidden;
import tech.book.application.exceptions.handler.ErrorResponse;

@Getter
@RegisterForReflection
public class ReviewBusinessErrorException extends BusinessException {

  @Serial
  private static final long serialVersionUID = 7089596342074681535L;

  public static final String CODE = "exception.ledger.businesserror";
  public static final Integer STATUS = 412;

  public ReviewBusinessErrorException(@Hidden ErrorResponse error) {
    super( //
        notNull(error) && notNull(error.getStatus()) ? error.getStatus() : STATUS, //
        notNull(error) && notEmpty(error.getCode()) ? error.getCode() : CODE, //
        notNull(error) && notEmpty(error.getMessage()) ? error.getMessage() : "no-message");

    if (notNull(error) && notEmpty(error.getParams())) {
      error.getParams().forEach(this::param);
    }
  }
}
