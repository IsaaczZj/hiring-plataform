package com.isaac.hiring_platform.domain.auth.candidate;

import com.isaac.hiring_platform.domain.auth.candidate.dtos.AuthCandidateLoginRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("${api.base.path}/auth/candidate")
@RequiredArgsConstructor
public class AuthCandidateController {

    private final AuthCandidateUseCase authCandidateUseCase;

    @PostMapping
    public ResponseEntity<Object> candidateLogin(@Valid @RequestBody AuthCandidateLoginRequestDTO login) {
        var response = authCandidateUseCase.execute(login);
        return ResponseEntity.ok(response);
    }
}
