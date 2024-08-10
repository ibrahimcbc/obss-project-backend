package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.Review;
import org.example.obssfinalproject.repository.ReviewRepository;
import org.example.obssfinalproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public ResponseEntity<Review> getReviewById(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        return ResponseEntity.ok().body(review);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public ResponseEntity<Review> updateReview(Long id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found"));

        review.setTitle(reviewDetails.getTitle());
        review.setDescription(reviewDetails.getDescription());
        review.setScore(reviewDetails.getScore());
        review.setUserId(reviewDetails.getUserId());
        review.setProductId(reviewDetails.getProductId());

        final Review updatedReview = reviewRepository.save(review);
        return ResponseEntity.ok(updatedReview);
    }

    @Override
    public ResponseEntity<Void> deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Review not found"));
        reviewRepository.delete(review);
        return ResponseEntity.noContent().build();
    }
}

