package org.example.obssfinalproject.model.products;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Clothing extends Product {

    private String brand;
    private String size;
    private String color;
}

