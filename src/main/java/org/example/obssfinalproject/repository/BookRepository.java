package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}

