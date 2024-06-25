package tech.book.application.exceptions.impl;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import tech.book.application.exceptions.BusinessException;

@Getter
@RegisterForReflection
public class BookNotFoundException extends BusinessException {

  public static final String CODE = "exception.book.notFound";
  public static final Integer STATUS = 412;
  public static final String MESSAGE = "Book with id=[bookId] was not found";

  public BookNotFoundException(Long bookId) {
    super(STATUS, CODE, MESSAGE);
    param("bookId", bookId);
  }
}
