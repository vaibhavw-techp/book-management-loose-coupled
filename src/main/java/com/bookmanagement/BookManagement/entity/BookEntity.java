package com.bookmanagement.BookManagement.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    private String title;

    private double price;

    private String publication;

    @ManyToOne
    private AuthorEntity author;
}
