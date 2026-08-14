package com.isaac.hiring_platform.domain.jobs.dtos;

import com.isaac.hiring_platform.domain.jobs.JobLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateJobRequestDTO(
        @NotBlank(message = "O título é obrigatório")
        @Size(max = 120, message = "O título deve ter no máximo 120 caracteres")
        String title,

        @NotBlank(message = "A descrição é obrigatória")
        String description,

        String benefits,

        @NotNull(message = "O nível da vaga é obrigatório")
        JobLevel level
) {

}
