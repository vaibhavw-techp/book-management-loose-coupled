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

    @Mapping(target = "name", source = "author.name")
    AuthorDto toDTO(AuthorEntity author);
    @Mapping(target = "name", source = "authorDto.name")
    AuthorEntity toEntity(AuthorDto authorDto);
}
