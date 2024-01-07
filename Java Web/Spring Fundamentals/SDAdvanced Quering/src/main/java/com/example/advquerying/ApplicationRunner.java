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
    private final ShampooRepository shampooRepository;
    private final IngredientsRepository ingredientsRepository;
    private final IngredientsService ingredientsService;
    private final ShampooService shampooService;

    public ApplicationRunner(ShampooRepository shampooRepository, IngredientsRepository ingredientsRepository, IngredientsService ingredientsService, ShampooService shampooService) {
        this.shampooRepository = shampooRepository;
        this.ingredientsRepository = ingredientsRepository;
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
        ingredientsService.increasePriceByPercent(0.1);
    }

//    private void demo() {
//        Scanner scanner = new Scanner(System.in);
//
//                BigDecimal price = scanner.nextBigDecimal();
//
//        List<Shampoo> byBrand = this.shampooRepository.findByBrand("Swiss Green Apple & Nettle");
//        byBrand.forEach(s -> System.out.printf("%s  - %.2f%n", s.getBrand(), s.getPrice()));
//
//        List<Shampoo> byBrandAndSize =
//                this.shampooRepository.findByBrandAndSizeOrderByBrand("Active-Caffeine", Size.SMALL);
//        byBrandAndSize.forEach(s -> System.out.println(s.getId()));
//
//        List<Shampoo> bySize = this.shampooRepository.findBySizeOrderById(Size.MEDIUM);
//        bySize.forEach(s -> System.out.printf("%d %s %s - %.2flv.%n", s.getId(), s.getBrand(), s.getSize(), s.getPrice()));
//
//        List<Shampoo> byPriceGreaterThan = this.shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
//
//        byPriceGreaterThan.forEach(s -> System.out.printf("%s %s - %.2flv.%n", s.getBrand(), s.getSize().name(), s.getPrice()));
//
//        char letter = scanner.nextLine().charAt(0);
//        List<Ingredient> byNameStartingWith = this.ingredientsRepository.findAllByNameStartingWith(letter);
//
//        if (!byNameStartingWith.isEmpty()) {
//            byNameStartingWith.forEach(i -> System.out.println(i.getName()));
//        } else {
//            System.out.println("No ingredient starting with " + letter);
//        }
//
//        int countByPriceLessThan = this.shampooRepository.countByPriceLessThan(price);
//
//      if (countByPriceLessThan > 0) {
//          System.out.println(countByPriceLessThan);
//      }
//
//        String first = scanner.nextLine();
//        String second = scanner.nextLine();
//
//        Set<String> names = Set.of(first, second);
//
//        Set<Shampoo> byIngredientsName = this.shampooRepository.findByIngredientsName(names);
//        byIngredientsName.forEach(s -> System.out.printf("%s %s %.2f%n",s.getBrand(), s.getSize().name(), s.getPrice()));
//
//    }
}
