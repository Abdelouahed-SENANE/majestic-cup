package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Round;

import java.util.List;

public record CompetitionResponseDTO(
        String id,
        String name,
        int numberOfTeams,
        List<TeamResponseDTO> teams,
        int currentRound,
        List<RoundResponseDTO> rounds
) {}
