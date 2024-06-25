package tech.reviews.domain.repository;

import java.util.List;
import java.util.Optional;
import tech.reviews.domain.entity.Review;

public interface ReviewRepository {

  void save(Review review);
  List<Review> getAll();
  Optional<Review> getOne(Long id);

  List<Review> getReviewsOfBook(Long bookId);


}
