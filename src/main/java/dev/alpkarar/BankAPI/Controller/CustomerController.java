package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }

    @GetMapping
    public ResponseEntity<Customer> getCustomerInfo(@RequestParam(name = "id") Long customerId) {
        Optional<Customer> customer = customerService.getCustomerInfo(customerId);

        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}
