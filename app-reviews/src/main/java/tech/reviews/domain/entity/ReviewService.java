package tech.reviews.domain.entity;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import tech.reviews.application.exception.impl.ReviewNotFoundException;
import tech.reviews.domain.repository.ReviewRepository;

@ApplicationScoped
@Slf4j
public class ReviewService {

  @Inject ReviewRepository reviewRepo;

  public List<Review> getReviewOfBook(Long bookId) {
    return reviewRepo.getReviewsOfBook(bookId);
  }

  public List<Review> getAll() {
    return reviewRepo.getAll();
  }

  public Review getOne(Long id) throws ReviewNotFoundException {
    return reviewRepo.getOne(id).orElseThrow(() -> new ReviewNotFoundException(id));
  }
}
