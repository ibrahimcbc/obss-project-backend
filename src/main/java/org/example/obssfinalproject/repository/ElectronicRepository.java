package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectronicRepository extends JpaRepository<Electronic, Long> {

}

