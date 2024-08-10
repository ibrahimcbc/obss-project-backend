package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.reviewDto.ReviewReadDto;
import org.example.obssfinalproject.dto.reviewDto.ReviewWriteDto;
import org.example.obssfinalproject.model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public ReviewReadDto toReviewReadDto(Review review) {
        ReviewReadDto dto = new ReviewReadDto();
        dto.setId(review.getId());
        dto.setTitle(review.getTitle());
        dto.setDescription(review.getDescription());
        dto.setScore(review.getScore());
        dto.setUserId(review.getUserId());
        dto.setProductId(review.getProductId());
        return dto;
    }

    public Review toReview(ReviewWriteDto dto) {
        Review review = new Review();
        review.setTitle(dto.getTitle());
        review.setDescription(dto.getDescription());
        review.setScore(dto.getScore());
        review.setUserId(dto.getUserId());
        review.setProductId(dto.getProductId());
        return review;
    }
}
