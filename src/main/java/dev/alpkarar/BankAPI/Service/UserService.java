package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Model.Role;
import dev.alpkarar.BankAPI.Model.User;
import dev.alpkarar.BankAPI.Repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }

    public User createUser(Role userRole) {
        Set<Role> roles = new HashSet<>();

        roles.add(userRole);

        User newUser = User.builder()
                .username(generateUserId())
                .password(generatePassword())
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .authorities(roles)
                .build();

        return userRepository.save(newUser);
    }

    public User updatePassword(String userId, String newPassword) {
        Optional<User> user = userRepository.findByUsername(userId);

        user.get().setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user.get());
    }

    private String generateUserId() {
        Random rand = new Random();
        int bound = (int) (Math.pow(10, 16) - Math.pow(10, 15));
        int id = (int) (Math.pow(10, 15) + rand.nextInt(bound));
        return Integer.toString(id);
    };

    private String generatePassword() { // 6 digits password generators
        return Integer.toString((int) (Math.pow(10, 5) + new Random().nextInt(899999)));
    }
}
