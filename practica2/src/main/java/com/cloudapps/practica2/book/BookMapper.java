package com.cloudapps.practica2.book;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    BookDTO toDTOs(Book book);

    default Page<BookDTO> toDTOs(Page<Book> page) {
        return page.map(this::toDTOs);
    }

    Book toDomain(BookDTO bookDTO);
}
