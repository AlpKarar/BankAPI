package dev.alpkarar.BankAPI.Service;

import dev.alpkarar.BankAPI.Model.UserId;
import dev.alpkarar.BankAPI.Repository.UserIdRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserIdService {

    private final UserIdRepository userIdRepository;

    public UserIdService(UserIdRepository userIdRepository) {
        this.userIdRepository = userIdRepository;
    }

    public boolean checkUserId(String userId) {
        return userIdRepository.existsById(userId);
    }

    public void addUserId(String userId) {
        UserId newUserId = UserId.builder()
                        .userId(userId)
                        .creationDate(LocalDateTime.now())
                        .userSettings(new HashMap<String, String>())
                        .build();

        userIdRepository.save(newUserId);
    }
}
