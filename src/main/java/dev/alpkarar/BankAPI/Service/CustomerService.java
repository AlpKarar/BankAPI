package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CreateCustomerRequest request) {
        Customer newCustomer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .birthDate(LocalDate.parse(request.birthDate()))
                .email(request.email())
                .address(request.address())
                .build();

        customerRepository.save(newCustomer);
    }

    public Optional<Customer> getCustomerInfo(Long customerId) {
        return customerRepository.findById(customerId);
    }
}
