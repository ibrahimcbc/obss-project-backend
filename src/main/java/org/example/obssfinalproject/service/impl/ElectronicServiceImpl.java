package org.example.obssfinalproject.service.impl;

import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.model.products.Electronic;
import org.example.obssfinalproject.repository.ElectronicRepository;
import org.example.obssfinalproject.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ElectronicServiceImpl implements ElectronicService {

    @Autowired
    private ElectronicRepository electronicRepository;

    @Override
    public List<Electronic> getAllElectronics() {
        return electronicRepository.findAll();
    }

    @Override
    public ResponseEntity<Electronic> getElectronicById(Long id) {
        Electronic electronic = electronicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Electronic not found"));
        return ResponseEntity.ok().body(electronic);
    }

    @Override
    public Electronic createElectronic(Electronic electronic) {
        return electronicRepository.save(electronic);
    }

    @Override
    public ResponseEntity<Electronic> updateElectronic(Long id, Electronic electronicDetails) {
        Electronic electronic = electronicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Electronic not found"));

        electronic.setBrand(electronicDetails.getBrand());
        electronic.setStorage(electronicDetails.getStorage());
        electronic.setRAM(electronicDetails.getRAM());

        final Electronic updatedElectronic = electronicRepository.save(electronic);
        return ResponseEntity.ok(updatedElectronic);
    }

    @Override
    public ResponseEntity<Void> deleteElectronic(Long id) {
        Electronic electronic = electronicRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Electronic not found"));
        electronicRepository.delete(electronic);
        return ResponseEntity.noContent().build();
    }
}

