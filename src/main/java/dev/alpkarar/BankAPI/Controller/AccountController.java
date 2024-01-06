package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Model.Account;
import dev.alpkarar.BankAPI.Service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<Account> getAccount(@RequestParam(name = "id") Long accountId) {
        return ResponseEntity.ok(accountService.getAccountInfo(accountId).get());
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccountInfo().get());
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(accountService.createAccount(customerId));
    }
}
