package dev.alpkarar.BankAPI.Dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class TransactionRequest {
    private String accountId;
    private String transactionType;
    private double amount;
}
