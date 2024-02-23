package com.bookmanagement.BookManagement.mapper;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.entity.Author;
import com.bookmanagement.BookManagement.entity.Book;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface AuthorMapper {

    AuthorDto toDTO(Author author);

    Author toEntity(AuthorDto authorDto);

    @Mapping(target = "author.name", source = "authorDto.name")
    @Mapping(target = "author.books", source = "authorDto.books")
    void updateAuthor(AuthorDto authorDto, @MappingTarget Author author);

    @AfterMapping
    public default void AfterMap(AuthorDto authorDto, @MappingTarget Author author){
        for(Book book: author.getBooks()) {
            book.setAuthor(author);
        }
    }
}
