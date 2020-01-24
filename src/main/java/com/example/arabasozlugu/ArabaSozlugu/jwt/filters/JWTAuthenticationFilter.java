package com.example.arabasozlugu.ArabaSozlugu.jwt.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.arabasozlugu.ArabaSozlugu.dto.RequestDTO.user.UserReqDTO;
import com.example.arabasozlugu.ArabaSozlugu.model.User;
import com.example.arabasozlugu.ArabaSozlugu.utils.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("attemptAuthentication");
	    try {
	    	//İsteğin içinden UserReqDTO'yu çek
			UserReqDTO creds = new ObjectMapper()
					.readValue(request.getInputStream(), UserReqDTO.class);
			 
			 return authenticationManager.authenticate( //-->UsernamePasswordAuthenticationToken
					 	//UserReqDTO'yu UsernamePasswordAuthenticationToken'a çevirir
	                    new UsernamePasswordAuthenticationToken(
	                            creds.getUser(),
	                            creds.getPass(),
	                            new ArrayList<>())
	                    );
		} catch (IOException e) {
            throw new RuntimeException(e);
		}
	}
    
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    	System.out.println("successfulAuthentication");

        String token = Jwts.builder()
                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + SecurityConstants.EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET.getBytes())
                .compact();
               
        res.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX + token);
    }
}
