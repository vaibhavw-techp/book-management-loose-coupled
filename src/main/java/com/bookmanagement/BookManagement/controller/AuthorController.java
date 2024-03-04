package com.bookmanagement.BookManagement.controller;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(@Qualifier("secondAuthorService") AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        authorService.show();
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping()
    public ResponseEntity<AuthorDto> addAuthor(@RequestBody AuthorDto authorDto)
    {
        return ResponseEntity.ok(authorService.addAuthor(authorDto));
    }

    @PutMapping("/{authorId}/books")
    public ResponseEntity<String> assignBooksToAuthor(@PathVariable Long authorId, @RequestBody List<Long> bookIds) {
        try {
            authorService.assignAuthorToBooks(authorId, bookIds);
            return ResponseEntity.ok("Books assigned to author successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
