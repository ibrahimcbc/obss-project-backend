package org.example.obssfinalproject.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {

    private String title;
    private String description;
    private int score;
    private Long userId;
    private Long productId;
}

