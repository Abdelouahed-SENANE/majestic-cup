package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Role;

import java.util.List;

public record UserResponseDTO(
        String id,
        String username,
        List<Role> roles
) {
}
