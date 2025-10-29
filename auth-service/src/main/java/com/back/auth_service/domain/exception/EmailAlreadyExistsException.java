package com.back.auth_service.domain.exception;

public class EmailAlreadyExistsException extends RuntimeException{

    public EmailAlreadyExistsException(final String email) {
        super("Email already exists: " + email);
    }
}
