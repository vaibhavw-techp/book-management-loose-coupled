package com.bookmanagement.BookManagement.mapper;

import com.bookmanagement.BookManagement.dto.AuthorDto;
import com.bookmanagement.BookManagement.entity.AuthorEntity;
import com.bookmanagement.BookManagement.entity.BookEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = BookMapper.class)
public interface AuthorMapper {

    AuthorDto toDTO(AuthorEntity author);

    AuthorEntity toEntity(AuthorDto authorDto);

    @Mapping(target = "author.name", source = "authorDto.name")
    @Mapping(target = "author.books", source = "authorDto.books")
    void updateAuthor(AuthorDto authorDto, @MappingTarget AuthorEntity author);

    @AfterMapping
    public default void AfterMap(AuthorDto authorDto, @MappingTarget AuthorEntity author){
        for(BookEntity book: author.getBooks()) {
            book.setAuthor(author);
        }
    }
}
