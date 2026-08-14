package com.isaac.hiring_platform.domain.company;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaac.hiring_platform.domain.company.dtos.CompanyResponseDTO;
import com.isaac.hiring_platform.domain.company.dtos.CreateCompanyRequestDTO;
import com.isaac.hiring_platform.domain.company.useCases.CreateCompanyUseCase;
import com.isaac.hiring_platform.domain.company.useCases.ListCompanyUseCase;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("${api.base.path}/company")
@RequiredArgsConstructor
@Validated
public class CompanyController {

    private final CreateCompanyUseCase createCompanyUseCase;
    private final ListCompanyUseCase listCompanyUseCase;

    @GetMapping
    public ResponseEntity<List<CompanyResponseDTO>> findAll() {
        return ResponseEntity.ok(listCompanyUseCase.execute());
    }

    @PostMapping
    public ResponseEntity<CompanyResponseDTO> create(@Valid @RequestBody CreateCompanyRequestDTO newCompany) {
        var createdCompany = createCompanyUseCase.execute(newCompany);
        return ResponseEntity.ok(createdCompany);
    }
}
