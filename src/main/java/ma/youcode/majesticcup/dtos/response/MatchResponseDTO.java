package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Team;

public record MatchResponseDTO(
        String id,
        TeamResponseDTO homeTeam,
        TeamResponseDTO awayTeam,
        ResultResponseDTO result
) {
}
