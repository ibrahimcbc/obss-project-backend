package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.reviewDto.ReviewReadDto;
import org.example.obssfinalproject.dto.reviewDto.ReviewWriteDto;
import org.example.obssfinalproject.serviceview.ReviewServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewServiceView reviewServiceView;

    @GetMapping
    public List<ReviewReadDto> getAllReviews() {
        return reviewServiceView.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewReadDto> getReviewById(@PathVariable Long id) {
        return reviewServiceView.getReviewById(id);
    }

    @GetMapping("/byProductId/{id}")
    public List<ReviewReadDto> getReviewsByProductId(@PathVariable Long id) {
        return reviewServiceView.getReviewsByProductId(id);
    }

    @GetMapping("/byUserId/{id}")
    public List<ReviewReadDto> getReviewsByUserId(@PathVariable Long id) {
        return reviewServiceView.getReviewsByUserId(id);
    }

    @PostMapping("{userId}/{productId}")
    public ReviewReadDto createReview(@RequestBody ReviewWriteDto reviewWriteDto, @PathVariable Long userId, @PathVariable Long productId) {
        return reviewServiceView.createReview(reviewWriteDto, userId, productId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewReadDto> updateReview(@PathVariable Long id, @RequestBody ReviewWriteDto reviewWriteDto) {
        return reviewServiceView.updateReview(id, reviewWriteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        return reviewServiceView.deleteReview(id);
    }
}


