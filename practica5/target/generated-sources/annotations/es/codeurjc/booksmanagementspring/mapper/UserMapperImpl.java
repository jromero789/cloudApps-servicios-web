package es.codeurjc.booksmanagementspring.mapper;

import es.codeurjc.booksmanagementspring.dto.UserCreateDTO;
import es.codeurjc.booksmanagementspring.dto.UserDTO;
import es.codeurjc.booksmanagementspring.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-04T19:20:47+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.33.0.v20221215-1352, environment: Java 17.0.5 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        long id = 0L;
        String nick = null;
        String email = null;

        id = user.getId();
        nick = user.getNick();
        email = user.getEmail();

        UserDTO userDTO = new UserDTO( id, nick, email );

        return userDTO;
    }

    @Override
    public User toDomain(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        String nick = null;
        String email = null;

        nick = userDTO.nick();
        email = userDTO.email();

        String password = null;

        User user = new User( nick, email, password );

        user.setId( userDTO.id() );

        return user;
    }

    @Override
    public User toDomain(UserCreateDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        String nick = null;
        String email = null;

        nick = userDTO.nick();
        email = userDTO.email();

        String password = null;

        User user = new User( nick, email, password );

        return user;
    }
}
