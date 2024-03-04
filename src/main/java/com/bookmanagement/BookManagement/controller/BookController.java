package com.bookmanagement.BookManagement.controller;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("bookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        bookService.show();
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping()
    public ResponseEntity<List<BookDto>> addBooks(@RequestBody List<BookDto> bookDtos) {
        try {
            List<BookDto> createdBooks = bookService.addBooks(bookDtos);
            return ResponseEntity.ok(createdBooks);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
