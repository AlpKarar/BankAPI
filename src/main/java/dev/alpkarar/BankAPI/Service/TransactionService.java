package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Dto.Request.TransactionRequest;
import dev.alpkarar.BankAPI.Model.Account;
import dev.alpkarar.BankAPI.Model.Transaction;
import dev.alpkarar.BankAPI.Model.Transaction_Type;
import dev.alpkarar.BankAPI.Repository.AccountRepository;
import dev.alpkarar.BankAPI.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public Optional<Transaction> getTransactionById(String transactionId) {
        return Optional.of(transactionRepository.findById(Long.parseLong(transactionId))).orElseThrow();
    }

    public Optional<List<Transaction>> getAllTransactions() {
        return Optional.of(transactionRepository.findAll());
    }

    public Transaction createTransaction(TransactionRequest transactionRequest) {
        Long accountId = Long.parseLong(transactionRequest.getAccountId());
        String transactionType = transactionRequest.getTransactionType();
        double amount = transactionRequest.getAmount();
        Transaction_Type transactionTypeEnum = null;

        switch (transactionType) {
            case "WITHDRAW":
                withdraw(accountId, amount);
                transactionTypeEnum = Transaction_Type.WITHDRAW;
                break;
            case "DEPOSIT":
                deposit(accountId, amount);
                transactionTypeEnum = Transaction_Type.DEPOSIT;
                break;
            case "TRANSFER":
                Long receiverAccountId = Long.parseLong(transactionRequest.getAccountId());
                transactionTypeEnum = Transaction_Type.TRANSFER;

                transfer(accountId, amount, receiverAccountId);
        }

        Transaction newTransaction = Transaction.builder()
                .transactionType(transactionTypeEnum)
                .issuedAt(LocalDateTime.now())
                .account(accountRepository.findById(accountId).get())
                .build();

        return transactionRepository.save(newTransaction);
    }

    private void withdraw(Long accountId, double amount) {
        Optional<Account> account = Optional.of(accountRepository.findById(accountId)).get();

        if (account.isEmpty()) {
            try {
                throw new Exception("No such account exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        double balance = account.get().getBalance();

        if (balance < amount) {
            try {
                throw new Exception("No sufficient amount of balance exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        account.get().setBalance(balance - amount);

        accountRepository.save(account.get());
    }

    private void deposit(Long accountId, double amount) {
        Optional<Account> account = Optional.of(accountRepository.findById(accountId)).get();

        if (account.isEmpty()) {
            try {
                throw new Exception("No such account exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        account.get().setBalance(account.get().getBalance() + amount);

        accountRepository.save(account.get());
    }

    private void transfer(Long accountId, double amount, Long receiverAccountId) {
        Optional<Account> senderAccount = Optional.of(accountRepository.findById(accountId)).get();

        if (senderAccount.isEmpty()) {
            try {
                throw new Error("Sender does not exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        Optional<Account> receiverAccount = Optional.of(accountRepository.findById(receiverAccountId)).get();

        if (receiverAccount.isEmpty()) {
            try {
                throw new Error("Receiver does not exist");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        double senderBalance = senderAccount.get().getBalance();

        if (senderBalance < amount) {
            try {
                throw new Error("No sufficient amount of balance");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        receiverAccount.get().setBalance(receiverAccount.get().getBalance() + amount);
        senderAccount.get().setBalance(senderBalance - amount);

        accountRepository.save(senderAccount.get());
        accountRepository.save(receiverAccount.get());
    }
}