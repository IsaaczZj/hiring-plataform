package com.isaac.hiring_platform.domain.jobs;

import com.isaac.hiring_platform.domain.jobs.dtos.CreateJobRequestDTO;
import com.isaac.hiring_platform.domain.jobs.dtos.JobResponseDTO;
import com.isaac.hiring_platform.domain.jobs.useCases.CreateJobUseCase;
import com.isaac.hiring_platform.domain.jobs.useCases.ListJobUseCase;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.path}/job")
@RequiredArgsConstructor
@Validated
public class JobController {
    private final CreateJobUseCase createJobUseCase;
    private final ListJobUseCase listJobUseCase;

    @GetMapping
    public ResponseEntity<List<JobResponseDTO>> findAll(
            @RequestParam(defaultValue = "0") @Min(0) int page,

            @RequestParam(defaultValue = "10")
            @Min(value = 1, message = "O número mínimo de itens é 1") @Max(value = 50, message = "O número de itens deve ser menor que 50 por pagina")
            int perPage,
            
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String sortDir

    ) {
        Sort.Direction direction = Sort.Direction.fromString(sortDir);
        Sort sort = Sort.by(direction, sortBy);
        Pageable pageable = PageRequest.of(page, perPage, sort);
        return ResponseEntity.ok(listJobUseCase.execute(pageable));
    }

    @PostMapping
    public ResponseEntity<JobResponseDTO> create(@Valid @RequestBody CreateJobRequestDTO newJob) {
        var job = createJobUseCase.execute(newJob);
        return ResponseEntity.ok(job);
    }
}
