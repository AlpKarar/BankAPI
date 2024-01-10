package dev.alpkarar.BankAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String clientId;
    private String iban;
    private LocalDateTime creationDate;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonIgnoreProperties("accounts")
    private Customer customer;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    @JsonIgnoreProperties("account")
    private Set<Transaction> transactions = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 &&
                Objects.equals(id, account.id) &&
                Objects.equals(iban, account.iban) &&
                Objects.equals(creationDate, account.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iban, creationDate, balance);
    }
}