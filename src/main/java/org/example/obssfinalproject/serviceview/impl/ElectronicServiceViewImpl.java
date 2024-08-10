package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.electronicDto.ElectronicReadDto;
import org.example.obssfinalproject.dto.electronicDto.ElectronicWriteDto;
import org.example.obssfinalproject.mapper.ElectronicMapper;
import org.example.obssfinalproject.model.products.Electronic;
import org.example.obssfinalproject.service.ElectronicService;
import org.example.obssfinalproject.serviceview.ElectronicServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ElectronicServiceViewImpl implements ElectronicServiceView {

    @Autowired
    private ElectronicService electronicService;

    @Autowired
    private ElectronicMapper electronicMapper;

    @Override
    public List<ElectronicReadDto> getAllElectronics() {
        return electronicService.getAllElectronics().stream()
                .map(electronicMapper::toElectronicReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<ElectronicReadDto> getElectronicById(Long id) {
        return electronicService.getElectronicById(id)
                .map(electronicMapper::toElectronicReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ElectronicReadDto createElectronic(ElectronicWriteDto electronicWriteDto) {
        Electronic electronic = electronicMapper.toElectronic(electronicWriteDto);
        Electronic createdElectronic = electronicService.createElectronic(electronic);
        return electronicMapper.toElectronicReadDto(createdElectronic);
    }

    @Override
    public ResponseEntity<ElectronicReadDto> updateElectronic(Long id, ElectronicWriteDto electronicWriteDto) {
        Electronic electronic = electronicMapper.toElectronic(electronicWriteDto);
        return electronicService.updateElectronic(id, electronic)
                .map(electronicMapper::toElectronicReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Void> deleteElectronic(Long id) {
        return electronicService.deleteElectronic(id);
    }
}

