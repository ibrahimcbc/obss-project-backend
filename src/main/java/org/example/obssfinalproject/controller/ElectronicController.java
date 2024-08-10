package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.model.products.Electronic;
import org.example.obssfinalproject.service.ElectronicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/electronics")
public class ElectronicController {

    @Autowired
    private ElectronicService electronicService;

    @GetMapping
    public List<Electronic> getAllElectronics() {
        return electronicService.getAllElectronics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Electronic> getElectronicById(@PathVariable Long id) {
        return electronicService.getElectronicById(id);
    }

    @PostMapping
    public Electronic createElectronic(@RequestBody Electronic electronic) {
        return electronicService.createElectronic(electronic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Electronic> updateElectronic(@PathVariable Long id, @RequestBody Electronic electronicDetails) {
        return electronicService.updateElectronic(id, electronicDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectronic(@PathVariable Long id) {
        return electronicService.deleteElectronic(id);
    }
}
