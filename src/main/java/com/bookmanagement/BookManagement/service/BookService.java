package com.bookmanagement.BookManagement.service;

import com.bookmanagement.BookManagement.dto.BookDto;

import java.util.List;


public interface BookService {
    List<BookDto> getAllBooks();
}
