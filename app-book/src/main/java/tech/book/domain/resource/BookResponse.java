package tech.book.domain.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.book.domain.client.ReviewResponse;
import tech.book.domain.entity.Book;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponse {

  Long id;
  String name;

  @JsonInclude(Include.NON_NULL)
  List<ReviewResponse> reviews;

  public BookResponse(Long id, String name) {
    this.id = id;
    this.name = name;
  }
  public static BookResponse of(Book book) {
    return new BookResponse(book.getId(), book.getName());
  }

  public static BookResponse of(Book book, List<ReviewResponse> reviews) {
    return new BookResponse(book.getId(), book.getName(), reviews);
  }
}
