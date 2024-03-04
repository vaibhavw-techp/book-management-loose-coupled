package com.bookmanagement.BookManagement.serviceimplementation;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.AuthorEntity;
import com.bookmanagement.BookManagement.mapper.AuthorMapper;
import com.bookmanagement.BookManagement.mapper.BookMapper;
import com.bookmanagement.BookManagement.repository.AuthorRepository;
import com.bookmanagement.BookManagement.repository.BookRepository;
import com.bookmanagement.BookManagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("secondAuthorService")
public class AuthorServiceSecondImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public AuthorServiceSecondImpl(AuthorRepository authorRepository, AuthorMapper authorMapper,
                             BookRepository bookRepository, BookMapper bookMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<AuthorDto> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }


    @Override
    public AuthorDto createAuthorBook(AuthorDto authorDto){
        AuthorEntity author = new AuthorEntity();
        authorMapper.updateAuthor(authorDto,author);
        authorRepository.save(author);
        return authorMapper.toDTO(author);
    }

    @Override
    public List<BookDto> getBooksByAuthorId(Long authorId) {
        return bookRepository.findByAuthorId(authorId).stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public void show(){
        System.out.println("In Second Author Service");
    }

}
