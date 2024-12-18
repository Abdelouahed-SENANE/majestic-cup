package ma.youcode.majesticcup.utils.mappers;

import ma.senane.utilities.mappers.GenericMapper;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserResponseDTO , UserRequestDTO> {
//    @Override
//    @Mapping(ignore = true , target = "roles")
//    User fromRequestDTO(UserRequestDTO userRequestDTO);

//    @Mapping(target = "")
//    UserResponseDTO toUserResponseDTO(User user);

}
