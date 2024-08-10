package org.example.obssfinalproject.service;

import org.example.obssfinalproject.model.products.Book;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BookService {

    List<Book> getAllBook();
    ResponseEntity<Book> getBookById(Long id);
    Book createBook(Book book);
    ResponseEntity<Book> updateBook(Long id, Book bookDetails);
    ResponseEntity<Void> deleteBook(Long id);
}
