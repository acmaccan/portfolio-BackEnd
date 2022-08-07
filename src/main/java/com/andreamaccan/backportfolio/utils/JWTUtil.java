//package com.andreamaccan.backportfolio.utils;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.security.Key;
//import java.util.Date;
//
//@Component
//public class JWTUtil {
//    @Value("${security.jwt.secret}")
//    private String key;
//
//    @Value("${security.jwt.issuer}")
//    private String issuer;
//
//    @Value("${security.jwt.ttlMillis}")
//    private long ttlMillis;
//
//    private final Logger log = LoggerFactory
//        .getLogger(JWTUtil.class);
//
//    // Create token
//    public String create(String id, String subject) {
//
//        // Algorithm
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        // Time in milliseconds
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        // Key
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        // Claims
//        JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
//            .signWith(signatureAlgorithm, signingKey);
//
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//
//        // Builds the JWT and serializes it
//        return builder.compact();
//    }
//
//    // Get token
//    public String getValue(String jwt) {
//
//        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
//            .parseClaimsJws(jwt).getBody();
//
//        return claims.getSubject();
//    }
//
//    // Get key and validate token
//    public String getKey(String jwt) {
//
//        Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(key))
//                .parseClaimsJws(jwt).getBody();
//
//        return claims.getId();
//    }
//}
