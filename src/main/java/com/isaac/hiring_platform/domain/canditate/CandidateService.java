package com.isaac.hiring_platform.domain.canditate;

import com.isaac.hiring_platform.domain.canditate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.canditate.dtos.CreateCandidateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateResponseDTO create(CreateCandidateRequestDTO newCandidate) {

        if (candidateRepository.existsByUsername(newCandidate.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este username já está em uso");
        }

        if (candidateRepository.existsByEmail(newCandidate.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Este e-mail já está em uso");
        }

        CandidateEntity candidate = CandidateEntity.builder()
                .name(newCandidate.name())
                .username(newCandidate.username())
                .email(newCandidate.email())
                .password(newCandidate.password())
                .description(newCandidate.description())
                .curriculum(newCandidate.curriculum())
                .createdAt(LocalDateTime.now())
                .build();
        CandidateEntity savedCandidate = candidateRepository.save(candidate);
        return CandidateResponseDTO.fromEntity(savedCandidate);
    }
}
