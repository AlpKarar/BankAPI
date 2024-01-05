package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate issuedAt;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @JoinTable(
            name = "transaction_types",
            joinColumns = @JoinColumn(name = "transaction_id")
    )
    @Enumerated(EnumType.STRING)
    private Transaction_Type transactionType;
}