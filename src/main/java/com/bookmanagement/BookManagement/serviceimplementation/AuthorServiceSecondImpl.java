package com.bookmanagement.BookManagement.serviceimplementation;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.entity.AuthorEntity;
import com.bookmanagement.BookManagement.entity.BookEntity;
import com.bookmanagement.BookManagement.mapper.AuthorMapper;
import com.bookmanagement.BookManagement.repository.AuthorRepository;
import com.bookmanagement.BookManagement.service.AuthorService;
import com.bookmanagement.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("secondAuthorService")
public class AuthorServiceSecondImpl implements AuthorService {
    private AuthorRepository authorRepository;
    private AuthorMapper authorMapper;

    private BookService bookService;

    @Autowired
    public AuthorServiceSecondImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDto addAuthor(AuthorDto authorDto) {
        AuthorEntity authorEntity = authorMapper.toEntity(authorDto);
        AuthorEntity savedAuthorEntity = authorRepository.save(authorEntity);
        return authorMapper.toDTO(savedAuthorEntity);
    }

    @Override
    public void assignAuthorToBooks(Long authorId, List<Long> bookIds) {
        AuthorEntity author = authorRepository.findById(authorId)
                .orElseThrow(() -> new IllegalArgumentException("Author not found with ID: " + authorId));

        bookService.assignAuthorToBooks(author, bookIds);
    }

    @Override
    public void show(){
        System.out.println("In Second Author Service");
    }

}
