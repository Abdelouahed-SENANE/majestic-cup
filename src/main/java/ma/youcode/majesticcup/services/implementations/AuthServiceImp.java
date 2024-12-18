package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.LoginRequestDTO;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.LoginResponseDTO;
import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.exceptions.custom.RoleNotFoundException;
import ma.youcode.majesticcup.exceptions.custom.UserAlreadyExistsException;
import ma.youcode.majesticcup.mappers.UserMapper;
import ma.youcode.majesticcup.repositories.RoleRepository;
import ma.youcode.majesticcup.repositories.UserRepository;
import ma.youcode.majesticcup.services.AuthService;
import ma.youcode.majesticcup.utils.auth.JwtTokenProvider;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {

    private static final Logger log = LogManager.getLogger(AuthServiceImp.class);
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {
        return authenticate(dto.username(), dto.password());
    }

    private User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    private boolean isUserExist(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    @Override
    public LoginResponseDTO register(UserRequestDTO dto) {

        if (isUserExist(dto.username())) {
            throw new UserAlreadyExistsException("Username already exists.");
        }

        User user = userMapper.fromRequestDTO(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        assignRole(user);
        userRepository.save(user);
        return authenticate(dto.username(), dto.password());
    }

    private void assignRole(User user) {
        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RoleNotFoundException("Role not found."));
        if (user.getRoles() == null) {
            user.setRoles(new HashSet<>());
        }
        user.getRoles().add(role);

    }

    private LoginResponseDTO authenticate(String username, String password) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        User authUser = findByUsername(username);
        String token = jwtTokenProvider.generateToken(authUser);
        long expirationTime = jwtTokenProvider.getExpirationTime();
        return new LoginResponseDTO(token, expirationTime);
    }

    @Override
    public void logout(String jwtToken) {

    }


}
