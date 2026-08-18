package com.isaac.hiring_platform.domain.candidate;

import com.isaac.hiring_platform.domain.candidate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.candidate.dtos.CreateCandidateRequestDTO;
import com.isaac.hiring_platform.domain.candidate.useCases.CreateCandidateUseCase;
import com.isaac.hiring_platform.domain.candidate.useCases.ListCandidateUseCase;
import com.isaac.hiring_platform.domain.candidate.useCases.ProfileCandidateUseCase;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.base.path}/candidate")
@RequiredArgsConstructor
@Validated
public class CandidateController {
    private final CreateCandidateUseCase createCandidateUseCase;
    private final ListCandidateUseCase listCandidateUseCase;
    private final ProfileCandidateUseCase profileCandidateUseCase;

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

    @GetMapping("/profile")
    public ResponseEntity<CandidateResponseDTO> profile(HttpServletRequest request) {
        var id = request.getAttribute("candidate_id");
        var candidate = profileCandidateUseCase.execute(UUID.fromString(id.toString()));
        return ResponseEntity.ok(candidate);
    }


}
