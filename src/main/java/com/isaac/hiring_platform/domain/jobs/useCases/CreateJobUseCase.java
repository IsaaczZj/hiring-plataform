package com.isaac.hiring_platform.domain.jobs.useCases;

import com.isaac.hiring_platform.domain.company.CompanyEntity;
import com.isaac.hiring_platform.domain.company.CompanyRepository;
import com.isaac.hiring_platform.domain.jobs.JobEntity;
import com.isaac.hiring_platform.domain.jobs.JobRepository;
import com.isaac.hiring_platform.domain.jobs.dtos.CreateJobRequestDTO;
import com.isaac.hiring_platform.domain.jobs.dtos.JobResponseDTO;
import com.isaac.hiring_platform.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateJobUseCase {

    private final JobRepository jobRepository;
    private final CompanyRepository companyRepository;

    public JobResponseDTO execute(CreateJobRequestDTO newJob, UUID company_id) {
        CompanyEntity company = companyRepository.findById(company_id)
                .orElseThrow(() -> new NotFoundException("Coloque um id de uma empresa existente")
                );

        JobEntity job = JobEntity.builder()
                .title(newJob.title())
                .description(newJob.description())
                .benefits(newJob.benefits())
                .level(newJob.level())
                .company(company)
                .build();

        JobEntity createdJob = jobRepository.save(job);
        return JobResponseDTO.fromEntity(createdJob);

    }
}

