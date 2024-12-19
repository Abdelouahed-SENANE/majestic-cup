package ma.youcode.majesticcup.entities;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "competitions")
@Data
@Builder
@RequiredArgsConstructor
public class Competition {

    
}
