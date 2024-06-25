package tech.book.domain.repository;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import tech.book.domain.entity.Book;

@ApplicationScoped
public class BookRepositoryImp implements BookRepository {

  private static final List<Book> BOOKS = new ArrayList<>();
  private static long id = 1;

  static {
    BOOKS.add(new Book(nexId(), "Refactoring with java"));
    BOOKS.add(new Book(nexId(), "Clean Code"));
    BOOKS.add(new Book(nexId(), "The Cucumber Book"));
  }

  @Override
  public void save(Book book) {
    book.setId(nexId());
    BOOKS.add(book);
  }

  @Override
  public Optional<Book> getOne(Long id) {
    return BOOKS.stream().filter(b -> b.getId().equals(id)).findFirst();
  }

  @Override
  public List<Book> getAll() {
    return new ArrayList<>(BOOKS);
  }

  private static long nexId() {
    return id++;
  }
}
