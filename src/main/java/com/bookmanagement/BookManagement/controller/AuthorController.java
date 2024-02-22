package com.bookmanagement.BookManagement.controller;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.mapper.AuthorMapper;
import com.bookmanagement.BookManagement.repository.AuthorRepository;
import com.bookmanagement.BookManagement.repository.BookRepository;
import com.bookmanagement.BookManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;
    private AuthorRepository authorRepository;

    private BookRepository bookRepository;
    private AuthorMapper authorMapper;


    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    // To create Author and Books
    @PostMapping("/books")
    public ResponseEntity<AuthorDto> createAuthorBook(@RequestBody AuthorDto authorDto)
    {
        return ResponseEntity.ok(authorService.createAuthorBook(authorDto));

    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<BookDto>> getBooksByAuthorId(@PathVariable Long authorId) {
        return ResponseEntity.ok(authorService.getBooksByAuthorId(authorId));
    }
}
