package com.back.auth_service.api.dtos.request;

public record UserRequest(
        String name,
        String email,
        String cpf,
        String password,
        String userType
) {
}
