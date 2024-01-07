package com.example.advquerying.services;

import com.example.advquerying.entities.Shampoo;
import com.example.advquerying.entities.Size;
import com.example.advquerying.repositories.ShampooRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {
    ShampooRepository shampooRepository;

    public ShampooServiceImpl(ShampooRepository shampooRepository) {
        this.shampooRepository = shampooRepository;
    }

    @Override
    public void selectBySize(Size size) {
        List<Shampoo> bySize = this.shampooRepository.findBySize(size);
        bySize.forEach(s -> System.out.printf("%s %.2f%n", s.getBrand(), s.getPrice()));
    }

    @Override
    public void selectBySizeOrLabel(Size size, Long labelId) {
        List<Shampoo> bySizeOrLabel = shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
        bySizeOrLabel.forEach(System.out::println);
    }

    @Override
    public void selectByPriceHigherThan(BigDecimal price) {
        List<Shampoo> byPriceGreaterThan = shampooRepository.findAllByPriceGreaterThanOrderByPriceDesc(price);
        byPriceGreaterThan.forEach(s -> System.out.println(s.toString()));
    }

    @Override
    public void selectByCountIngredients(int countIngredients) {
        List<Shampoo> byIngredientsCountLessThan = shampooRepository.findByIngredientsCountLessThan(countIngredients);
        byIngredientsCountLessThan.forEach(System.out::println);
    }
}
