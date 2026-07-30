package com.isaac.hiring_platform.domain.company.useCases;

import com.isaac.hiring_platform.domain.company.CompanyRepository;
import com.isaac.hiring_platform.domain.company.dtos.CompanyResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListCompanyUseCase {
    private final CompanyRepository companyRepository;

    public List<CompanyResponseDTO> execute() {
        var companies = companyRepository.findAll();

        return companies.stream().map(CompanyResponseDTO::fromEntity).toList();
    }
}
