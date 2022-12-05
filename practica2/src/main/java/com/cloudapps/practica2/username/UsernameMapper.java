package com.cloudapps.practica2.username;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UsernameMapper {

    UsernameDTO toDTO(Username username);

    default Page<UsernameDTO> toDTOs(Page<Username> page) {
        return page.map(this::toDTO);
    }

    Username toDomain(UsernameDTO usernameDTO);
}
