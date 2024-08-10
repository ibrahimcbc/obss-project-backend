package org.example.obssfinalproject.dto.bookDto;

import lombok.Data;
import org.example.obssfinalproject.model.products.Discount;

import java.util.Set;

@Data
public class BookWriteDto {
    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private Set<Discount> discountTag;
    private String category;
    private String author;
    private String genre;
    private int pageNumber;
}

