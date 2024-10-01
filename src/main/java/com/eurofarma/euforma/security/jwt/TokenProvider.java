package com.eurofarma.euforma.security.jwt;

import java.util.Base64;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.IncorrectClaimException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.exception.InvalidJwtAuthenticationException;
import com.eurofarma.euforma.security.vo.TokenVO;


import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
@Service
public class TokenProvider {

	@Value("${security.jwt.token.secret-key:secret}")
	private String secretKey = "secret";

	@Value("${security.jwt.token.expire-length:360000}")
	private long validityInMilliSeconds = 60000;

	@Autowired
	private UserDetailsService userDetailsService;

	Algorithm algorithm = null;

	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secretKey.getBytes());
	}

	public TokenVO createAccessToken(String username, List<String> roles) {
		Date now = new Date();
		Date validity = new Date(now.getTime() + validityInMilliSeconds);

		var accessToken = getAccessToken(username, roles, now, validity);
		var refreshToken = getRefreshToken(username, roles, now);

		return new TokenVO(username, true, now, validity, accessToken, refreshToken, roles.get(0));
	}

	public TokenVO refreshToken(String refreshToken) {
		if(refreshToken.contains("Bearer ")) {
			refreshToken = refreshToken.substring("Bearer ".length());
		}
		
		JWTVerifier verifier = JWT.require(algorithm).build();
		DecodedJWT decodedToken = verifier.verify(refreshToken);
		
		var username = decodedToken.getSubject();	
		var roles = decodedToken.getClaim("roles").asList(String.class);
		
		return createAccessToken(username, roles);
	}
	
	
	private String getAccessToken(String username, List<String> roles, Date now, Date validity) {
		String issuerUrl = ServletUriComponentsBuilder
				.fromCurrentContextPath().build().toUriString();
		
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(now)
				.withExpiresAt(validity)
				.withSubject(username)
				.withIssuer(issuerUrl)
				.sign(algorithm)
				.strip();
	}

	private String getRefreshToken(String username, List<String> roles, Date now) {
		Date validityRefreshToken = new Date(now.getTime() + (validityInMilliSeconds * 3));
		
		return JWT.create()
				.withClaim("roles", roles)
				.withIssuedAt(now)
				.withSubject(username)
				.withExpiresAt(validityRefreshToken)
				.sign(algorithm)
				.strip();		
	}
	
	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = userDetailsService.loadUserByUsername(decodedJWT.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());	
	}

	private DecodedJWT decodedToken(String token) {		
		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(alg).build();
		DecodedJWT decodedToken = null;
		try {
			decodedToken = verifier.verify(token);
		}catch (TokenExpiredException e) {
			throw new InvalidJwtAuthenticationException("Token Expired");
		}
		return decodedToken;
	}
	
	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");
		
		if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}	
		return null;
	}	
	
	public boolean validateToken(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		try {
			if(decodedJWT.getExpiresAt().before(new Date())) {
				return false;			
			}
			return true;
		} catch (Exception e) {
			throw new InvalidJwtAuthenticationException("Expired or invalid JWT token!");
		}
	}
}
