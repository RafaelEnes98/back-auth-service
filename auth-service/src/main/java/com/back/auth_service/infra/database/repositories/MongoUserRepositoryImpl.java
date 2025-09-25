package com.back.auth_service.infra.database.repositories;

import com.back.auth_service.application.repositories.IUserRepository;
import com.back.auth_service.domain.model.User;
import com.back.auth_service.infra.database.documents.UserDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MongoUserRepositoryImpl implements IUserRepository {

    private final UserMongoRepository userMongoRepository;
    private final ObjectMapper objectMapper;

    @Override
    public boolean existsByEmail(String email) {
        return userMongoRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return userMongoRepository.existsByCpf(cpf);
    }

    @Override
    public void save(User user) {
       UserDocument userDocument = objectMapper.convertValue(user, UserDocument.class);
        userMongoRepository.save(userDocument);

    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userMongoRepository.findByEmail(email)
                .map(userDoc -> objectMapper.convertValue(userDoc, User.class));

    }

    @Override
    public Optional<User> findByCpf(String cpf) {
        return userMongoRepository.findByCpf(cpf)
                .map(userDoc -> objectMapper.convertValue(userDoc, User.class));

    }
}
