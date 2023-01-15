package es.codeurjc.booksmanagementspring.mapper;

import es.codeurjc.booksmanagementspring.dto.RoleCreateDTO;
import es.codeurjc.booksmanagementspring.dto.RoleDTO;
import es.codeurjc.booksmanagementspring.model.ERoles;
import es.codeurjc.booksmanagementspring.model.Role;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-15T20:36:48+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 1.4.200.v20221012-0724, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO toDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        Integer id = null;

        id = (int) role.getId();

        ERoles name = null;

        RoleDTO roleDTO = new RoleDTO( id, name );

        return roleDTO;
    }

    @Override
    public Role toDomain(RoleDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        Integer id = null;
        ERoles name = null;

        id = roleDTO.id();
        name = roleDTO.name();

        Role role = new Role( id, name );

        return role;
    }

    @Override
    public Role toDomain(RoleCreateDTO roleDTO) {
        if ( roleDTO == null ) {
            return null;
        }

        ERoles name = null;

        name = roleDTO.name();

        Integer id = null;

        Role role = new Role( id, name );

        return role;
    }
}
