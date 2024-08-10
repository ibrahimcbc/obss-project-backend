package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.bookDto.BookReadDto;
import org.example.obssfinalproject.dto.bookDto.BookWriteDto;
import org.example.obssfinalproject.serviceview.BookServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookServiceView bookServiceView;

    @GetMapping
    public List<BookReadDto> getAllBooks() {
        return bookServiceView.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReadDto> getBookById(@PathVariable Long id) {
        return bookServiceView.getBookById(id);
    }

    @PostMapping
    public BookReadDto createBook(@RequestBody BookWriteDto bookWriteDto) {
        return bookServiceView.createBook(bookWriteDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookReadDto> updateBook(@PathVariable Long id, @RequestBody BookWriteDto bookWriteDto) {
        return bookServiceView.updateBook(id, bookWriteDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        return bookServiceView.deleteBook(id);
    }
}
