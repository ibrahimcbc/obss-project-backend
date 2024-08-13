package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.electronicDto.ElectronicReadDto;
import org.example.obssfinalproject.dto.electronicDto.ElectronicWriteDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface ElectronicServiceView {

    List<ElectronicReadDto> getAllElectronics();
    ResponseEntity<ElectronicReadDto> getElectronicById(Long id);
    ElectronicReadDto createElectronic(ElectronicWriteDto electronicWriteDto);
    ResponseEntity<ElectronicReadDto> updateElectronic(Long id, ElectronicWriteDto electronicWriteDto);
    ResponseEntity<Void> deleteElectronic(Long id);

    List<ElectronicReadDto> getElectronicsByKeyword(String keyword);

    List<ElectronicReadDto> getElectronicsByCategory(String category);

    List<ElectronicReadDto> getElectronicsByCategoryAndBrand(String category, String brand);
}
