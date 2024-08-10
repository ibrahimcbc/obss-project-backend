package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.electronicDto.ElectronicReadDto;
import org.example.obssfinalproject.dto.electronicDto.ElectronicWriteDto;
import org.example.obssfinalproject.serviceview.ElectronicServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/electronics")
public class ElectronicController {

    @Autowired
    private ElectronicServiceView electronicServiceView;

    @GetMapping
    public List<ElectronicReadDto> getAllElectronics() {
        return electronicServiceView.getAllElectronics();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElectronicReadDto> getElectronicById(@PathVariable Long id) {
        return electronicServiceView.getElectronicById(id);
    }

    @PostMapping
    public ElectronicReadDto createElectronic(@RequestBody ElectronicWriteDto electronicWriteDto) {
        return electronicServiceView.createElectronic(electronicWriteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElectronicReadDto> updateElectronic(@PathVariable Long id, @RequestBody ElectronicWriteDto electronicWriteDto) {
        return electronicServiceView.updateElectronic(id, electronicWriteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElectronic(@PathVariable Long id) {
        return electronicServiceView.deleteElectronic(id);
    }
}
