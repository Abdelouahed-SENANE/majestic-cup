package ma.youcode.majesticcup.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "results")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Result {

    @Id
    private String id;

    private Integer homeTeamGoals;
    private Integer awayTeamGoals;

    @DBRef
    private Match match;

    @DBRef
    private Team winnerTeam;

    @DBRef
    List<Statistic> statistics = new ArrayList<>();
}
