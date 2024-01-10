package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {

    UserDetails findByUsername(String username);
}
