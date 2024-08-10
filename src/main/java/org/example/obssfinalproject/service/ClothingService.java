package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Clothing;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ClothingService {

    List<Clothing> getAllClothing();
    ResponseEntity<Clothing> getClothingById(Long id);
    Clothing createClothing(Clothing clothing);
    ResponseEntity<Clothing> updateClothing(Long id, Clothing clothingDetails);
    ResponseEntity<Void> deleteClothing(Long id);
}
