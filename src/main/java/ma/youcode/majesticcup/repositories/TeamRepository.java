package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TeamRepository extends MongoRepository<Team, String> {
    Optional<Team> findByName(String name);
    List<Team> findAllByIdIn(List<String> id);
}
