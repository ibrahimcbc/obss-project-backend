package org.example.obssfinalproject.dto.electronicDto;

import lombok.Data;

@Data
public class ElectronicWriteDto {
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private String category;
    private String brand;
    private double storage;
    private int ram;
}

