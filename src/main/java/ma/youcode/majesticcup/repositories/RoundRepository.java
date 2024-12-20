package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Round;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoundRepository extends MongoRepository<Round, String> {
}
