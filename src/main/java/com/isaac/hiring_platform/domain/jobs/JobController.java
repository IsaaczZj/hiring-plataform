package com.isaac.hiring_platform.domain.jobs;

import com.isaac.hiring_platform.domain.jobs.dtos.CreateJobRequestDTO;
import com.isaac.hiring_platform.domain.jobs.dtos.JobResponseDTO;
import com.isaac.hiring_platform.domain.jobs.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.base.path}/job")
@RequiredArgsConstructor
@Validated
public class JobController {
    private final CreateJobUseCase createJobUseCase;

    @PostMapping
    public ResponseEntity<JobResponseDTO> create(@Valid @RequestBody CreateJobRequestDTO newJob){
        var job = createJobUseCase.execute(newJob);

        return ResponseEntity.ok(job);
    }
}
