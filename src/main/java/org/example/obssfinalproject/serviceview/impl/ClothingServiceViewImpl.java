package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.clothingDto.ClothingReadDto;
import org.example.obssfinalproject.dto.clothingDto.ClothingWriteDto;
import org.example.obssfinalproject.mapper.ClothingMapper;
import org.example.obssfinalproject.model.products.Clothing;
import org.example.obssfinalproject.service.ClothingService;
import org.example.obssfinalproject.serviceview.ClothingServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingServiceViewImpl implements ClothingServiceView {

    @Autowired
    private ClothingService clothingService;

    @Autowired
    private ClothingMapper clothingMapper;

    @Override
    public List<ClothingReadDto> getAllClothing() {
        return clothingService.getAllClothing().stream()
                .map(clothingMapper::toClothingReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ClothingReadDto> getClothingById(Long id) {
        return clothingService.getClothingById(id)
                .map(clothingMapper::toClothingReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ClothingReadDto createClothing(ClothingWriteDto clothingWriteDto) {
        Clothing clothing = clothingMapper.toClothing(clothingWriteDto);
        Clothing createdClothing = clothingService.createClothing(clothing);
        return clothingMapper.toClothingReadDto(createdClothing);
    }

    @Override
    public ResponseEntity<ClothingReadDto> updateClothing(Long id, ClothingWriteDto clothingWriteDto) {
        Clothing clothing = clothingMapper.toClothing(clothingWriteDto);
        return clothingService.updateClothing(id, clothing)
                .map(clothingMapper::toClothingReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteClothing(Long id) {
        return clothingService.deleteClothing(id);
    }
}
