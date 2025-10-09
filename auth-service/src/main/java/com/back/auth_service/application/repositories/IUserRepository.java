package com.back.auth_service.application.repositories;

import com.back.auth_service.domain.model.User;

import java.util.Optional;

public interface IUserRepository {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);

}
