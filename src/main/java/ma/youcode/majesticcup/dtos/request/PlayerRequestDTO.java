package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.senane.utilities.validation.groups.OnCreate;

public record PlayerRequestDTO(
        @NotEmpty(groups = OnCreate.class) String name,
        @NotEmpty(groups = OnCreate.class) String surname,
        @NotEmpty(groups = OnCreate.class) String position,
        @NotNull(groups = OnCreate.class) Integer number
) {
}
