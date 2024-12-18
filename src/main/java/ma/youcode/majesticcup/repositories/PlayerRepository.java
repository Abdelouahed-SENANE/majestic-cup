package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, Long> {
}
