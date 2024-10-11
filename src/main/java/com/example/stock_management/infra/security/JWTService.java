package com.example.stock_management.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.stock_management.domain.user.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class JWTService {

    @Value("${infra.security.jwt-secret}")
    private String secret;

    private Algorithm algorithm;

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(secret);
    }

    public String createToken(User user) {
        try {

            return JWT.create()
                    .withIssuer("stock-management")
                    .withExpiresAt(createExpiration())
                    .withSubject(user.getUsername())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException("An error ocurred while trying to create the token: ", exception);
        }
    }

    public String getSubject(String jwt) {
        try {
            return JWT.require(algorithm)
                    .withIssuer("stock-management")
                    .build()
                    .verify(jwt)
                    .getSubject();

        } catch (JWTVerificationException exception){
           throw  new RuntimeException("Error: The token is invalid or has expired!");
        }
    }

    private Instant createExpiration() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
