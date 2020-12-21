package fr.hoag.mappers;

import fr.hoag.models.users.User;
import fr.hoag.repositories.dto.users.UserDto;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

}
