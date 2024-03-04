package com.bookmanagement.BookManagement.mapper;

import com.bookmanagement.BookManagement.dto.BookDto;
import com.bookmanagement.BookManagement.entity.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "publication", source = "publication")
    BookDto toDTO(BookEntity book);


    @Mapping(target = "title", source = "title")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "publication", source = "publication")
    BookEntity toEntity(BookDto dto);


    List<BookEntity> mapDtosToEntities(List<BookDto> bookDtos);


}
