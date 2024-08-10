package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Book;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> getAllBook();
    Optional<Book> getBookById(Long id);
    Book createBook(Book book);
    Optional<Book> updateBook(Long id, Book bookDetails);
    ResponseEntity<Void> deleteBook(Long id);
}
