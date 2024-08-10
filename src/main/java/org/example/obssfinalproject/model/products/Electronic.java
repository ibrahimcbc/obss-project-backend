package org.example.obssfinalproject.model.products;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Electronic extends Product {

    private String brand;
    private double storage;
    private int RAM;
}

