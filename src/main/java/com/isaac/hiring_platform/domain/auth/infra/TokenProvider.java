package com.isaac.hiring_platform.domain.auth.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {
    @Value("${jwt.secret}")
    private String jtwSecret;

    public String validateToken(String token) {
        token = token.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(jtwSecret);
        return JWT.require(algorithm).build().verify(token).getSubject();
    }
}
