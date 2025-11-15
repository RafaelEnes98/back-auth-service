package com.back.auth_service.infra.database.repositories;

import com.back.auth_service.domain.model.User;
import com.back.auth_service.infra.database.documents.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<UserDocument, String> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
    Optional<User> findByEmail(String email);
    Optional<User> findByCpf(String cpf);

}


