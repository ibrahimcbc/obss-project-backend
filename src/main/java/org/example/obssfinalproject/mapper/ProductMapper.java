package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.model.products.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductReadDto toProductReadDto(Product product) {
        ProductReadDto dto = new ProductReadDto();
        dto.setId(product.getId());
        dto.setUserId(product.getUserId());
        dto.setTitle(product.getTitle());
        dto.setExplanation(product.getExplanation());
        dto.setImageUrl(product.getImageUrl());
        dto.setPrice(product.getPrice());
        dto.setAmount(product.getAmount());
        dto.setSoldAmount(product.getSoldAmount());
        dto.setDiscountTag(product.getDiscountTag());
        dto.setCategory(product.getCategory());
        dto.setScore(product.getScore());
        return dto;
    }
}
