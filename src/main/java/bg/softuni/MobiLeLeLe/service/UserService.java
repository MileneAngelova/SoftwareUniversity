package bg.softuni.MobiLeLeLe.service;

import bg.softuni.MobiLeLeLe.Model.Entity.DTO.UserLoginDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.User;
import bg.softuni.MobiLeLeLe.repository.UserRepository;
import bg.softuni.MobiLeLeLe.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserRepository userRepository;
    private CurrentUser currentUser;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> optUser = userRepository.findByEmail(loginDTO.getUsername());

        if (optUser.isEmpty()) {
            LOGGER.info("User[{}] not found!", loginDTO.getUsername());
            return false;
        }

        boolean success = optUser.get().getPassword().equals(loginDTO.getPassword());

        if (success) {
            login(optUser.get());
        } else {
            logout();
        }
        return success;
    }

    private void login(User user) {
        currentUser.setLoggedIn(true)
                .setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }
}
