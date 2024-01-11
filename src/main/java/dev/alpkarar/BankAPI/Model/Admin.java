package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name = "admins")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userId;
    private String firstName;
    private String lastName;
    private String job;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(email, admin.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
