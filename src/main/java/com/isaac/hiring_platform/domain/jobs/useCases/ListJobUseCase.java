package com.isaac.hiring_platform.domain.jobs.useCases;

import com.isaac.hiring_platform.domain.jobs.JobRepository;
import com.isaac.hiring_platform.domain.jobs.dtos.JobResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListJobUseCase {
    private final JobRepository jobRepository;

    public List<JobResponseDTO> execute(Pageable pageable) {
        var jobs = jobRepository.findAll(pageable);
        return jobs.stream().map(JobResponseDTO::fromEntity).toList();
    }

}
