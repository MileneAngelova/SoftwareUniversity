package bg.softuni.ProductShop.models.dto;

import com.google.gson.annotations.Expose;
import jakarta.validation.constraints.Size;

public class UserSeedDTO {
    @Expose
    @Size(min = 3)
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private int age;

    public UserSeedDTO() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
