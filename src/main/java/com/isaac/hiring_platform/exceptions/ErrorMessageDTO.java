package com.isaac.hiring_platform.exceptions;

public record ErrorMessageDTO(
        String message,
        String field
) {
}
