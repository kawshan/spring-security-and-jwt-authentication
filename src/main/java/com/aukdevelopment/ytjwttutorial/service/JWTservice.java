package com.aukdevelopment.ytjwttutorial.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JWTservice {

    private final SecretKey secretKey;

    public JWTservice() {
        try {
            SecretKey k = KeyGenerator.getInstance("HmacSHA256").generateKey();
            secretKey = Keys.hmacShaKeyFor(k.getEncoded());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String getJWTToken(){
        return Jwts.builder()
                .subject("amila")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*60*15)) //mili second 1000 kiyanne thapparta ekkak *60 kiyanne minute 1 * 15 kiyanne minutes 15 kata kiyana eka
                .signWith(secretKey)
                .compact();
    }

    public String getUsername(String token) {

        try {
            return Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload()
                    .getSubject();
        }catch (Exception e){
        return "invalid token";
        }
    }

}
