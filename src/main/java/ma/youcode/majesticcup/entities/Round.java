package ma.youcode.majesticcup.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "rounds")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Round {
    @Id
    private String id;

    private int roundNumber;

    @DBRef
    private Competition competition;

    @DBRef
    private List<Match> matches = new ArrayList<>();

}
