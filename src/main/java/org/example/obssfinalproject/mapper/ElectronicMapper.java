package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.electronicDto.ElectronicReadDto;
import org.example.obssfinalproject.dto.electronicDto.ElectronicWriteDto;
import org.example.obssfinalproject.model.products.Electronic;
import org.springframework.stereotype.Component;

@Component
public class ElectronicMapper {

    public ElectronicReadDto toElectronicReadDto(Electronic electronic) {
        ElectronicReadDto dto = new ElectronicReadDto();
        dto.setId(electronic.getId());
        dto.setUserId(electronic.getUserId());
        dto.setTitle(electronic.getTitle());
        dto.setExplanation(electronic.getExplanation());
        dto.setImageUrl(electronic.getImageUrl());
        dto.setPrice(electronic.getPrice());
        dto.setAmount(electronic.getAmount());
        dto.setSoldAmount(electronic.getSoldAmount());
        dto.setDiscountTag(electronic.getDiscountTag());
        dto.setCategory(electronic.getCategory());
        dto.setBrand(electronic.getBrand());
        dto.setStorage(electronic.getStorage());
        dto.setRam(electronic.getRam());
        dto.setScore(electronic.getScore());
        return dto;
    }

    public Electronic toElectronic(ElectronicWriteDto dto) {
        Electronic electronic = new Electronic();
        electronic.setUserId(dto.getUserId());
        electronic.setTitle(dto.getTitle());
        electronic.setExplanation(dto.getExplanation());
        electronic.setImageUrl(dto.getImageUrl());
        electronic.setPrice(dto.getPrice());
        electronic.setAmount(dto.getAmount());
        electronic.setDiscountTag(dto.getDiscountTag());
        electronic.setCategory(dto.getCategory());
        electronic.setBrand(dto.getBrand());
        electronic.setStorage(dto.getStorage());
        electronic.setRam(dto.getRam());
        return electronic;
    }
}
