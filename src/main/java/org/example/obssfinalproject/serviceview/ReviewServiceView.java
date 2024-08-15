package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.reviewDto.ReviewReadDto;
import org.example.obssfinalproject.dto.reviewDto.ReviewWriteDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ReviewServiceView {

    List<ReviewReadDto> getAllReviews();
    ResponseEntity<ReviewReadDto> getReviewById(Long id);
    ReviewReadDto createReview(ReviewWriteDto reviewWriteDto, Long userId, Long productId);
    ResponseEntity<ReviewReadDto> updateReview(Long id, ReviewWriteDto reviewWriteDto);
    ResponseEntity<Void> deleteReview(Long id);
    List<ReviewReadDto> getReviewsByProductId(Long id);

    List<ReviewReadDto> getReviewsByUserId(Long id);
}

