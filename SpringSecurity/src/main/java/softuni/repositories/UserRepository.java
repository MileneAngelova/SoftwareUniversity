package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.models.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}
