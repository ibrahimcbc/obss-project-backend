package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.clothingDto.ClothingReadDto;
import org.example.obssfinalproject.dto.clothingDto.ClothingWriteDto;
import org.example.obssfinalproject.dto.electronicDto.ElectronicReadDto;
import org.example.obssfinalproject.serviceview.ClothingServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController {

    @Autowired
    private ClothingServiceView clothingServiceView;

    @GetMapping
    public List<ClothingReadDto> getAllClothing() {
        return clothingServiceView.getAllClothing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothingReadDto> getClothingById(@PathVariable Long id) {
        return clothingServiceView.getClothingById(id);
    }

    @GetMapping("/search/{keyword}")
    public List<ClothingReadDto> searchClothing(@PathVariable String keyword) {
        return clothingServiceView.searchClothing(keyword);
    }

    @GetMapping("/category/{category}")
    public List<ClothingReadDto> getClothingByCategory(@PathVariable String category) {
        return clothingServiceView.getClothingByCategory(category);
    }

    @GetMapping("/category/{category}/brand/{brand}")
    public List<ClothingReadDto> getClothingByCategoryAndBrand(@PathVariable String category, @PathVariable String brand) {
        return clothingServiceView.getClothingByCategoryAndBrand(category, brand);
    }


    @PostMapping
    public ClothingReadDto createClothing(@RequestBody ClothingWriteDto clothingWriteDto) {
        return clothingServiceView.createClothing(clothingWriteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothingReadDto> updateClothing(@PathVariable Long id, @RequestBody ClothingWriteDto clothingWriteDto) {
        return clothingServiceView.updateClothing(id, clothingWriteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothing(@PathVariable Long id) {
        return clothingServiceView.deleteClothing(id);
    }
}
