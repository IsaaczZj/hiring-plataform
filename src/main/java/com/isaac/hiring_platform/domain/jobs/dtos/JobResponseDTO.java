package com.isaac.hiring_platform.domain.jobs.dtos;

import com.isaac.hiring_platform.domain.jobs.JobEntity;
import com.isaac.hiring_platform.domain.jobs.JobLevel;

import java.time.LocalDateTime;
import java.util.UUID;

public record JobResponseDTO(
        UUID id,
        String title,
        String description,
        String benefits,
        JobLevel level,
        String companyName,
        LocalDateTime createdAt
) {

    public static JobResponseDTO fromEntity(JobEntity job) {
        return new JobResponseDTO(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getBenefits(),
                job.getLevel(),
                job.getCompany().getName(),
                job.getCreatedAt()
        );

    }
}
