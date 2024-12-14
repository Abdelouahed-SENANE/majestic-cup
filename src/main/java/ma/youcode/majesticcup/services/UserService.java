package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.entities.User;

import java.util.List;

public interface UserService {

    UserResponseDTO getMe();

}
