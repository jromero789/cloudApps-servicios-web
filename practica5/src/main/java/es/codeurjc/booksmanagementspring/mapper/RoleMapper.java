package es.codeurjc.booksmanagementspring.mapper;

import org.mapstruct.Mapper;

import es.codeurjc.booksmanagementspring.dto.RoleCreateDTO;
import es.codeurjc.booksmanagementspring.dto.RoleDTO;
import es.codeurjc.booksmanagementspring.model.Role;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class})
public interface RoleMapper {

    RoleDTO toDTO(Role role);

    Role toDomain(RoleDTO roleDTO);

    Role toDomain(RoleCreateDTO roleDTO);
}
