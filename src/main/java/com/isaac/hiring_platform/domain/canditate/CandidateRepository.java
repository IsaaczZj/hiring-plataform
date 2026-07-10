package com.isaac.hiring_platform.domain.canditate;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
