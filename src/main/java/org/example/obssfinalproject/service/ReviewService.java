package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.Review;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews();
    ResponseEntity<Review> getReviewById(Long id);
    Review createReview(Review review);
    ResponseEntity<Review> updateReview(Long id, Review reviewDetails);
    ResponseEntity<Void> deleteReview(Long id);
}
