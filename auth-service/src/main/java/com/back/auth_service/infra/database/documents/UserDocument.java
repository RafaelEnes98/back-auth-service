package com.back.auth_service.infra.database.documents;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "users")
public class UserDocument {

    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;

    private String password;

    @Indexed(unique = true)
    private String cpf;

    private String userType;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;


}
