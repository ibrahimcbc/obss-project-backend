package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.products.Clothing;
import org.example.obssfinalproject.repository.ClothingRepository;
import org.example.obssfinalproject.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClothingServiceImpl implements ClothingService {

    @Autowired
    private ClothingRepository clothingRepository;

    @Override
    public List<Clothing> getAllClothing() {
        return clothingRepository.findAll();
    }

    @Override
    public Optional<Clothing> getClothingById(Long id) {
        return clothingRepository.findById(id);
    }

    @Override
    public Clothing createClothing(Clothing clothing) {
        return clothingRepository.save(clothing);
    }

    @Override
    public Optional<Clothing> updateClothing(Long id, Clothing clothingDetails) {
        return clothingRepository.findById(id).map(existingClothing -> {
            existingClothing.setTitle(clothingDetails.getTitle());
            existingClothing.setExplanation(clothingDetails.getExplanation());
            existingClothing.setImageUrl(clothingDetails.getImageUrl());
            existingClothing.setPrice(clothingDetails.getPrice());
            existingClothing.setAmount(clothingDetails.getAmount());
            existingClothing.setSoldAmount(clothingDetails.getSoldAmount());
            existingClothing.setDiscountTag(clothingDetails.getDiscountTag());
            existingClothing.setCategory(clothingDetails.getCategory());
            existingClothing.setBrand(clothingDetails.getBrand());
            existingClothing.setSize(clothingDetails.getSize());
            existingClothing.setColor(clothingDetails.getColor());
            return clothingRepository.save(existingClothing);
        });
    }

    @Override
    public ResponseEntity<Void> deleteClothing(Long id) {
        if (clothingRepository.findById(id).isPresent()){
            clothingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
