package dev.alpkarar.BankAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime issuedAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnoreProperties("transactions")
    private Account account;

    @JoinTable(
            name = "transaction_types",
            joinColumns = @JoinColumn(name = "transaction_id")
    )
    @Enumerated(EnumType.STRING)
    private Transaction_Type transactionType;
}