package com.back.auth_service.infra.mapper;

import com.back.auth_service.api.dtos.request.UserRequest;
import com.back.auth_service.api.dtos.response.UserResponse;
import com.back.auth_service.domain.model.User;
import com.back.auth_service.domain.model.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {

    public User toDomain(UserRequest request) {
        return User.create(
                request.name(),
                request.email(),
                request.password(),
                request.cpf(),
                UserType.valueOf(request.userType().toUpperCase())
        );
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCpf(),
                user.getUserType().name()
        );
    }
}
