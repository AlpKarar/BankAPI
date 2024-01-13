package dev.alpkarar.BankAPI.Model;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

@Document
@Setter
@Getter
@Builder
public class UserId {

    @Id
    private String userId;

    private LocalDateTime creationDate;
    private Map<String, String> userSettings;
}
