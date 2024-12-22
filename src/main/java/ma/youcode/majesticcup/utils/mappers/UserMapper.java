package ma.youcode.majesticcup.utils.mappers;

import org.starter.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserResponseDTO , UserRequestDTO> {


}
