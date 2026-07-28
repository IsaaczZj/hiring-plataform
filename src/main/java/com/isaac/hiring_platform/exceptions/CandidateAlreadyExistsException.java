package com.isaac.hiring_platform.exceptions;
public class CandidateAlreadyExistsException extends RuntimeException {

    public CandidateAlreadyExistsException(String message) {
        super(message);
    }
}
