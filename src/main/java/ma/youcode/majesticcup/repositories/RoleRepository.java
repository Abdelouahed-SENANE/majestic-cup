package ma.youcode.majesticcup.repositories;

import ma.youcode.majesticcup.entities.Role;
import ma.youcode.majesticcup.utils.enums.RoleName;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
