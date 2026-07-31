package com.isaac.hiring_platform.domain.auth.company.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthCompanyLoginRequestDTO(

        @NotBlank(message = "Digite um e-mail")
        @Email(message = "Digite um e-mail válido")
        String email,

        @NotBlank(message = "Digite uma senha")
        @Size(min = 4, message = "A senha precisa ter no mínimo 4 caracteres")
        String password
) {
}
