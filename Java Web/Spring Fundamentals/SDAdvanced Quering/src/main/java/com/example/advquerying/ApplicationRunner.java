package com.example.advquerying;

import com.example.advquerying.repositories.IngredientsRepository;
import com.example.advquerying.repositories.ShampooRepository;
import com.example.advquerying.services.IngredientsService;
import com.example.advquerying.services.ShampooService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final IngredientsService ingredientsService;
    private final ShampooService shampooService;

    public ApplicationRunner(IngredientsService ingredientsService, ShampooService shampooService) {
        this.ingredientsService = ingredientsService;
        this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {
//        shampooService.selectBySize(Size.MEDIUM);
//        shampooService.selectBySizeOrLabel(Size.MEDIUM, 10L);
//        shampooService.selectByPriceHigherThan(BigDecimal.valueOf(5.50));
//        ingredientsService.selectByLetter('M');
//        ingredientsService.selectInGivenList(List.of("Lavender", "Herbs", "Apple"));
//        shampooService.selectByCountIngredients(2);
//        ingredientsService.deleteByName("Nettle");
//        ingredientsService.increasePriceByPercent(0.1);
          ingredientsService.updatePriceByListProvided(Set.of("Berry", "Mineral-Collagen"));
    }
}
