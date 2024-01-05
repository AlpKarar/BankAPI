package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Model.Account;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Repository.AccountRepository;
import dev.alpkarar.BankAPI.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public AccountService(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public void createAccount(Long customerId) {
        Optional<Customer> customer = Optional.of(customerRepository.findById(customerId)
                .orElseThrow());

        Account newAccount = Account.builder()
                .iban(AccountService.generateIBAN())
                .creationDate(new Date(System.currentTimeMillis()))
                .balance(0)
                .customer(customer.get())
                .transactions(new HashSet<>())
                .build();

        accountRepository.save(newAccount);
    }

    public Optional<Account> getAccountInfo(Long accountId) {
        return accountRepository.findById(accountId);
    }

    private static String generateIBAN() {
        String PREFIX = "TR90222610"; // a random IBAN prefix, which does not include a real bank number
        String accountNum =
                Integer.toString((int) (Math.pow(10, 15) +
                        (Math.pow(10, 16) - Math.pow(10, 15)) * new Random().nextInt()));

        return PREFIX + accountNum;
    }
}
