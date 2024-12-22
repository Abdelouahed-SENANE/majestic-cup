package ma.youcode.majesticcup.dtos.response;

import ma.youcode.majesticcup.entities.Player;

public record StatisticResponseDTO(
         Player player,
         Integer goals,
         Integer assists,
         Integer yellowCards,
         Integer redCards
) {
}
