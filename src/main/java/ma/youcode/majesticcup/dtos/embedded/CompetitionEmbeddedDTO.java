package ma.youcode.majesticcup.dtos.embedded;

import ma.youcode.majesticcup.dtos.response.TeamResponseDTO;

import java.util.List;

public record CompetitionEmbeddedDTO(
        String id,
        String name,
        int numberOfTeams,
        List<TeamResponseDTO> teams,
        int currentRound
) {
}
