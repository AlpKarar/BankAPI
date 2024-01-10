package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
