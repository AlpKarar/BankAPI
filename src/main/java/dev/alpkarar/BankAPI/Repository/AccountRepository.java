package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
