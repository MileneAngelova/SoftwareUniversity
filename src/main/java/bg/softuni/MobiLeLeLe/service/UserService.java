package bg.softuni.MobiLeLeLe.service;

import bg.softuni.MobiLeLeLe.Model.Entity.DTO.UserLoginDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.DTO.UserRegisterDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.User;
import bg.softuni.MobiLeLeLe.repository.UserRepository;
import bg.softuni.MobiLeLeLe.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;
    private CurrentUser currentUser;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<User> optUser = userRepository.findByEmail(loginDTO.getEmail());

        if (optUser.isEmpty()) {
            LOGGER.info("User[{}] not found!", loginDTO.getEmail());
            return false;
        }

        String rawPassword = loginDTO.getPassword();
        String encodedPassword = optUser.get().getPassword();
        boolean success = passwordEncoder.matches(rawPassword, encodedPassword);

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

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        User newUser = new User().setActive(true).setEmail(userRegisterDTO.getEmail())
                .setFirstName(userRegisterDTO.getFirstName())
                .setLastName(userRegisterDTO.getLastName())
                .setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

        newUser = userRepository.save(newUser);

        login(newUser);
    }
}
