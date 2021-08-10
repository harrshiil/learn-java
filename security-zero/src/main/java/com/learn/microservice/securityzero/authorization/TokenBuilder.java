package com.learn.microservice.securityzero.authorization;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Base64;
import java.util.Date;

public class TokenBuilder
{
    public String jwtAuthToken(String username,String role)
    {

        long oneHour=1*60*60*1000;

        return Jwts.builder()
                .claim("role",role)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+oneHour))
                .signWith(SignatureAlgorithm.HS256, Base64.getEncoder().encode("@Tul1982".getBytes()))
                .compact();
    }

    public Claims validate(String token)
    {
        return Jwts.parser()
                .setSigningKey(Base64.getEncoder().encode("@Tul1982".getBytes()))
                .parseClaimsJws(token)
                .getBody();
    }
}
