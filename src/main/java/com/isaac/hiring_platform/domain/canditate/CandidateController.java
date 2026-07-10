package com.isaac.hiring_platform.domain.canditate;

import com.isaac.hiring_platform.domain.canditate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.canditate.dtos.CreateCandidateRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
@Validated
public class CandidateController {
    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CandidateResponseDTO> create(@Valid @RequestBody CreateCandidateRequestDTO body) {
        var candidateResponseDTO = candidateService.create(body);
        return ResponseEntity.ok(candidateResponseDTO);
    }
}
