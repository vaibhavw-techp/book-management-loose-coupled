package com.bookmanagement.BookManagement.service;

import com.bookmanagement.BookManagement.dto.AuthorDto;

import java.util.List;


public interface AuthorService {
    List<AuthorDto> getAllAuthors();

    AuthorDto addAuthor(AuthorDto authorDto);

    void assignAuthorToBooks(Long authorId, List<Long> bookIds);

    void show();
}
