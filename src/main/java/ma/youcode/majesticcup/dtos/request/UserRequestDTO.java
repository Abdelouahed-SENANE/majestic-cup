package ma.youcode.majesticcup.dtos.request;

import ma.youcode.majesticcup.utils.enums.RoleName;


import java.io.Serializable;
import java.util.Set;

public record UserRequestDTO(
        String username,
        String password,
        Set<RoleName> roles
) implements Serializable {}
