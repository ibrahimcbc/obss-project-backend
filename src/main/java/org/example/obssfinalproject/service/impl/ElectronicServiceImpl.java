package org.example.obssfinalproject.service.impl;


import org.example.obssfinalproject.model.products.Electronic;
import org.example.obssfinalproject.repository.ElectronicRepository;
import org.example.obssfinalproject.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ElectronicServiceImpl implements ElectronicService {

    @Autowired
    private ElectronicRepository electronicRepository;

    @Override
    public List<Electronic> getAllElectronics() {
        return electronicRepository.findAll();
    }

    @Override
    public Optional<Electronic> getElectronicById(Long id) {
        return electronicRepository.findById(id);
    }

    @Override
    public Electronic createElectronic(Electronic electronic) {
        return electronicRepository.save(electronic);
    }

    @Override
    public Optional<Electronic> updateElectronic(Long id, Electronic electronicDetails) {
        return electronicRepository.findById(id).map(existingElectronic -> {
            existingElectronic.setTitle(electronicDetails.getTitle());
            existingElectronic.setExplanation(electronicDetails.getExplanation());
            existingElectronic.setImageUrl(electronicDetails.getImageUrl());
            existingElectronic.setPrice(electronicDetails.getPrice());
            existingElectronic.setAmount(electronicDetails.getAmount());
            existingElectronic.setSoldAmount(electronicDetails.getSoldAmount());
            existingElectronic.setDiscountTag(electronicDetails.getDiscountTag());
            existingElectronic.setCategory(electronicDetails.getCategory());
            existingElectronic.setBrand(electronicDetails.getBrand());
            existingElectronic.setStorage(electronicDetails.getStorage());
            existingElectronic.setRam(electronicDetails.getRam());
            return electronicRepository.save(existingElectronic);
        });
    }

    @Override
    public ResponseEntity<Void> deleteElectronic(Long id) {
        if (electronicRepository.findById(id).isPresent()){
            electronicRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<Electronic> getElectronicsByKeyword(String keyword) {
        return electronicRepository.findByTitleContainingAndExplanationContainingIgnoreCase(keyword,keyword);
    }
}





