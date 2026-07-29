package com.isaac.hiring_platform.domain.company;

import com.isaac.hiring_platform.domain.company.dtos.CompanyResponseDTO;
import com.isaac.hiring_platform.domain.company.dtos.CreateCompanyRequestDTO;
import com.isaac.hiring_platform.domain.company.useCases.CreateCompanyUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
@Validated
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCase;

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> create(@Valid @RequestBody CreateCompanyRequestDTO newCompany) {
        var createdCompany = createCompanyUseCase.execute(newCompany);
        return ResponseEntity.ok(createdCompany);
    }
}
