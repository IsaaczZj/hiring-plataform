package com.isaac.hiring_platform.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsBySlug(String slug);
    boolean existsByCnpj(String cnpj);
}
