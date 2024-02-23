package com.bookmanagement.BookManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "book_tbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    private String title;

    private double price;

    private String publication;

    @ManyToOne
    private Author author;
}
