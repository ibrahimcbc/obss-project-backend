package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.dto.productDto.ProductWriteDto;
import org.example.obssfinalproject.model.products.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        dto.setScore(product.getScore());
        dto.setCategory(product.getCategory());
        return dto;
    }

    public List<ProductReadDto> toProductReadDtoList(List<Product> products) {
        List<ProductReadDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            dtoList.add(toProductReadDto(product));
        }
        return dtoList;
    }

    public Product toProduct(ProductWriteDto dto) {
        Product product = new Product();
        product.setTitle(dto.getTitle());
        product.setExplanation(dto.getExplanation());
        product.setImageUrl(dto.getImageUrl());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        return product;
    }
}
