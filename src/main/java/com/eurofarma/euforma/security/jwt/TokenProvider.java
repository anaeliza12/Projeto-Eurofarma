package com.eurofarma.euforma.security.jwt;

import java.util.Base64;

import org.springframework.beans.factory.annotation.Value;

import com.auth0.jwt.algorithms.Algorithm;
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
		var secret =  Base64.getEncoder().encode(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secret);
	}
	
	private TokenVO tokenProvider() {
		
	}

}
