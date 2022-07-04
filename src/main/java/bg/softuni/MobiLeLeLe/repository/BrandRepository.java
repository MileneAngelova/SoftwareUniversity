package bg.softuni.MobiLeLeLe.repository;

import bg.softuni.MobiLeLeLe.Model.Entity.BrandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {


}
