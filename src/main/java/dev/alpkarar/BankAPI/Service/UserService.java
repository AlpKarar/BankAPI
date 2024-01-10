package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Model.Role;
import dev.alpkarar.BankAPI.Model.User;
import dev.alpkarar.BankAPI.Repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
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
        return userRepository.findByUsername(username);
    }

    public User createUser(Role userRole) {
        Set<Role> roles = new HashSet<>();

        roles.add(userRole);

        User newUser = User.builder()
                .authorities(roles)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .isEnabled(true)
                .build();

        return userRepository.save(newUser);
    }

    public User updatePassword(String userId, String newPassword) {
        User user = (User) userRepository.findByUsername(userId);

        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }
}
