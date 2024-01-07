package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findIngredientByNameStartingWith(char letter);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    int deleteIngredientByName(String name);

    @Modifying
    @Query("UPDATE Ingredient i SET i.price = i.price + i.price * :multiplayer")
    void increasePriceByPercent(@Param("multiplayer") BigDecimal percent);
}
