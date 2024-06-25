package tech.book.domain.entity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import tech.book.application.exceptions.impl.BookNotFoundException;
import tech.book.domain.client.ReviewClientService;
import tech.book.domain.client.ReviewResponse;
import tech.book.domain.repository.BookRepository;
import tech.book.domain.resource.BookResponse;

@ApplicationScoped
@Slf4j
public class BookService {

  @Inject ReviewClientService client;

  @Inject BookRepository bookRepo;

  public BookResponse getBookReviews(Long id) throws BookNotFoundException {

    Book book = bookRepo.getOne(id).orElseThrow(() -> new BookNotFoundException(id));
    List<ReviewResponse> reviews = client.getById(id);

    return BookResponse.of(book, reviews);
  }

  public List<BookResponse> getAll() {
    return bookRepo.getAll().stream().map(BookResponse::of).toList();
  }
}
