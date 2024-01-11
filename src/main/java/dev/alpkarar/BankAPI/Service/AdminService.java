package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Dto.Request.CreateAdminRequest;
import dev.alpkarar.BankAPI.Model.Admin;
import dev.alpkarar.BankAPI.Model.Customer;
import dev.alpkarar.BankAPI.Model.Role;
import dev.alpkarar.BankAPI.Model.User;
import dev.alpkarar.BankAPI.Repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    private final AdminRepository adminRepository;


    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void createAdmin(CreateAdminRequest request, User newUser) {
        Admin newAdmin = Admin.builder()
                .userId(newUser.getUsername())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .job(request.job())
                .email(request.email())
                .build();

        adminRepository.save(newAdmin);

        // return adminRepository.save(newAdmin);
    }

    public Optional<Admin> getCustomerInfo(Long adminId) {
        return adminRepository.findById(adminId);
    }

    public Optional<List<Admin>> getAllCustomerInfo() {
        return Optional.of(adminRepository.findAll());
    }
}
