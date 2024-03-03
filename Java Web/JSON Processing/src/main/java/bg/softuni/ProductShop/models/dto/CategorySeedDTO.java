package bg.softuni.ProductShop.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class CategorySeedDTO {
    @Expose
    @Size(min = 3, max = 15)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategorySeedDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
