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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", type = org.hibernate.id.uuid.UuidGenerator.class)
    private Long id;

    private LocalDate issuedAt;

    @ManyToOne
    private Account account;

    @ElementCollection(targetClass = Transaction_Type.class)
    @JoinTable(
            name = "transaction_types",
            joinColumns = @JoinColumn(name = "transaction_id")
    )
    @Enumerated(EnumType.STRING)
    private Transaction_Type transactionType;
}