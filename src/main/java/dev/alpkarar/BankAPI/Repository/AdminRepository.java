package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
