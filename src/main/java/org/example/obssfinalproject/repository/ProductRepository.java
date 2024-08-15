package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.model.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitleContainingOrExplanationContainingIgnoreCase(String keyword, String keyword1);
    List<Product> findByUserId(Long userId);
    List<Product> findAllByUserIdNotIn(List<Long> userIds);
}
