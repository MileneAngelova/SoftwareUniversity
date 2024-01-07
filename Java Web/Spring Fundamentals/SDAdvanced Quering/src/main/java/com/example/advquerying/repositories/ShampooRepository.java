package com.example.advquerying.repositories;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findByBrand(String brand);

    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, Long labelId);

    List<Shampoo> findBySizeOrderById(Size size);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countByPriceLessThan(BigDecimal price);

    List<Shampoo> findAllByBrandStartingWith(char letter);
    @Query("SELECT s FROM Shampoo s WHERE s.ingredients.size < :ingredientsCount")
    List<Shampoo> findByIngredientsCountLessThan(int ingredientsCount);

    @Query("SELECT s FROM Shampoo s JOIN s.ingredients AS i WHERE i.name IN :ingredientsName ")
    Set<Shampoo> findByIngredientsName(Set<String> ingredientsName);


}