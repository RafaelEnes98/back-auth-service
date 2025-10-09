package com.back.auth_service.api.dtos.response;

public record UserResponse(

        String id,
        String name,
        String email,
        String cpf,
        String userType
) {
}
