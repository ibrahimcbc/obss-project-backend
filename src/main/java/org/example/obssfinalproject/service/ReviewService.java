package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.Review;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> getAllReviews();
    Optional<Review> getReviewById(Long id);
    Review createReview(Review review, Long userId, Long productId);
    Optional<Review> updateReview(Long id, Review reviewDetails);
    ResponseEntity<Void> deleteReview(Long id);

    List<Review> getReviewsByProductId(Long id);

    List<Review> getReviewsByUserId(Long id);
}
