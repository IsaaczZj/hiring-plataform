package com.isaac.hiring_platform.domain.company.useCases;

import com.isaac.hiring_platform.domain.company.CompanyRepository;
import com.isaac.hiring_platform.domain.company.dtos.CreateCompanyRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CreateCompanyUseCase {

    private final CompanyRepository companyRepository;

    public void execute(CreateCompanyRequestDTO newCompany) {
        if (companyRepository.existsByEmail(newCompany.emai())) {
            
        }
    }
}
