package com.isaac.hiring_platform.domain.auth.infra;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTCandidateProvider {
    @Value("${jwt.secret}")
    private String jtwSecret;

    public DecodedJWT validateToken(String token) {
        token = token.replace("Bearer ", "");
        Algorithm algorithm = Algorithm.HMAC256(jtwSecret);

        try {

            return JWT.require(algorithm).build().verify(token);
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
