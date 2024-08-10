package org.example.obssfinalproject.model.products;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book extends Product {

    private String author;
    private String category;
    private String genre;
    private int pageNumber;
}

