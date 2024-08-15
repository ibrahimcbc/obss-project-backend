package org.example.obssfinalproject.model.products;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.example.obssfinalproject.model.BaseEntity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product extends BaseEntity {

    private Long userId;
    private String title;
    private String explanation;
    private String imageUrl;
    private double price;
    private int amount;
    private int soldAmount;
    private double score;


    private String category;
}
