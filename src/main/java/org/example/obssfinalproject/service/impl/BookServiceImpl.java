package org.example.obssfinalproject.service.impl;


import org.example.obssfinalproject.model.products.Book;
import org.example.obssfinalproject.repository.BookRepository;
import org.example.obssfinalproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book createBook(Book book, Long userId) {
        book.setUserId(userId);
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> updateBook(Long id, Book bookDetails) {
        return bookRepository.findById(id).map(existingBook -> {
            existingBook.setTitle(bookDetails.getTitle());
            existingBook.setExplanation(bookDetails.getExplanation());
            existingBook.setImageUrl(bookDetails.getImageUrl());
            existingBook.setPrice(bookDetails.getPrice());
            existingBook.setAmount(bookDetails.getAmount());
            existingBook.setSoldAmount(bookDetails.getSoldAmount());
            existingBook.setDiscountTag(bookDetails.getDiscountTag());
            existingBook.setCategory(bookDetails.getCategory());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setGenre(bookDetails.getGenre());
            existingBook.setPageNumber(bookDetails.getPageNumber());
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        if (bookRepository.findById(id).isPresent()){
            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public List<Book> getBooksByKeyword(String keyword) {
        return bookRepository.findByTitleContainingOrExplanationContainingIgnoreCase(keyword, keyword);
    }

    @Override
    public List<Book> getBookByCategory(String category) {
        return bookRepository.findByCategoryIgnoreCase(category);
    }

    @Override
    public List<Book> getBookByCategoryAndAuthor(String category, String author) {
        return bookRepository.findByCategoryIgnoreCaseAndAuthorIgnoreCase(category, author);
    }

}
