package com.back.customer_service.infra.mapper;

import com.back.customer_service.domain.model.User;
import com.back.customer_service.domain.model.UserType;
import com.back.customer_service.infra.database.entities.UserEntity;

public class UserDataBaseMapper {

    public static UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId() != null ? Long.valueOf(user.getId()) : null)
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getHashedPassword())
                .cpf(user.getCpf())
                .userType(user.getUserType().name())
                .build();
    }

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId().toString(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getCpf(),
                UserType.valueOf(entity.getUserType())
        );
    }
}