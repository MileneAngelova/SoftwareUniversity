package bg.softuni.ProductShop.services;

import bg.softuni.ProductShop.models.dto.CategorySeedDTO;
import bg.softuni.ProductShop.models.dto.ProductSeedDTO;
import bg.softuni.ProductShop.models.dto.UserSeedDTO;
import bg.softuni.ProductShop.models.entities.Category;
import bg.softuni.ProductShop.models.entities.User;

import java.util.Set;

public interface SeedService {
    void seedCategories(CategorySeedDTO[] categorySeedDTOs);

    void seedProducts(ProductSeedDTO[] productSeedDTOs);

    void seedUsers(UserSeedDTO[] userSeedDTOs);

    User getRandomUser();

    Set<Category> getRandomCategory();
}
