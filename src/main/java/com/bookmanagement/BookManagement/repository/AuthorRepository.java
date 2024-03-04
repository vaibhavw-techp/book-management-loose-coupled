package com.bookmanagement.BookManagement.repository;

import com.bookmanagement.BookManagement.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

}
