package com.isaac.hiring_platform.domain.company.dtos;

import com.isaac.hiring_platform.domain.company.CompanyEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CompanyResponseDTO(
        UUID id,
        String name,
        String email,
        String websiteUrl,
        String cnpj,
        String description,
        String slug
) {
    public static CompanyResponseDTO fromEntity(CompanyEntity company) {
        return new CompanyResponseDTO(
                company.getId(),
                company.getName(),
                company.getEmail(),
                company.getCnpj(),
                company.getDescription(),
                company.getSlug(),
                company.getWebsiteUrl()

        );
    }
}
