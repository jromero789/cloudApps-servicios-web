package com.cloudapps.practica2.book;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDTO toDTO(Book book);

    default Page<BookDTO> toDTOs(Page<Book> page) {
        return page.map(this::toDTO);
    }

    Book toDomain(BookDTO bookDTO);

    BookMinInfoDTO minInfoToDTO(Book book);

    default Page<BookMinInfoDTO> minInfoToDTOs(Page<Book> page) {
        return page.map(this::minInfoToDTO);
    }
}
