package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Service.CustomerService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /*
    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.ok(customerService.createCustomer(request));
    }
    */

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerInfo(@PathVariable String customerId) {
        Optional<Customer> customer = customerService.getCustomerInfo(Long.parseLong(customerId));

        return customer.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomerInfo().get());
    }

    @GetMapping
    public ResponseEntity<Customer> findCustomerByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(customerService.findCustomerByUserId(userId));
    }
}
