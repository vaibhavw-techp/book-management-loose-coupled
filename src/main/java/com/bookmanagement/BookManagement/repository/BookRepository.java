package com.bookmanagement.BookManagement.repository;

import com.bookmanagement.BookManagement.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
    List<BookEntity> findByAuthorId(Long authorId);
}
