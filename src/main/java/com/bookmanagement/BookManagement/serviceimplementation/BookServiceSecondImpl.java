package com.bookmanagement.BookManagement.serviceimplementation;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.BookEntity;
import com.bookmanagement.BookManagement.mapper.BookMapper;
import com.bookmanagement.BookManagement.repository.BookRepository;
import com.bookmanagement.BookManagement.service.AuthorService;
import com.bookmanagement.BookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("secondBookService")
public class BookServiceSecondImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Autowired
    public BookServiceSecondImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<BookEntity> temp = bookRepository.findAll();
        return temp.stream().map(bookMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public void show(){
        System.out.println("In Second Book Service");
    }
}
