package org.example.obssfinalproject.repository;

import org.example.obssfinalproject.model.products.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingOrExplanationContainingIgnoreCase(String keyword, String keyword2);

    List<Book> findByCategoryIgnoreCase(String category);

    List<Book> findByCategoryIgnoreCaseAndAuthorIgnoreCase(String category, String author);
}

