package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Electronic;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ElectronicService {

    List<Electronic> getAllElectronics();
    ResponseEntity<Electronic> getElectronicById(Long id);
    Electronic createElectronic(Electronic electronic);
    ResponseEntity<Electronic> updateElectronic(Long id, Electronic electronicDetails);
    ResponseEntity<Void> deleteElectronic(Long id);
}
