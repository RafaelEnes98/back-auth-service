package com.back.customer_service.api.dtos.response;

public record UserResponse(

        String id,
        String name,
        String email,
        String cpf,
        String userType
) {
}
