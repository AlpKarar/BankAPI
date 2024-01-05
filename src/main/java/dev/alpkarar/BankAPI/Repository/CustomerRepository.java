package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
