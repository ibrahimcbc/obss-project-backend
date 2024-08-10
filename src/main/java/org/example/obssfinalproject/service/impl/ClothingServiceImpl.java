package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.products.Clothing;
import org.example.obssfinalproject.repository.ClothingRepository;
import org.example.obssfinalproject.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClothingServiceImpl implements ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    @Override
    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    @Override
    public ResponseEntity<Clothing> getClothingById(Long id) {
        Clothing clothing = clothingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clothing not found"));
        return ResponseEntity.ok().body(clothing);
    }

    @Override
    public Clothing createClothing(Clothing clothing) {
        return clothingRepository.save(clothing);
    }

    @Override
    public ResponseEntity<Clothing> updateClothing(Long id, Clothing clothingDetails) {
        Clothing clothing = clothingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clothing not found"));

        clothing.setBrand(clothingDetails.getBrand());
        clothing.setSize(clothingDetails.getSize());
        clothing.setColor(clothingDetails.getColor());

        final Clothing updatedClothing = clothingRepository.save(clothing);
        return ResponseEntity.ok(updatedClothing);
    }

    @Override
    public ResponseEntity<Void> deleteClothing(Long id) {
        Clothing clothing = clothingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Clothing not found"));
        clothingRepository.delete(clothing);
        return ResponseEntity.noContent().build();
    }
}
