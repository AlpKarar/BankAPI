package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", type = org.hibernate.id.uuid.UuidGenerator.class)
    private String id;

    private Date issuedAt;

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
