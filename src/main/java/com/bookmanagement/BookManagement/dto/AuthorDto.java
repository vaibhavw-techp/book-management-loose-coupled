package com.bookmanagement.BookManagement.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String name;
    private List<BookDto> books;
}
