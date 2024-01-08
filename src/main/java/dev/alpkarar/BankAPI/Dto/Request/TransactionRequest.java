package dev.alpkarar.BankAPI.Dto.Request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public abstract class TransactionRequest {
    private String accountId;
    private double amount;
}
