package org.example.obssfinalproject.dto.productDto;

import lombok.Data;
import org.example.obssfinalproject.model.products.Discount;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Discount> discountTag = new HashSet<>();
    private String category;
    private double score;
}
