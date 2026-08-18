package com.isaac.hiring_platform.domain.auth.candidate.dtos;

import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthCandidateLoginResponseDTO {
    private String access_token;
    private Long expiresIn;
}
