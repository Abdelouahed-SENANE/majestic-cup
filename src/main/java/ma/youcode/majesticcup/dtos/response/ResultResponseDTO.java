package ma.youcode.majesticcup.dtos.response;

import jakarta.validation.constraints.NotNull;
import ma.senane.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.dtos.embedded.TeamEmbeddedDTO;

public record ResultResponseDTO(
         int homeTeamGoals,
         int awayTeamGoals,
         TeamEmbeddedDTO winnerTeam
) {
}
