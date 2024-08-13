package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.bookDto.BookReadDto;
import org.example.obssfinalproject.dto.bookDto.BookWriteDto;
import org.example.obssfinalproject.mapper.BookMapper;
import org.example.obssfinalproject.model.products.Book;
import org.example.obssfinalproject.service.BookService;
import org.example.obssfinalproject.serviceview.BookServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceViewImpl implements BookServiceView {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookReadDto> getAllBooks() {
        return bookService.getAllBook().stream()
                .map(bookMapper::toBookReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseEntity<BookReadDto> getBookById(Long id) {
        return bookService.getBookById(id)
                .map(bookMapper::toBookReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Override
    public BookReadDto createBook(BookWriteDto bookWriteDto) {
        Book book = bookMapper.toBook(bookWriteDto);
        Book createdBook = bookService.createBook(book);
        return bookMapper.toBookReadDto(createdBook);
    }

    @Override
    public ResponseEntity<BookReadDto> updateBook(Long id, BookWriteDto bookWriteDto) {
        Book book = bookMapper.toBook(bookWriteDto);
        return bookService.updateBook(id, book)
                .map(bookMapper::toBookReadDto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }



    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        return bookService.deleteBook(id);
    }

    @Override
    public List<BookReadDto> getBooksByKeyword(String keyword) {
        return bookService.getBooksByKeyword(keyword).stream()
                .map(bookMapper::toBookReadDto)
                .collect(Collectors.toList());
    }
}

