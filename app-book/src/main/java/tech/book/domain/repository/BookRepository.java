package tech.book.domain.repository;

import java.util.List;
import java.util.Optional;
import tech.book.domain.entity.Book;

public interface BookRepository {
  void save(Book book);

  Optional<Book> getOne(Long id);

  List<Book> getAll();
}
