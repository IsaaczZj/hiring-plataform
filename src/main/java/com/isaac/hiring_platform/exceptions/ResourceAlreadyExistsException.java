package com.isaac.hiring_platform.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

    private final String field;

    public ResourceAlreadyExistsException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
