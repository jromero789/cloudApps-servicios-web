package com.cloudapps.practica2.book;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    List<BookDTO> toDTOs(Collection<Book> books);

    Book toDomain(BookDTO bookDTO);
}
