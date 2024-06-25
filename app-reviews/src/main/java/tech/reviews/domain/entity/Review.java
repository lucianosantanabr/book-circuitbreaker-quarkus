package tech.reviews.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Review {

  private Long id;
  private Integer nota;
  private String description;
  private String evaluator;
  private Long bookId;


}
