package com.isaac.hiring_platform.domain.company;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, UUID> {

    Optional<CompanyEntity> findByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsBySlug(String slug);
    
    boolean existsByCnpj(String cnpj);
}
