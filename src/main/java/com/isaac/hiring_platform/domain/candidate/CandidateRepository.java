package com.isaac.hiring_platform.domain.candidate;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    Optional<CandidateEntity> findByEmail(String email);
}
