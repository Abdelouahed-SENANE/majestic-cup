package ma.youcode.majesticcup.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "players")
@Data
@RequiredArgsConstructor
public class Player {

    @Id
    private String id;
    private String name;
    private String surname;
    private String position;
    private int number;


}
