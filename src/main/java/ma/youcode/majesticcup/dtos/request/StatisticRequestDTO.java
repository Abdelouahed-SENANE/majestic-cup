package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ma.senane.utilities.validation.groups.OnCreate;

public record StatisticRequestDTO(
        @NotBlank(groups = OnCreate.class) String playerId,
        @NotNull(groups = OnCreate.class) Integer goals,
        @NotNull(groups = OnCreate.class) Integer assists,
        @NotNull(groups = OnCreate.class) Integer yellowCards,
        @NotNull(groups = OnCreate.class) Integer redCards
) {
}
