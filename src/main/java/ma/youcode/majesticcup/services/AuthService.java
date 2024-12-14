package ma.youcode.majesticcup.services;

import ma.youcode.majesticcup.dtos.request.LoginRequestDTO;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.LoginResponseDTO;
import ma.youcode.majesticcup.entities.User;

public interface AuthService {

    LoginResponseDTO authenticate(LoginRequestDTO userDTO);
    LoginResponseDTO signup(UserRequestDTO userDTO);
    void logout(String jwtToken);



}
