package com.isaac.hiring_platform.exceptions;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("E-mail ou senha inválidos");
    }
}