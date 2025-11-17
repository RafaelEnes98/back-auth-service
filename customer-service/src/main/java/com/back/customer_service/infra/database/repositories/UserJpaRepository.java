package com.back.customer_service.infra.database.repositories;

import com.back.customer_service.infra.database.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserJpaRepository extends JpaRepository<UserEntity, Long> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);

    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByCpf(String cpf);

}


