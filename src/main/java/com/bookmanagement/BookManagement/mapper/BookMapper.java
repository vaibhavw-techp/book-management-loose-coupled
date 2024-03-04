package com.bookmanagement.BookManagement.mapper;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "title", source = "book.title")
    @Mapping(target = "price", source = "book.price")
    @Mapping(target = "publication", source = "book.publication")
    BookDto toDTO(BookEntity book);

    @Mapping(target = "title", source = "dto.title")
    @Mapping(target = "price", source = "dto.price")
    @Mapping(target = "publication", source = "dto.publication")
    BookEntity toEntity(BookDto dto);

    List<BookEntity> mapDtosToEntities(List<BookDto> bookDtos);
}
