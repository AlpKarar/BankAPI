package dev.alpkarar.BankAPI.Dto.Response;

public record CustomerInfoResponse(
        String firstName,
        String lastName,
        String birthDate,
        String address,
        String email
) {
}
