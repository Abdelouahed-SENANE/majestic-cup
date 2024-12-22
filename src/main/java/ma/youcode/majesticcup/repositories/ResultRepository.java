package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends MongoRepository<Result, String> {
}
