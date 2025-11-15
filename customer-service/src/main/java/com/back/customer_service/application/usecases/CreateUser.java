package com.back.customer_service.application.usecases;

import com.back.customer_service.application.repositories.IUserRepository;
import com.back.customer_service.domain.exception.CpfAlreadyExistsException;
import com.back.customer_service.domain.exception.EmailAlreadyExistsException;
import com.back.customer_service.domain.model.User;
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
            throw new EmailAlreadyExistsException(email);
        }
    }

    private void validateUniqueCpf(final String cpf) {
        if (iUserRepository.existsByCpf(cpf)) {
            throw new CpfAlreadyExistsException(cpf);
        }

    }

}
