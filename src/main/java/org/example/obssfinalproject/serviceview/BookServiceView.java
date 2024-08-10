package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.bookDto.BookReadDto;
import org.example.obssfinalproject.dto.bookDto.BookWriteDto;
import org.springframework.http.ResponseEntity;
import java.util.List;

public interface BookServiceView {

    List<BookReadDto> getAllBooks();
    ResponseEntity<BookReadDto> getBookById(Long id);
    BookReadDto createBook(BookWriteDto bookWriteDto);
    ResponseEntity<BookReadDto> updateBook(Long id, BookWriteDto bookWriteDto);
    ResponseEntity<Void> deleteBook(Long id);
}
