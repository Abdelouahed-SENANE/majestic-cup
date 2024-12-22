package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.starter.utilities.validation.groups.OnCreate;
import ma.youcode.majesticcup.entities.Competition;

import java.util.ArrayList;
import java.util.List;

public record CompetitionRequestDTO(
        @NotEmpty(groups = OnCreate.class) String name,
        @NotNull(groups = OnCreate.class) Integer numberOfTeams,
        Integer currentRound,
        List<String> teamIds,
        List<String> roundIds

) { }
