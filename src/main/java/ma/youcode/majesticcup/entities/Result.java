package ma.youcode.majesticcup.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "results")
public class Result {

    @Id
    private String id;

    private Integer homeTeamGoals;
    private Integer awayTeamGoals;

    @DBRef
    private Team winnerTeam;
}
