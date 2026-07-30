package com.isaac.hiring_platform.domain.jobs;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Locale;

public enum JobLevel {
    JUNIOR,
    PLENO,
    SENIOR,
    ESPECIALISTA;

    @JsonCreator
    public static JobLevel fromValue(String value) {
        if (value == null) {
            return null;
        }

        try {
            return JobLevel.valueOf(
                    value.trim().toUpperCase(Locale.ROOT)
            );
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    "Nível inválido. Use: JUNIOR, PLENO, SENIOR ou ESPECIALISTA"
            );
        }
    }
}
