package org.example.obssfinalproject.dto.bookDto;

import lombok.Data;

@Data
public class BookReadDto {
    private Long id;
    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private int soldAmount;
    private String category;
    private String author;
    private String genre;
    private int pageNumber;
    private double score;
}

