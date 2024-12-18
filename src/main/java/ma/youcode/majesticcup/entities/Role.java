package ma.youcode.majesticcup.entities;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "roles")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

}
