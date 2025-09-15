package com.back.auth_service.domain.model;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private String id;
    private String name;
    private String email;
    @Getter(AccessLevel.NONE)
    private String password;
    private String cpf;
    private UserType userType;

    public static User create(final String name, final String email, final String password, final String cpf, final UserType userType) {
        Objects.requireNonNull(name, "Name cannot be null");
        Objects.requireNonNull(email, "Email cannot be null");
        Objects.requireNonNull(password, "password cannot be null");
        Objects.requireNonNull(cpf, "cpf cannot be null");
        Objects.requireNonNull(userType, "userType cannot be null");

        validateEmail(email);

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        return new User(null, name, email, hashedPassword, cpf, userType);
    }

    public boolean authenticate(final String passwordEntered) {
        return BCrypt.checkpw(passwordEntered, this.password);
    }

    private static void validateEmail(final String email) {
        final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
        if (!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Email inválido: " + email);
        }
    }
}
