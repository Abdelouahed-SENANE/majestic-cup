package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Match;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MatchRepository extends MongoRepository<Match, String> {
}
