package com.isaac.hiring_platform.domain.company.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateCompanyRequestDTO(
        String name,
        String slug,
        String emai,
        String password,
        String websiteUrl,
        String cnpj,
        String description
) {

}
