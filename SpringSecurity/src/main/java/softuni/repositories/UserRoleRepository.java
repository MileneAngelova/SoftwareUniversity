package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.models.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {


}
