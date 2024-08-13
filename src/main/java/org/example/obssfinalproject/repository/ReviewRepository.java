package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByProductId(Long id);

    List<Review> findByUserId(Long id);
}

