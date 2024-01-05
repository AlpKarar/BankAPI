package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", type = org.hibernate.id.uuid.UuidGenerator.class)
    private Long id;

    private String iban;
    private Date creationDate;
    private double balance;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id")
    private Set<Transaction> transactions = new HashSet<>();
}
