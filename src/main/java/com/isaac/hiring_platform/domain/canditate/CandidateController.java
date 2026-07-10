package com.isaac.hiring_platform.domain.canditate;

import com.isaac.hiring_platform.domain.canditate.dtos.CreateCandidateRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
@Validated
public class CandidateController {


    @PostMapping
    public ResponseEntity create(@Valid @RequestBody CreateCandidateRequestDTO body) {

        return ResponseEntity.ok(body);
    }
}
