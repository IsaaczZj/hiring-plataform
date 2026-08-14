package com.isaac.hiring_platform.domain.auth.candidate;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isaac.hiring_platform.domain.auth.candidate.dtos.AuthCandidateLoginRequestDTO;
import com.isaac.hiring_platform.domain.auth.candidate.dtos.AuthCandidateLoginResponseDTO;
import com.isaac.hiring_platform.domain.candidate.CandidateEntity;
import com.isaac.hiring_platform.domain.candidate.CandidateRepository;
import com.isaac.hiring_platform.exceptions.InvalidCredentialsException;
import com.isaac.hiring_platform.exceptions.ResourceAlreadyExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthCandidateUseCase {

    @Value("${jwt.secret.candidate}")
    private String jtwSecretCandidate;

    private final CandidateRepository candidateRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthCandidateLoginResponseDTO execute(AuthCandidateLoginRequestDTO login) {
        CandidateEntity candidate = candidateRepository.findByEmail(login.email()).orElseThrow(
                InvalidCredentialsException::new);

        boolean isPasswordValid = passwordEncoder.matches(login.password(), candidate.getPassword());

        if (!isPasswordValid) {
            throw new InvalidCredentialsException();
        }

        Algorithm algorithm = Algorithm.HMAC256(jtwSecretCandidate);
        var token = JWT.create()
                .withIssuer("hiring-plataform")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", List.of("candidate"))
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(15)))
                .sign(algorithm);

        return AuthCandidateLoginResponseDTO.builder().access_token(token).build();
    }
}
