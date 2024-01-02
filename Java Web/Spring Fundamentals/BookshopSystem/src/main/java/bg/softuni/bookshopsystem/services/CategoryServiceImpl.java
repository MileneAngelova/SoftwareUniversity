package bg.softuni.bookshopsystem.services;

import bg.softuni.bookshopsystem.models.etities.Category;
import bg.softuni.bookshopsystem.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        long size = this.categoryRepository.count();
        Random random = new Random();
        int categoriesCount = random.nextInt((int) size) + 1;

        Set<Long> categoriesIds = new HashSet<>();

        for (int i = 0; i < categoriesCount; i++) {
            long nextId = random.nextInt((int) size) + 1;
            categoriesIds.add(nextId);
        }
        List<Category> allById = this.categoryRepository.findAllById(categoriesIds);

        return new HashSet<>(allById);
    }
}

