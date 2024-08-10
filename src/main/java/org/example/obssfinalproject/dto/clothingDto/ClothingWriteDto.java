package org.example.obssfinalproject.dto.clothingDto;

import lombok.Data;
import org.example.obssfinalproject.model.products.Discount;

import java.util.Set;

@Data
public class ClothingWriteDto {
    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private Set<Discount> discountTag;
    private String category;
    private String brand;
    private String size;
    private String color;
}
