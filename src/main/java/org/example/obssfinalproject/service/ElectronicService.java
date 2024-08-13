package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Electronic;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ElectronicService {
    List<Electronic> getAllElectronics();
    Optional<Electronic> getElectronicById(Long id);
    Electronic createElectronic(Electronic electronic);
    Optional<Electronic> updateElectronic(Long id, Electronic electronicDetails);
    ResponseEntity<Void> deleteElectronic(Long id);

    List<Electronic> getElectronicsByKeyword(String keyword);

    List<Electronic> getElectronicsByCategory(String category);

    List<Electronic> getElectronicsByCategoryAndBrand(String category, String brand);
}
