package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
