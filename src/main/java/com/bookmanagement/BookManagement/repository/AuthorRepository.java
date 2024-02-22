package com.bookmanagement.BookManagement.repository;

import com.bookmanagement.BookManagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}
