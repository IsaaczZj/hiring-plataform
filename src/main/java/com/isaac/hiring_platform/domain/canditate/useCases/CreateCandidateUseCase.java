package com.isaac.hiring_platform.domain.canditate.useCases;

import com.isaac.hiring_platform.domain.canditate.CandidateEntity;
import com.isaac.hiring_platform.domain.canditate.CandidateRepository;
import com.isaac.hiring_platform.domain.canditate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.canditate.dtos.CreateCandidateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CandidateResponseDTO execute(CreateCandidateRequestDTO newCandidate) {
        if (candidateRepository.existsByUsername(newCandidate.username())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse username já está em uso");
        }
        if (candidateRepository.existsByEmail(newCandidate.email())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Esse e-mail já está em uso");
        }

        CandidateEntity candidate = candidateRepository
                .save(CandidateEntity
                        .builder()
                        .username(newCandidate.username())
                        .name(newCandidate.name())
                        .email(newCandidate.email())
                        .password(newCandidate.password())
                        .description(newCandidate.description())
                        .createdAt(LocalDateTime.now())
                        .build());

        return CandidateResponseDTO.fromEntity(candidate);

    }
}
