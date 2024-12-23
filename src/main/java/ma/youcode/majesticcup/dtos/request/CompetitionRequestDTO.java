package ma.youcode.majesticcup.dtos.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.starter.utilities.validation.groups.OnCreate;
import java.util.List;

public record CompetitionRequestDTO(
        @NotEmpty(groups = OnCreate.class) String name,
        @NotNull(groups = OnCreate.class)
        Integer numberOfTeams,
        Integer currentRound,
        List<String> teamIds,
        List<String> roundIds

) {
        @AssertTrue(groups = OnCreate.class, message = "Invalid number of teams. Allowed values are 4, 8, 16, 32, 64.")
        public boolean isValid() {
                List<Integer> allowed = List.of(4, 8, 16, 32, 64);
                return numberOfTeams != null && allowed.contains(this.numberOfTeams);
        }
}
