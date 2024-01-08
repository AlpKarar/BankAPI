package dev.alpkarar.BankAPI.Dto.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class TransferRequest extends TransactionRequest{
    private String receiverAccountId;
}
