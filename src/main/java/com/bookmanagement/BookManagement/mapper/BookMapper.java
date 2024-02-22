package com.bookmanagement.BookManagement.mapper;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "publication", source = "publication")
    BookDto toDTO(Book book);


    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "publication", source = "publication")
    Book toEntity(BookDto dto);


    List<Book> getEntityList(List<BookDto> bookDtos);


}
