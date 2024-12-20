package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.dtos.embedded.CompetitionEmbeddedDTO;

public record RoundResponseDTO(
        String id,
        int roundNumber,
        CompetitionEmbeddedDTO competition
) {}
