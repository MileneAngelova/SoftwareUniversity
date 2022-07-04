package bg.softuni.MobiLeLeLe.repository;

import bg.softuni.MobiLeLeLe.Model.Entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {

}
