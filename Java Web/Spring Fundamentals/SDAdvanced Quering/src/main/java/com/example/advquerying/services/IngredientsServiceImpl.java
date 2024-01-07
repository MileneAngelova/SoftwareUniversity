package com.example.advquerying.services;

import com.example.advquerying.entities.Ingredient;
import com.example.advquerying.repositories.IngredientsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {
    private final IngredientsRepository ingredientsRepository;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public void selectByLetter(char letter) {
        List<Ingredient> byNameStartingWith = this.ingredientsRepository.findIngredientByNameStartingWith(letter);
        byNameStartingWith.forEach(System.out::println);
    }

    @Override
    public void selectInGivenList(List<String> ingredients) {
        List<Ingredient> byNameIn = ingredientsRepository.findByNameInOrderByPriceAsc(ingredients);
        byNameIn.forEach(System.out::println);
    }

    @Override
    @Transactional
    public int deleteByName(String ingredientName) {
      return ingredientsRepository.deleteIngredientByName(ingredientName);
    }

    @Override
    @Transactional
    public void increasePriceByPercent(double percent) {
        ingredientsRepository.increasePriceByPercent(BigDecimal.valueOf(percent));
    }

        @Override
    @Transactional
    public void updatePriceByListProvided(Set<String> ingredients) {
    ingredientsRepository.updatePriceByGivenNames(ingredients);
    }
}
