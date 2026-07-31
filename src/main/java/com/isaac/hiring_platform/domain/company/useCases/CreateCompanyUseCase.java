package com.isaac.hiring_platform.domain.company.useCases;

import com.isaac.hiring_platform.domain.company.CompanyEntity;
import com.isaac.hiring_platform.domain.company.CompanyRepository;
import com.isaac.hiring_platform.domain.company.dtos.CompanyResponseDTO;
import com.isaac.hiring_platform.domain.company.dtos.CreateCompanyRequestDTO;
import com.isaac.hiring_platform.exceptions.ResourceAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

    private static final int MAX_SLUG_LENGTH = 120;

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public CompanyResponseDTO execute(CreateCompanyRequestDTO newCompany) {
        if (companyRepository.existsByEmail(newCompany.email())) {
            throw new ResourceAlreadyExistsException("Já existe uma empresa com esse e-mail", "email");
        }

        if (companyRepository.existsByCnpj(newCompany.cnpj())) {
            throw new ResourceAlreadyExistsException("Já existe uma empresa com esse cnpj", "cnpj");
        }

        String slug = generateUniqueSlug(newCompany.name());
        var password = passwordEncoder.encode(newCompany.password());
        CompanyEntity company = CompanyEntity.builder()
                .name(newCompany.name())
                .slug(slug)
                .email(newCompany.email())
                .password(password)
                .websiteUrl(newCompany.websiteUrl())
                .cnpj(newCompany.cnpj())
                .description(newCompany.description())
                .build();

        companyRepository.save(company);
        return CompanyResponseDTO.fromEntity(company);
    }

    private String generateUniqueSlug(String name) {
        String baseSlug = generateSlug(name);
        String slug = baseSlug;
        int suffixNumber = 2;

        while (companyRepository.existsBySlug(slug)) {
            String suffix = "-" + suffixNumber++;
            slug = truncate(baseSlug, MAX_SLUG_LENGTH - suffix.length()) + suffix;
        }

        return slug;
    }

    private String generateSlug(String name) {
        String slug = Normalizer.normalize(name, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", "");

        if (slug.isBlank()) {
            throw new IllegalArgumentException("O nome deve conter pelo menos uma letra ou número");
        }

        return truncate(slug, MAX_SLUG_LENGTH);
    }

    private String truncate(String value, int maxLength) {
        return value.substring(0, Math.min(value.length(), maxLength)).replaceAll("-$", "");
    }
}
