package dev.alpkarar.BankAPI.Model;

import lombok.Getter;

@Getter
public enum Transaction_Type {
    WITHDRAW("WITHDRAW"),
    DEPOSIT("DEPOSIT"),
    TRANSFER("TRANSFER");

    private final String value;

    Transaction_Type(String value) {
        this.value = value;
    }
}