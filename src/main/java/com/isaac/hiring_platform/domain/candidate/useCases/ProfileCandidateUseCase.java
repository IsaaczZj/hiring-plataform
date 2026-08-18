package com.isaac.hiring_platform.domain.candidate.useCases;

import com.isaac.hiring_platform.domain.candidate.CandidateEntity;
import com.isaac.hiring_platform.domain.candidate.CandidateRepository;
import com.isaac.hiring_platform.domain.candidate.dtos.CandidateResponseDTO;
import com.isaac.hiring_platform.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileCandidateUseCase {

    private final CandidateRepository candidateRepository;

    public CandidateResponseDTO execute(UUID id) {

        CandidateEntity candidate = candidateRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        return CandidateResponseDTO.fromEntity(candidate);

    }
}
