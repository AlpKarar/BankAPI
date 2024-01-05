package dev.alpkarar.BankAPI.Dto.Request;

import lombok.Builder;

@Builder
public record CreateCustomerRequest(
        String firstName,
        String lastName,
        String birthDate,
        String address,
        String email
) {
}
