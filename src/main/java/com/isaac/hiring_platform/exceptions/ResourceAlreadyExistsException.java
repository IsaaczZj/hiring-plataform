package com.isaac.hiring_platform.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String message, String field) {
        super(message);

    }

}
