package com.cep.api.exception;

public class NotFoundException extends Exception {

    String message;
    public NotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
