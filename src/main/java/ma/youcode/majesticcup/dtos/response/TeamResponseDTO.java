package ma.youcode.majesticcup.dtos.response;

import java.util.List;

public record TeamResponseDTO(
        String id,
        String name,
        String city,
        List<PlayerResponseDTO> players
) {
}
