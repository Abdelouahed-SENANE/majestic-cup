package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Role;

import java.util.List;
import java.util.Set;

public record LoginResponseDTO(
        String token,
        long expiredIn,
        Set<Role> roles
) {
}
