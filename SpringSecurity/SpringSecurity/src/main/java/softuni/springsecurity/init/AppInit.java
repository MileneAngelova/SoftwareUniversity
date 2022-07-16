package softuni.springsecurity.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.springsecurity.services.UserService;

@Component
public class AppInit implements CommandLineRunner {
    private final UserService userService;

    public AppInit(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        userService.init();
    }
}
