package com.isaac.hiring_platform.domain.candidate.useCases;

import com.isaac.hiring_platform.domain.candidate.CandidateEntity;
import com.isaac.hiring_platform.domain.candidate.CandidateRepository;
import com.isaac.hiring_platform.domain.candidate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.domain.candidate.dtos.CreateCandidateRequestDTO;
import com.isaac.hiring_platform.exceptions.CandidateAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CreateCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CandidateResponseDTO execute(CreateCandidateRequestDTO newCandidate) {
        if (candidateRepository.existsByUsername(newCandidate.username())) {
            throw new CandidateAlreadyExistsException("Esse username já está em uso");
        }
        if (candidateRepository.existsByEmail(newCandidate.email())) {
            throw new CandidateAlreadyExistsException("Esse e-mail já está em uso");
        }

        CandidateEntity candidate = candidateRepository
                .save(CandidateEntity
                        .builder()
                        .username(newCandidate.username())
                        .name(newCandidate.name())
                        .email(newCandidate.email())
                        .password(newCandidate.password())
                        .description(newCandidate.description())
                        .build());

        return CandidateResponseDTO.fromEntity(candidate);

    }
}
