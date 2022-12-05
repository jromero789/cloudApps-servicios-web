package com.cloudapps.practica2.username;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsernameMapper {

    UsernameDTO toDTO(Username username);

    List<UsernameDTO> toDTOs(Collection<Username> usernames);

    Username toDomain(UsernameDTO usernameDTO);
}
