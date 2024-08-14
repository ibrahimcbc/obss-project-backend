package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.bookDto.BookReadDto;
import org.example.obssfinalproject.dto.bookDto.BookWriteDto;
import org.example.obssfinalproject.dto.clothingDto.ClothingReadDto;
import org.example.obssfinalproject.serviceview.BookServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
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

    @GetMapping("/search/{keyword}")
    public List<BookReadDto> getBooksByKeyword(@PathVariable String keyword) {
        return bookServiceView.getBooksByKeyword(keyword);
    }

    @GetMapping("/category/{category}/author/{author}")
    public List<BookReadDto> getBookByCategoryAndAuthor(@PathVariable String category, @PathVariable String author) {
        return bookServiceView.getBookByCategoryAndAuthor(category, author);
    }

    @GetMapping("/category/{category}")
    public List<BookReadDto> getBookByCategory(@PathVariable String category) {
        return bookServiceView.getBookByCategory(category);
    }

    @PostMapping("/{userId}")
    public BookReadDto createBook(@RequestBody BookWriteDto bookWriteDto, @PathVariable Long userId) {
        return bookServiceView.createBook(bookWriteDto, userId);
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
