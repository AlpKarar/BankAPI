package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,
        value = "select * from customers where user_id = :userId")
    Customer findCustomerByUserId(@Param("userId") String userId);
}
