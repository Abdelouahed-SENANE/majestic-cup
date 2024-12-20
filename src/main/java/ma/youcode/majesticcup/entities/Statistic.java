package ma.youcode.majesticcup.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "statistics")
public class Statistic {
    @Id
    private String id;

    @DBRef
    private Player player;

    private int goals;
    private int assists;
    private int yellowCards;
    private int redCards;

}
