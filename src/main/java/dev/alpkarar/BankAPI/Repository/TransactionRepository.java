package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
