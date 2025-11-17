package com.back.customer_service.infra.database.repositories;

import com.back.customer_service.application.repositories.IUserRepository;
import com.back.customer_service.domain.model.User;
import com.back.customer_service.infra.database.entities.UserEntity;
import com.back.customer_service.infra.mapper.UserDataBaseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostgresUserRepositoryImpl implements IUserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public boolean existsByEmail(String email) {
        return userJpaRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return userJpaRepository.existsByCpf(cpf);
    }

    @Override
    public User save(User user) {
        UserEntity entity = UserDataBaseMapper.toEntity(user);
        UserEntity saved = userJpaRepository.save(entity);
        return UserDataBaseMapper.toDomain(saved);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userJpaRepository.findByEmail(email)
                .map(UserDataBaseMapper::toDomain);
    }

    @Override
    public Optional<User> findByCpf(String cpf) {
        return userJpaRepository.findByCpf(cpf)
                .map(UserDataBaseMapper::toDomain);
    }
}
