package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Random;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private String username = generateUserId();

    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    @OneToOne(mappedBy = "user")
    private BankUser user;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Enumerated(EnumType.STRING)
    private Set<Roles> authorities;

    private String generateUserId() {
        Random rand = new Random();
        int bound = (int) (Math.pow(10, 16) - Math.pow(10, 15));
        int id = (int) (Math.pow(10, 15) + rand.nextInt(bound));
        return Integer.toString(id);
    };
}
