package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;

public interface AuthService {

    String login(UserRequestDTO userDTO);
    String register(UserRequestDTO userDTO);
    UserResponseDTO getMe();
    void logout(String jwtToken);



}
