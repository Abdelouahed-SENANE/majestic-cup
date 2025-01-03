package ma.youcode.majesticcup.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "matches")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Match {

    @Id
    private String id;

    @DBRef
    private Round round;

    @DBRef
    private Team homeTeam;

    @DBRef
    private Team awayTeam;

    @DBRef
    private Result result;



}
