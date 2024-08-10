package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Clothing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingRepository extends JpaRepository<Clothing, Long> {
}

