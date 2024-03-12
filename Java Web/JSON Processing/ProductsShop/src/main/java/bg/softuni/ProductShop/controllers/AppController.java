package bg.softuni.ProductShop.controllers;

import bg.softuni.ProductShop.models.dto.CategorySeedDTO;
import bg.softuni.ProductShop.models.dto.ProductPrintDTO;
import bg.softuni.ProductShop.models.dto.ProductSeedDTO;
import bg.softuni.ProductShop.models.dto.UserSeedDTO;
import bg.softuni.ProductShop.services.ProductService;
import bg.softuni.ProductShop.services.SeedService;
import bg.softuni.ProductShop.utils.FileIOUtils;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Component
public class AppController implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;
    private final Gson gson;
    private final FileIOUtils fileIOUtils;

    private final String CATEGORY_PATH = "src/main/resources/files/categories.json";
    private final String PRODUCTS_PATH = "src/main/resources/files/products.json";
    private final String USERS_PATH = "src/main/resources/files/users.json";
    private final String PRODUCTS_OUTPUT = "src/main/resources/files/outputs/productsOutput";
    public AppController(SeedService seedService, ProductService productService, Gson gson, FileIOUtils fileIOUtils) {
        this.seedService = seedService;
        this.productService = productService;
        this.gson = gson;
        this.fileIOUtils = fileIOUtils;
    }


    @Override
    public void run(String... args) throws Exception {
        seedUsers();
        seedCategories();
        sedProducts();
        printProductInRange();

    }


    private void seedUsers() throws FileNotFoundException {
        UserSeedDTO[] userSeedDTOs = this.gson.fromJson(new FileReader(USERS_PATH), UserSeedDTO[].class);
        this.seedService.seedUsers(userSeedDTOs);
    }

    private void seedCategories() throws FileNotFoundException {
        CategorySeedDTO[] categorySeedDTOs = this.gson
                .fromJson(new FileReader(CATEGORY_PATH), CategorySeedDTO[].class);
        this.seedService.seedCategories(categorySeedDTOs);
    }

    private void sedProducts() throws FileNotFoundException {
        ProductSeedDTO[] productSeedDTOs = this.gson.fromJson(new FileReader(PRODUCTS_PATH), ProductSeedDTO[].class);
        this.seedService.seedProducts(productSeedDTOs);
    }

    private void printProductInRange() throws IOException {
        List<ProductPrintDTO> productPrintDTOs = this.productService.printProductInRangeWhereBuyerIsNull();

        String json = this.gson.toJson(productPrintDTOs);
        this.fileIOUtils.write(json, PRODUCTS_OUTPUT);

    }

}
