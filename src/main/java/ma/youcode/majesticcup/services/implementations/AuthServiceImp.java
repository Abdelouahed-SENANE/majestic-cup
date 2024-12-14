package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.LoginRequestDTO;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.LoginResponseDTO;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.repositories.UserRepository;
import ma.youcode.majesticcup.services.AuthService;
import ma.youcode.majesticcup.utils.auth.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResponseDTO authenticate(LoginRequestDTO dto) {
        return authProcess(dto.username() , dto.password());
    }

    private User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    @Override
    public LoginResponseDTO signup(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.username());
        user.setPassword(passwordEncoder.encode(dto.password()));
        userRepository.save(user);
        return authProcess(dto.username(), dto.password());
    }

    private LoginResponseDTO authProcess(String username , String password) {
        authManager.authenticate( new UsernamePasswordAuthenticationToken(username , password) );
        User authUser = findByUsername(username);
        String token = jwtTokenProvider.generateToken(authUser);
        long expirationTime = jwtTokenProvider.getExpirationTime();
        return new LoginResponseDTO(token, expirationTime);
    }

    @Override
    public void logout(String jwtToken) {
    }


}
