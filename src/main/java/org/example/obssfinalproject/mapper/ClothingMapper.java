package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.clothingDto.ClothingReadDto;
import org.example.obssfinalproject.dto.clothingDto.ClothingWriteDto;
import org.example.obssfinalproject.model.products.Clothing;
import org.springframework.stereotype.Component;

@Component
public class ClothingMapper {

    public ClothingReadDto toClothingReadDto(Clothing clothing) {
        ClothingReadDto dto = new ClothingReadDto();
        dto.setId(clothing.getId());
        dto.setUserId(clothing.getUserId());
        dto.setTitle(clothing.getTitle());
        dto.setExplanation(clothing.getExplanation());
        dto.setImageUrl(clothing.getImageUrl());
        dto.setPrice(clothing.getPrice());
        dto.setAmount(clothing.getAmount());
        dto.setSoldAmount(clothing.getSoldAmount());
        dto.setCategory(clothing.getCategory());
        dto.setBrand(clothing.getBrand());
        dto.setSize(clothing.getSize());
        dto.setColor(clothing.getColor());
        dto.setScore(clothing.getScore());
        return dto;
    }

    public Clothing toClothing(ClothingWriteDto dto) {
        Clothing clothing = new Clothing();
        clothing.setTitle(dto.getTitle());
        clothing.setExplanation(dto.getExplanation());
        clothing.setImageUrl(dto.getImageUrl());
        clothing.setPrice(dto.getPrice());
        clothing.setAmount(dto.getAmount());
        clothing.setCategory(dto.getCategory());
        clothing.setBrand(dto.getBrand());
        clothing.setSize(dto.getSize());
        clothing.setColor(dto.getColor());
        return clothing;
    }
}
