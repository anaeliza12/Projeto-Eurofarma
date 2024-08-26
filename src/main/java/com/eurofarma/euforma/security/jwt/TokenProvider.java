package com.eurofarma.euforma.security.jwt;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.security.vo.TokenVO;

import jakarta.annotation.PostConstruct;

public class TokenProvider {

	@Value("${spring.jwt.secret.key:secret}")
	private String secretKey;

	@Value("${spring.jwt.expire.length:3600000")
	private long vallidityInMillySeconds = 3600000;

	private Algorithm algorithm;

	@PostConstruct
	public void init() {
		var secret = Base64.getEncoder().encode(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secret);
	}

	public TokenVO tokenProvider(User user, String accessToken, String refreshToken) {
		Date tokenCreation = new Date();
		Date tokenExpiration = tokenCreation;
		TokenVO token = new TokenVO(user.getEmail(), false, tokenCreation, tokenExpiration, accessToken, refreshToken);
		return token;
	}
	
	public String accessToken(User user, Date now, Date vallidity) {
		String issuerUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();
		
		return   JWT.create()
				.withSubject(user.getEmail())
				.withClaim("roles", user.getRoles())
				.withIssuedAt(now)
				.withExpiresAt(vallidity)
				.withIssuer(issuerUrl)
				.sign(algorithm)
				.strip();			

	}
	
	public String refreshToken(User user, Date now) {
		Date vallidity = new Date(now.getTime() + (vallidityInMillySeconds * 3));
		
		return   JWT.create()
				.withSubject(user.getEmail())
				.withExpiresAt(vallidity)
				.sign(algorithm)
				.strip();			
	}
}
