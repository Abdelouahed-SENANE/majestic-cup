package ma.youcode.majesticcup.dtos.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import ma.senane.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.entities.Player;

public record StatisticResponseDTO(
         Player player,
         Integer goals,
         Integer assists,
         Integer yellowCards,
         Integer redCards 

) {
}
