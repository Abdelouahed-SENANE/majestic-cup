package ma.youcode.majesticcup.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@RequiredArgsConstructor
@Data
public class User {

    @Id
    private String id;
    private String username;
    private String password;
}
