package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Role;
import java.util.Set;

public record UserResponseDTO(
        String id,
        String username,
        Set<Role> roles
) {
}
