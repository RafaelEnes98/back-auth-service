package com.back.auth_service.application.usecases;

import com.back.auth_service.api.dtos.request.UserRequest;
import com.back.auth_service.application.repositories.IUserRepository;
import com.back.auth_service.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateUser {

    private final IUserRepository iUserRepository;

    public User execute(final User user) {
        validateUniqueEmail(user.getEmail());
        validateUniqueCpf(user.getCpf());
        return iUserRepository.save(user);

    }

    private void validateUniqueEmail(final String email) {
        if (iUserRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already registered");
        }
    }

    private void validateUniqueCpf(final String cpf) {
        if (iUserRepository.existsByCpf(cpf)) {
            throw new IllegalArgumentException("CPF already registered");
        }

    }

}
