package com.bookmanagement.BookManagement.service;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.dto.BookDto;

import java.util.List;


public interface AuthorService {
    List<AuthorDto> getAllAuthors();

    List<BookDto> getBooksByAuthorId(Long authorId);

    AuthorDto createAuthorBook(AuthorDto authorDto);
}
