package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.repositories.UserRepository;
import ma.youcode.majesticcup.services.AuthService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;

    @Override
    public String login(UserRequestDTO userDTO) {
        return "";
    }

    @Override
    public String register(UserRequestDTO userDTO) {
        return "";
    }

    @Override
    public void logout(String jwtToken) {
    }

    @Override
    public UserResponseDTO getMe() {
        return null;
    }
}
