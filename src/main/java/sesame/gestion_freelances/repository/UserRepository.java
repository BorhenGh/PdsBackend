package sesame.gestion_freelances.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import sesame.gestion_freelances.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}