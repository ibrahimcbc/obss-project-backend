package org.example.obssfinalproject.mapper;

import org.example.obssfinalproject.dto.bookDto.BookReadDto;
import org.example.obssfinalproject.dto.bookDto.BookWriteDto;
import org.example.obssfinalproject.model.products.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookReadDto toBookReadDto(Book book) {
        BookReadDto dto = new BookReadDto();
        dto.setId(book.getId());
        dto.setUserId(book.getUserId());
        dto.setTitle(book.getTitle());
        dto.setExplanation(book.getExplanation());
        dto.setImageUrl(book.getImageUrl());
        dto.setPrice(book.getPrice());
        dto.setAmount(book.getAmount());
        dto.setSoldAmount(book.getSoldAmount());
        dto.setDiscountTag(book.getDiscountTag());
        dto.setCategory(book.getCategory());
        dto.setAuthor(book.getAuthor());
        dto.setGenre(book.getGenre());
        dto.setPageNumber(book.getPageNumber());
        dto.setScore(book.getScore());
        return dto;
    }

    public Book toBook(BookWriteDto dto) {
        Book book = new Book();
        book.setUserId(dto.getUserId());
        book.setTitle(dto.getTitle());
        book.setExplanation(dto.getExplanation());
        book.setImageUrl(dto.getImageUrl());
        book.setPrice(dto.getPrice());
        book.setAmount(dto.getAmount());
        book.setDiscountTag(dto.getDiscountTag());
        book.setCategory(dto.getCategory());
        book.setAuthor(dto.getAuthor());
        book.setGenre(dto.getGenre());
        book.setPageNumber(dto.getPageNumber());
        return book;
    }
}

