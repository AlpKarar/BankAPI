package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public void createCustomer(@RequestBody CreateCustomerRequest request) {
        customerService.createCustomer(request);
    }

    @PostMapping
    public ResponseEntity<Customer> getCustomerInfo(@RequestBody Long customerId) {
        Optional<Customer> customer = customerService.getCustomerInfo(customerId);

        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}
