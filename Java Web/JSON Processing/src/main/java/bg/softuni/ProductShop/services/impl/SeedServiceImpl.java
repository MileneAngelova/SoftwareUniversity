package bg.softuni.ProductShop.services.impl;

import bg.softuni.ProductShop.models.dto.CategorySeedDTO;
import bg.softuni.ProductShop.models.dto.ProductSeedDTO;
import bg.softuni.ProductShop.models.dto.UserSeedDTO;
import bg.softuni.ProductShop.models.entities.Category;
import bg.softuni.ProductShop.models.entities.Product;
import bg.softuni.ProductShop.models.entities.User;
import bg.softuni.ProductShop.repositories.CategoryRepository;
import bg.softuni.ProductShop.repositories.ProductRepository;
import bg.softuni.ProductShop.repositories.UserRepository;
import bg.softuni.ProductShop.services.SeedService;
import bg.softuni.ProductShop.utils.ValidationUtil;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class SeedServiceImpl implements SeedService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Random random;

    public SeedServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.random = new Random();
    }

    @Override
    public void seedCategories(CategorySeedDTO[] categorySeedDTOs) {
        if (categoryRepository.count() != 0) {
            return;
        }
        Arrays.stream(categorySeedDTOs).forEach(dto -> {
            if (this.validationUtil.isValid(dto)) {
                Category category = this.modelMapper.map(dto, Category.class);
                this.categoryRepository.save(category);
            } else {
                this.validationUtil.violations(dto).forEach(d -> System.out.println(d.getMessage()));
            }
        });

    }

    @Override
    @Transactional
    public void seedProducts(ProductSeedDTO[] productSeedDTOs) {
        if (this.productRepository.count() != 0) {
            return;
        }
        Arrays.stream(productSeedDTOs).forEach(dto -> {
            if (this.validationUtil.isValid(dto)) {
                Product product = this.modelMapper.map(dto, Product.class);

                product.setSellerId(getRandomUser());

                int randomCount = random.nextInt(2);

                if (randomCount == 1) {
                    product.setBuyerId(getRandomUser());
                }
                product.setCategories(getRandomCategory());

                this.productRepository.save(product);
            } else {
                this.validationUtil.violations(dto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }

    @Override
    public void seedUsers(UserSeedDTO[] userSeedDTOs) {
        if (userRepository.count() != 0) {
            return;
        }
        Arrays.stream(userSeedDTOs).forEach(dto -> {
            if (this.validationUtil.isValid(dto)) {
                User user = this.modelMapper.map(dto, User.class);
                this.userRepository.save(user);
            } else {
                this.validationUtil.violations(dto).stream()
                        .map(ConstraintViolation::getMessage)
                        .forEach(System.out::println);
            }
        });
    }


    @Override
    public User getRandomUser() {
        long randomId = random.nextLong(userRepository.count()) + 1;

        return this.userRepository.getReferenceById(randomId);
    }

    @Override
    public Set<Category> getRandomCategory() {
        int randomCounter = this.random.nextInt(3) + 1;
        Set<Category> randomCategories = new HashSet<>();

        for (int i = 0; i < randomCounter; i++) {
            long randomId = this.random.nextLong(categoryRepository.count()) + 1;
            randomCategories.add(this.categoryRepository.getReferenceById(randomId));
        }
        return randomCategories;
    }
}
