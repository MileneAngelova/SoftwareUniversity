package bg.softuni.MobiLeLeLe.Model.Entity;

import bg.softuni.MobiLeLeLe.Model.Entity.Enum.UserRoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private UserRoleEnum userRole;

    public UserRole() {
    }

    public long getId() {
        return id;
    }

    public UserRole setId(long id) {
        this.id = id;
        return this;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public UserRole setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
        return this;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", userRole=" + userRole +
                '}';
    }
}
