package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public record UserResponseDTO(
        String id,
        String username,
        Set<Role> roles
) {
}
