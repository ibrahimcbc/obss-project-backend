package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.reviewDto.ReviewReadDto;
import org.example.obssfinalproject.dto.reviewDto.ReviewWriteDto;
import org.example.obssfinalproject.mapper.ReviewMapper;
import org.example.obssfinalproject.model.Review;
import org.example.obssfinalproject.service.ReviewService;
import org.example.obssfinalproject.serviceview.ReviewServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceViewImpl implements ReviewServiceView {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ReviewMapper reviewMapper;

    @Override
    public List<ReviewReadDto> getAllReviews() {
        return reviewService.getAllReviews().stream()
                .map(reviewMapper::toReviewReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ReviewReadDto> getReviewById(Long id) {
        return reviewService.getReviewById(id)
                .map(reviewMapper::toReviewReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ReviewReadDto createReview(ReviewWriteDto reviewWriteDto) {
        Review review = reviewMapper.toReview(reviewWriteDto);
        Review createdReview = reviewService.createReview(review);
        return reviewMapper.toReviewReadDto(createdReview);
    }

    @Override
    public ResponseEntity<ReviewReadDto> updateReview(Long id, ReviewWriteDto reviewWriteDto) {
        Review review = reviewMapper.toReview(reviewWriteDto);
        return reviewService.updateReview(id, review)
                .map(reviewMapper::toReviewReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteReview(Long id) {
        return reviewService.deleteReview(id);
    }
}
