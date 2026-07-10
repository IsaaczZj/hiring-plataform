package com.isaac.hiring_platform.domain.canditate.dtos;

import com.isaac.hiring_platform.domain.canditate.CandidateEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public record CandidateResponseDTO(
        UUID id,
        String name,
        String username,
        String email,
        String description,
        String curriculum,
        LocalDateTime createdAt
) {
    public static CandidateResponseDTO fromEntity(CandidateEntity candidate) {
        return new CandidateResponseDTO(
                candidate.getId(),
                candidate.getName(),
                candidate.getUsername(),
                candidate.getEmail(),
                candidate.getDescription(),
                candidate.getCurriculum(),
                candidate.getCreatedAt()

        );

    }

}
