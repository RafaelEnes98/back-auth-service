package com.back.auth_service.api.dtos.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank(message = "Name is mandatory")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,

        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email format is invalid")
        String email,

        @NotBlank(message = "CPF is mandatory")
        @Pattern(regexp = "\\d{11}", message = "CPF must have 11 digits")
        String cpf,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password must be at least 8 characters")
        String password,

        @NotBlank(message = "User type is mandatory")
        String userType
) {
}
