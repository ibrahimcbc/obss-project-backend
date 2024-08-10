package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.clothingDto.ClothingReadDto;
import org.example.obssfinalproject.dto.clothingDto.ClothingWriteDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ClothingServiceView {

    List<ClothingReadDto> getAllClothing();
    ResponseEntity<ClothingReadDto> getClothingById(Long id);
    ClothingReadDto createClothing(ClothingWriteDto clothingWriteDto);
    ResponseEntity<ClothingReadDto> updateClothing(Long id, ClothingWriteDto clothingWriteDto);
    ResponseEntity<Void> deleteClothing(Long id);
}
