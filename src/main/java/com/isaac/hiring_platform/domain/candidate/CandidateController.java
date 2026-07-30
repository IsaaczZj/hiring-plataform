package com.isaac.hiring_platform.domain.candidate;

import com.isaac.hiring_platform.domain.candidate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.candidate.dtos.CreateCandidateRequestDTO;
import com.isaac.hiring_platform.domain.candidate.useCases.CreateCandidateUseCase;
import com.isaac.hiring_platform.domain.candidate.useCases.ListCandidateUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.base.path}/candidate")
@RequiredArgsConstructor
@Validated
public class CandidateController {
    private final CreateCandidateUseCase createCandidateUseCase;
    private final ListCandidateUseCase listCandidateUseCase;

    @PostMapping
    public ResponseEntity<CandidateResponseDTO> create(@Valid @RequestBody CreateCandidateRequestDTO body) {
        var candidateResponseDTO = createCandidateUseCase.execute(body);
        return ResponseEntity.ok(candidateResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CandidateResponseDTO>> list() {
        var candidates = listCandidateUseCase.execute();
        return ResponseEntity.ok(candidates);
    }


}
