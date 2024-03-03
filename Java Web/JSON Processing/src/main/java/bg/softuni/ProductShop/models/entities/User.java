package bg.softuni.ProductShop.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private int age;

    @ManyToMany
    private Set<User> friends;

    @OneToMany(mappedBy = "name", targetEntity = Product.class)
    private Set<Product> boughtProducts;

    @OneToMany(mappedBy = "name", targetEntity = Product.class)
    private Set<Product> soldProducts;

    public User() {
    }

    public long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(friends, user.friends) && Objects.equals(boughtProducts, user.boughtProducts) && Objects.equals(soldProducts, user.soldProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friends, boughtProducts, soldProducts);
    }
}
