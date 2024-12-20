package ma.youcode.majesticcup.services.implementations;

import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.dtos.request.UserRequestDTO;
import ma.youcode.majesticcup.dtos.response.UserResponseDTO;
import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.entities.User;
import ma.youcode.majesticcup.utils.mappers.UserMapper;
import ma.youcode.majesticcup.repositories.UserRepository;
import ma.youcode.majesticcup.services.UserService;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDTO getMe() {
        User user = getAuthenticatedUser();
        return userMapper.toResponseDTO(user);
    }

    private User getAuthenticatedUser() {
        return userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName())
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    @Override
    public void editRoles(String username,Set<RoleName> roles) {
        User user = findUserByUsername(username);
        user.getRoles().clear();
        user.getRoles().addAll(convertRoles(roles));
    }
    private Set<Role> convertRoles(Set<RoleName> roles) {
        return roles.stream().map(roleName -> new Role(null,roleName)).collect(Collectors.toSet());
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    @Override
    public UserResponseDTO update(UserRequestDTO userRequestDTO) {
        return null;
    }
}
