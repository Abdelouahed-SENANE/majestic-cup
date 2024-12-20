package ma.youcode.majesticcup.entities;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "competitions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    @Id
    private String id;

    private String name;

    private int numberOfTeams;

    @DBRef
    private List<Team> teams = new ArrayList<>();

    @Column(name = "current_round")
    private Integer currentRound = 1;

    @DBRef
    private List<Round> rounds = new ArrayList<>();

}
