package org.example.obssfinalproject.dto.productDto;

import lombok.Data;

@Data
public class ProductReadDto {
    private Long id;
    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private int soldAmount;
    private String category;
    private double score;
}
