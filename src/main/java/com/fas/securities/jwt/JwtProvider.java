package com.fas.securities.jwt;

import com.fas.securities.services.AccountDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtProvider {
    // Initialization of SecretKey using Keys.secretKeyFor
    private SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateToken(Authentication authentication) {
        AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();

        List<String> roles = accountDetails.getAuthorities()
                .stream()
                .map(Object::toString)
                .toList();

        String jwt = Jwts.builder()
                .setSubject(accountDetails.getUsername())
                .claim("role", roles.get(0))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + JwtConstant.EXPIRATION_TIME))
                .signWith(key).compact();

        return jwt;
    }

    public String getEmailFromJwtToken(String jwt) {
        jwt = jwt.substring(7);

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build().parseClaimsJws(jwt).getBody();

        return String.valueOf(claims.getSubject());
    }
}