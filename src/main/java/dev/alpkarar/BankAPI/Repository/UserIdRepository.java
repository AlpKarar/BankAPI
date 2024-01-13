package dev.alpkarar.BankAPI.Repository;

import dev.alpkarar.BankAPI.Model.UserId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface UserIdRepository extends MongoRepository<UserId, String> {
}
