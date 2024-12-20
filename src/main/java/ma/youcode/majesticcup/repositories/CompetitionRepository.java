package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
}
