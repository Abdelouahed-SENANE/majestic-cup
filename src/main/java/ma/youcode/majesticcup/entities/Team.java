package ma.youcode.majesticcup.entities;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "teams")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Team {

    @Id
    private String id;
    private String name;
    private String city;
    private List<Player> players = new ArrayList<>();


}
