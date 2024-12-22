package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import ma.senane.utilities.validation.groups.OnCreate;

import java.util.List;

public record ResultRequestDTO(
        @NotNull(groups = OnCreate.class) Integer homeTeamGoals,
        @NotNull(groups = OnCreate.class) Integer awayTeamGoals,
        @NotNull(groups = OnCreate.class) @Valid List<StatisticRequestDTO> statistics
) {
}
