package dev.alpkarar.BankAPI.Dto.Request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TransferRequest extends TransactionRequest{
    private String receiverAccountId;
}
