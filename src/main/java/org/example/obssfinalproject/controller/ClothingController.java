package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.model.products.Clothing;
import org.example.obssfinalproject.service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clothing")
public class ClothingController {

    @Autowired
    private ClothingService clothingService;

    @GetMapping
    public List<Clothing> getAllClothing() {
        return clothingService.getAllClothing();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clothing> getClothingById(@PathVariable Long id) {
        return clothingService.getClothingById(id);
    }

    @PostMapping
    public Clothing createClothing(@RequestBody Clothing clothing) {
        return clothingService.createClothing(clothing);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clothing> updateClothing(@PathVariable Long id, @RequestBody Clothing clothingDetails) {
        return clothingService.updateClothing(id, clothingDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClothing(@PathVariable Long id) {
        return clothingService.deleteClothing(id);
    }
}

