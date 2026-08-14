package com.isaac.hiring_platform.domain.auth.company;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isaac.hiring_platform.domain.auth.company.dtos.AuthCompanyLoginRequestDTO;
import com.isaac.hiring_platform.domain.company.CompanyEntity;
import com.isaac.hiring_platform.domain.company.CompanyRepository;
import com.isaac.hiring_platform.exceptions.InvalidCredentialsException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthCompanyUseCase {

    @Value("${jwt.secret}")
    private String jtwSecret;

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    public String execute(AuthCompanyLoginRequestDTO login) {
        CompanyEntity company = companyRepository.findByEmail(login.email())
                .orElseThrow(InvalidCredentialsException::new);

        boolean isPasswordValid = passwordEncoder.matches(login.password(), company.getPassword());

        if (!isPasswordValid) {
            throw new InvalidCredentialsException();
        }

        Algorithm algorithm = Algorithm.HMAC256(jtwSecret);
        return JWT.create()
                .withIssuer("hiring-plataform")
                .withSubject(company.getId().toString())
                .withExpiresAt(Instant.now().plus(Duration.ofHours(2)))
                .sign(algorithm);
    }

;
}
