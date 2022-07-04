package bg.softuni.MobiLeLeLe.service;

import bg.softuni.MobiLeLeLe.Model.DTO.UserLoginDTO;
import bg.softuni.MobiLeLeLe.Model.DTO.UserRegisterDTO;
import bg.softuni.MobiLeLeLe.Model.Entity.UserEntity;
import bg.softuni.MobiLeLeLe.Model.mapper.UserMapper;
import bg.softuni.MobiLeLeLe.repository.UserRepository;
import bg.softuni.MobiLeLeLe.user.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean login(UserLoginDTO loginDTO) {
        Optional<UserEntity> optUser = userRepository.findByEmail(loginDTO.getEmail());

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

    private void login(UserEntity user) {
        currentUser.setLoggedIn(true)
                .setName(user.getFirstName() + " " + user.getLastName());
    }

    public void logout() {
        currentUser.clear();
    }

    public void registerAndLogin(UserRegisterDTO userRegisterDTO) {

        UserEntity newUser = userMapper.userDtoToUserEntity(userRegisterDTO);
        newUser.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

            this.userRepository.save(newUser);
            login(newUser);

    }
}
