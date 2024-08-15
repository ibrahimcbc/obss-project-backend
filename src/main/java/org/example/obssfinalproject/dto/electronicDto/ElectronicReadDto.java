package org.example.obssfinalproject.dto.electronicDto;

import lombok.Data;

@Data
public class ElectronicReadDto {
    private Long id;
    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private int soldAmount;
    private String category;
    private String brand;
    private double storage;
    private int ram;
    private double score;
}
