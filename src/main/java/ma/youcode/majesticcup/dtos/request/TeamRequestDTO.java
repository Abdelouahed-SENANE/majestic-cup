package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import ma.senane.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.dtos.response.PlayerResponseDTO;

import java.util.List;

public record TeamRequestDTO(
        @NotEmpty(groups = OnCreate.class) String name,
        @NotEmpty(groups = OnCreate.class) String city,
        @Size(groups = OnCreate.class, min = 12 , max = 16 , message = "The Team must have 12 players at least")
        List<String> playerIds

) {}

