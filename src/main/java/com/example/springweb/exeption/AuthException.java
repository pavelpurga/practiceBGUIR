package com.example.springweb.exeption;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
