package dev.alpkarar.BankAPI.Model;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Roles implements GrantedAuthority {
    CLIENT("CLIENT"),
    ADMIN("ADMIN");

    private final String value;

    Roles (String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return value;
    }
}
