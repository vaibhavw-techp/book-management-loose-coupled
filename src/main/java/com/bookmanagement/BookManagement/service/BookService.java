package com.bookmanagement.BookManagement.service;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.AuthorEntity;
import com.bookmanagement.BookManagement.entity.BookEntity;

import java.util.List;


public interface BookService {
    List<BookDto> getAllBooks();
    public void assignAuthorToBooks(AuthorEntity author, List<Long> bookIds);
    public List<BookDto> addBooks(List<BookDto> bookDtos);
    void show();
}
