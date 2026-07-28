package com.isaac.hiring_platform.domain.candidate.useCases;

import com.isaac.hiring_platform.domain.candidate.CandidateEntity;
import com.isaac.hiring_platform.domain.candidate.CandidateRepository;
import com.isaac.hiring_platform.domain.candidate.dtos.CandidateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCandidateUseCase {
    private final CandidateRepository candidateRepository;

    public List<CandidateResponseDTO> execute() {
        return candidateRepository.findAll().stream().map(CandidateResponseDTO::fromEntity).toList();

    }
}
