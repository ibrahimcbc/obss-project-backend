package org.example.obssfinalproject.dto.reviewDto;

import lombok.Data;

@Data
public class ReviewReadDto {
    private Long id;
    private String title;
    private String description;
    private int score;
    private Long userId;
    private Long productId;
}
