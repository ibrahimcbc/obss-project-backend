package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectronicRepository extends JpaRepository<Electronic, Long> {

    List<Electronic> findByTitleContainingAndExplanationContainingIgnoreCase(String keyword, String keyword1);
}

