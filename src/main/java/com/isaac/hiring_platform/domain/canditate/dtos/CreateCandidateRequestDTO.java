package com.isaac.hiring_platform.domain.canditate.dtos;

import jakarta.validation.constraints.*;


public record CreateCandidateRequestDTO(

        @NotBlank(message = "Digite um nome")
        @Size(min = 2, message = "O nome precisa ter no mínimo 2 caracteres")
        String name,

        @NotBlank(message = "Digite um username")
        @Size(min = 2, message = "O username precisa ter no mínimo 2 caracteres")
        @Pattern(regexp = "^\\S+$", message = "O username não pode conter espaços")
        String username,

        @NotBlank(message = "Digite um e-mail")
        @Email(message = "Digite um e-mail válido")
        String email,

        @NotBlank(message = "Digite uma senha")
        @Size(min = 4, message = "O senha precisa ter no mínimo 4 caracteres")
        String password,
        @NotBlank(message = "Digite uma descrição")
        @Size(min = 10, max = 255, message = "A descrição precisa ter entre 10 e 255 caracteres")
        String description,

        @NotBlank(message = "Coloque um currículo")
        String curriculum
) {
}
