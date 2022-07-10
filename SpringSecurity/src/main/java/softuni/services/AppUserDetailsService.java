package softuni.services;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import softuni.models.entities.UserEntity;
import softuni.models.entities.UserRole;
import softuni.repositories.UserRepository;

public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        userRepository.findByEmail(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException("User with email " + username + " not found!"));

        return null;
    }

    private UserDetails map(UserEntity userEntity) {
        return User.builder()
                .username(userEntity.getEmail())
                .password(userEntity.getPassword())
                .authorities(userEntity.getUserRoles()
                        .stream().map(this::map).toList())
                .build();


    }

    private GrantedAuthority map(UserRole userRole) {
return new SimpleGrantedAuthority("ROLE_" + userRole.getUserRole().name());
    }
}
