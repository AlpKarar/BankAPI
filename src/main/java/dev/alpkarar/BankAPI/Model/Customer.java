package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", type = org.hibernate.id.uuid.UuidGenerator.class)
    private Long id;

    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String address;
    private String email;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Set<Account> account = new HashSet<>();
}
