package com.isaac.hiring_platform.domain.company.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CreateCompanyRequestDTO(
        @NotBlank(message = "O nome é obrigatório")
        @Pattern(
                regexp = ".*[\\p{L}\\p{N}].*",
                message = "O nome deve conter pelo menos uma letra ou número"
        )
        @Size(min = 2, max = 255, message = "O nome precisa ter no mínimo 2 caracteres ")
        String name,

        @NotBlank(message = "Digite um e-mail")
        @Email(message = "Digite um e-mail válido")
        String email,

        @NotBlank(message = "Digite uma senha")
        @Size(min = 4, message = "A senha precisa ter no mínimo 4 caracteres")
        String password,

        @Pattern(
                regexp = "^https?://.+$",
                message = "Digite uma URL válida, iniciada por http:// ou https://"
        )
        @Size(max = 255, message = "A URL pode ter no máximo 255 caracteres")
        String websiteUrl,

        @NotBlank(message = "Digite um CNPJ")
        @Pattern(regexp = "^\\d{14}$", message = "O CNPJ deve conter 14 dígitos")
        String cnpj,

        @NotBlank(message = "Digite uma descrição")
        @Size(min = 10, max = 7000, message = "A descrição precisa ter entre 10 e 7000 caracteres")
        String description
) {
}
