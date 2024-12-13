package ma.youcode.majesticcup.dtos.request;

import ma.youcode.majesticcup.utils.enums.RoleName;

import java.io.Serializable;
import java.util.List;

public record UserRequestDTO(
        String username,
        String password,
        List<RoleName> roles
) implements Serializable {
}
