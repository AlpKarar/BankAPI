package dev.alpkarar.BankAPI.Dto.Request;

public record CreateAdminRequest(
        String firstName,
        String lastName,
        String job,
        String email
) {
}
