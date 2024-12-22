package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Result;
import ma.youcode.majesticcup.entities.Statistic;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticRepository extends MongoRepository<Statistic, String> {
}
