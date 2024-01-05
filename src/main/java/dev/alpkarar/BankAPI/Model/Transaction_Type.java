package dev.alpkarar.BankAPI.Model;

import lombok.Getter;

@Getter
public enum Transaction_Type {
    WITHDRAW("withdraw"),
    DEPOSIT("deposit"),
    TRANSFER("transfer");

    private final String value;

    Transaction_Type(String value) {
        this.value = value;
    }
}