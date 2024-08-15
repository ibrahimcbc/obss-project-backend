package org.example.obssfinalproject.dto.clothingDto;

import lombok.Data;

@Data
public class ClothingWriteDto {
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private String category;
    private String brand;
    private String size;
    private String color;
}
