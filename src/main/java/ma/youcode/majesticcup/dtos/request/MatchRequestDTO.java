package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotNull;
import org.starter.utilities.validation.groups.OnCreate;

public record MatchRequestDTO(
        @NotNull(groups = OnCreate.class) String roundId,
        @NotNull(groups = OnCreate.class) String homeTeamId,
        @NotNull(groups = OnCreate.class) String awayTeamId
) {
}
