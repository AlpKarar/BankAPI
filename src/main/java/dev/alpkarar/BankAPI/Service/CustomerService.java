package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Model.User;
import dev.alpkarar.BankAPI.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CreateCustomerRequest request, User newUser) {
        Customer newCustomer = Customer.builder()
                .userId(newUser.getUsername())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .birthDate(LocalDate.parse(request.birthDate()))
                .email(request.email())
                .address(request.address())
                .build();

        customerRepository.save(newCustomer);

        // return customerRepository.save(newCustomer);
    }

    public Optional<Customer> getCustomerInfo(Long customerId) {
        return customerRepository.findById(customerId);
    }

    public Optional<List<Customer>> getAllCustomerInfo() {
        return Optional.of(customerRepository.findAll());
    }

    public Customer findCustomerByUserId(String userId) {
        return customerRepository.findCustomerByUserId(userId);
    }
}
