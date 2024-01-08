package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Dto.Request.DepositRequest;
import dev.alpkarar.BankAPI.Dto.Request.TransactionRequest;
import dev.alpkarar.BankAPI.Dto.Request.TransferRequest;
import dev.alpkarar.BankAPI.Dto.Request.WithdrawRequest;
import dev.alpkarar.BankAPI.Model.Transaction;
import dev.alpkarar.BankAPI.Service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{transactionId}")
    public ResponseEntity<Transaction> getTransactionById(String transactionId) {
        Optional<Transaction> transaction = transactionService.getTransactionById(transactionId);

        return transaction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        Optional<List<Transaction>> transactions = transactionService.getAllTransactions();

        return transactions.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction> createTransaction(@RequestBody WithdrawRequest request) {
        return ResponseEntity.ok(transactionService.proceedTransaction(request));
    }

    @PostMapping("/deposit")
    public ResponseEntity<Transaction> createTransaction(@RequestBody DepositRequest request) {
        return ResponseEntity.ok(transactionService.proceedTransaction(request));
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction> createTransaction(@RequestBody TransferRequest request) {
        return ResponseEntity.ok(transactionService.proceedTransaction(request));
    }
}
