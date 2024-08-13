package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Clothing;
import org.springframework.http.ResponseEntity;



import java.util.List;
import java.util.Optional;

public interface ClothingService {
    List<Clothing> getAllClothing();
    Optional<Clothing> getClothingById(Long id);
    Clothing createClothing(Clothing clothing);
    Optional<Clothing> updateClothing(Long id, Clothing clothingDetails);
    ResponseEntity<Void> deleteClothing(Long id);

    List<Clothing> searchClothing(String keyword);

    List<Clothing> getClothingByCategory(String category);

    List<Clothing> getClothingByCategoryAndBrand(String category, String brand);
}