package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import ma.senane.utilities.validation.groups.OnCreate;

public record RoundRequestDTO(
        @NotNull(groups = OnCreate.class) Integer roundNumber,
        @NotNull(groups = OnCreate.class) String competitionId
) {
}
