package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {
    List<Clothing> findByTitleContainingOrExplanationContainingIgnoreCase(String keyword, String keyword2);

    List<Clothing> findByCategoryEqualsAndBrandContainingIgnoreCase(String category, String brand);

    List<Clothing> findByCategoryIgnoreCase(String category);
}

