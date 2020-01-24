package com.example.arabasozlugu.ArabaSozlugu.jwt;

import java.util.Date;

import com.example.arabasozlugu.ArabaSozlugu.dto.ResponseDTO.user.JWTUserResDTO;
import com.example.arabasozlugu.ArabaSozlugu.utils.SecurityConstants;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTUtil {
	public static String generateToken(JWTUserResDTO userResp) {
		String token = Jwts.builder()
                .setSubject(userResp.getUser())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();
		userResp.setToken(SecurityConstants.TOKEN_PREFIX + token);
		
		return token;
	}
	
}
