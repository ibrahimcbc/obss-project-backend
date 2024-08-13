package org.example.obssfinalproject.service.impl;


import org.example.obssfinalproject.model.Review;
import org.example.obssfinalproject.repository.ReviewRepository;
import org.example.obssfinalproject.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public Optional<Review> updateReview(Long id, Review reviewDetails) {
        return reviewRepository.findById(id).map(existingReview -> {
            existingReview.setTitle(reviewDetails.getTitle());
            existingReview.setDescription(reviewDetails.getDescription());
            existingReview.setScore(reviewDetails.getScore());
            existingReview.setUserId(reviewDetails.getUserId());
            existingReview.setProductId(reviewDetails.getProductId());
            return reviewRepository.save(existingReview);
        });
    }

    @Override
    public ResponseEntity<Void> deleteReview(Long id) {
        if (reviewRepository.findById(id).isPresent()){
            reviewRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<Review> getReviewsByProductId(Long id) {
        return reviewRepository.findByProductId(id);
    }

    @Override
    public List<Review> getReviewsByUserId(Long id) {
        return reviewRepository.findByUserId(id);
    }
}


