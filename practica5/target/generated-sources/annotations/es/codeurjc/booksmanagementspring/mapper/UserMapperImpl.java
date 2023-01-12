package es.codeurjc.booksmanagementspring.mapper;

import es.codeurjc.booksmanagementspring.dto.UserCreateDTO;
import es.codeurjc.booksmanagementspring.dto.UserDTO;
import es.codeurjc.booksmanagementspring.model.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-12T19:14:45+0100",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Homebrew)"
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

        User user = new User();

        user.setId( userDTO.id() );
        user.setNick( userDTO.nick() );
        user.setEmail( userDTO.email() );

        return user;
    }

    @Override
    public User toDomain(UserCreateDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setNick( userDTO.nick() );
        user.setEmail( userDTO.email() );

        return user;
    }
}
