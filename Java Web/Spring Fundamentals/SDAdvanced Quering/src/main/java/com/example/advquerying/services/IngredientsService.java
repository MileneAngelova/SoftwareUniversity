package com.example.advquerying.services;

import java.math.BigDecimal;
import java.util.List;

public interface IngredientsService {
    void selectByLetter(char letter);

    void selectInGivenList(List<String> ingredients);

    int deleteByName(String ingredientName);

    void increasePriceByPercent(double percent);

    void updatePriceByListProvided(Set<String> ingredients);
}
