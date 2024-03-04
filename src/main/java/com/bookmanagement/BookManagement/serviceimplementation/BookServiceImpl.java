package com.bookmanagement.BookManagement.serviceimplementation;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.AuthorEntity;
import com.bookmanagement.BookManagement.entity.BookEntity;
import com.bookmanagement.BookManagement.mapper.BookMapper;
import com.bookmanagement.BookManagement.repository.BookRepository;
import com.bookmanagement.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("bookService")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> temp = bookRepository.findAll();
        return temp.stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public void assignAuthorToBooks(AuthorEntity author, List<Long> bookIds) {
        List<BookEntity> books = bookRepository.findAllById(bookIds);
        if (books.size() != bookIds.size()) {
            throw new IllegalArgumentException("One or more book IDs are invalid");
        }

        for (BookEntity book : books) {
            book.setAuthor(author);
        }

        bookRepository.saveAll(books);
    }

    @Override
    public void show(){
        System.out.println("In First Book Service");
    }
}
