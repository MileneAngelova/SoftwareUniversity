package bg.softuni.MobiLeLeLe.Model.Entity.DTO;

public class UserLoginDTO {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public UserLoginDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getRawPassword() {
        return password;
    }

    public UserLoginDTO setRawPassword(String rawPassword) {
        this.password = rawPassword;
        return this;
    }
}
