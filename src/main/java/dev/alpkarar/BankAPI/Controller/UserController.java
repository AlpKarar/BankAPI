package dev.alpkarar.BankAPI.Controller;

import dev.alpkarar.BankAPI.Dto.Request.CreateAdminRequest;
import dev.alpkarar.BankAPI.Dto.Request.CreateCustomerRequest;
import dev.alpkarar.BankAPI.Model.Role;
import dev.alpkarar.BankAPI.Model.User;
import dev.alpkarar.BankAPI.Service.AdminService;
import dev.alpkarar.BankAPI.Service.CustomerService;
import dev.alpkarar.BankAPI.Service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final CustomerService customerService;
    private final AdminService adminService;

    public UserController(UserService userService, CustomerService customerService, AdminService adminService) {
        this.userService = userService;
        this.customerService = customerService;
        this.adminService = adminService;
    }

    @PostMapping("/customer/authenticate")
    public User signUpForCustomer(CreateCustomerRequest request) {
        User newUser = userService.createUser(Role.CUSTOMER);

        customerService.createCustomer(request, newUser);

        return newUser;
    }

    @PatchMapping("/updatePassword")
    public User updatePassword(String userId, String newPassword) {
        return userService.updatePassword(userId, newPassword);
    }

    @PostMapping("/admin/authenticate")
    public User signUpForAdmin(CreateAdminRequest request) {
        User newUser = userService.createUser(Role.ADMIN);

        adminService.createAdmin(request, newUser);

        return newUser;
    }

    @GetMapping("/customer")
    public UserDetails getUser(@RequestParam(name = "customerId") String id) {
        return userService.loadUserByUsername(id);
    }
}