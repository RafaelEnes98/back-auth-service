package com.back.auth_service.domain.exception;

public class CpfAlreadyExistsException extends RuntimeException{

    public CpfAlreadyExistsException(final String cpf) {
        super("Cpf Already Exists: " + cpf);
    }
}
