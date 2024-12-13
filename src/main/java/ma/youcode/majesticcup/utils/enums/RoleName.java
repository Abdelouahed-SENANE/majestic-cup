package ma.youcode.majesticcup.utils.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleName {
    ROLE_ADMIN("Admin"),
    ROLE_MODERATOR("Moderator");

    private final String description;
}
