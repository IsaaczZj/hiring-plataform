package com.isaac.hiring_platform.domain.auth.company;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaac.hiring_platform.domain.auth.company.dtos.AuthCompanyLoginRequestDTO;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.base.path}/auth/company")
@RequiredArgsConstructor
public class AuthCompanyController {

    private final AuthCompanyUseCase authCompanyUseCase;

    @PostMapping
    public ResponseEntity<Map<String, String>> companyLogin(@Valid @RequestBody AuthCompanyLoginRequestDTO login) {
        var token = authCompanyUseCase.execute(login);
        return ResponseEntity.ok(Map.of("token", token));

    }
}
