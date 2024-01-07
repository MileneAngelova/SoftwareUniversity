package com.example.advquerying.services;

import com.example.advquerying.entities.Label;
import com.example.advquerying.entities.Size;

import java.math.BigDecimal;

public interface ShampooService {
    void selectBySize(Size size);

    void selectBySizeOrLabel(Size size, Long labelId);

    void selectByPriceHigherThan(BigDecimal price);

    void selectByCountIngredients(int countIngredients);
}
