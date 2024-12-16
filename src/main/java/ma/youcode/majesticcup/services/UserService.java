package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.utils.enums.RoleName;

import java.util.List;
import java.util.Set;

public interface UserService {

    UserResponseDTO getMe();
    void editRoles(String username,Set<RoleName> roles);

}
