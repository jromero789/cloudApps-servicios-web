package com.cloudapps.practica2.username;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

@Mapper(componentModel = "spring")
public interface UsernameMapper {

    UsernameDTO toDTO(Username username);

    UsernameDTO toDTOs(Username username);

    default Page<UsernameDTO> toDTOs(Page<Username> page) {
        return page.map(this::toDTOs);
    }

    Username toDomain(UsernameDTO usernameDTO);
}
