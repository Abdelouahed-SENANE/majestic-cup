package ma.youcode.majesticcup.dtos.response;

import jakarta.validation.constraints.NotNull;
import ma.youcode.majesticcup.dtos.embedded.TeamEmbeddedDTO;

import java.util.List;

public record ResultResponseDTO(
         int homeTeamGoals,
         int awayTeamGoals,
         TeamEmbeddedDTO winnerTeam,
         List<StatisticResponseDTO> statistics
) {
}
