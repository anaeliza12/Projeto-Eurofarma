package com.eurofarma.euforma.security.jwt;

import java.util.Base64;

import java.util.Date;

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
import com.auth0.jwt.interfaces.DecodedJWT;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.exception.InvalidJwtAuthenticationException;
import com.eurofarma.euforma.security.vo.TokenVO;


import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
@Service
public class TokenProvider {

	@Value("${spring.jwt.secret.key:secret}")
	private String secretKey;

	@Value("${spring.jwt.expire.length:3600000}")
	private long vallidityInMillySeconds = 3600000;

	@Autowired
	private UserDetailsService userDetailsService;

	private Algorithm algorithm;

	@PostConstruct
	public void init() {
		var secret = Base64.getEncoder().encode(secretKey.getBytes());
		algorithm = Algorithm.HMAC256(secret);
	}

	public TokenVO createAccessToken(User user) {
		Date tokenCreation = new Date();
		Date tokenExpiration = new Date(tokenCreation.getTime() + vallidityInMillySeconds);

		var accessToken = getAccessToken(user, tokenCreation, tokenExpiration);
		var refreshToken = getRefreshToken(user, tokenCreation);

		return new TokenVO(user.getEmail(), true, tokenCreation, tokenExpiration, accessToken, refreshToken);
	}

	private String getAccessToken(User user, Date now, Date vallidity) {
		String issuerUrl = ServletUriComponentsBuilder.fromCurrentContextPath().toUriString();

		return JWT.create().withSubject(user.getEmail()).withClaim("roles", user.getRoles()).withIssuedAt(now)
				.withExpiresAt(vallidity).withIssuer(issuerUrl).sign(algorithm).strip();

	}

	private String getRefreshToken(User user, Date now) {
		Date vallidity = new Date(now.getTime() + (vallidityInMillySeconds * 3));

		return JWT.create().withSubject(user.getEmail()).withExpiresAt(vallidity).sign(algorithm).strip();
	}

	public Authentication getAuthentication(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		UserDetails userDetails = userDetailsService.loadUserByUsername(decodedJWT.getSubject());
		return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
	}

	private DecodedJWT decodedToken(String token) {
		Algorithm alg = Algorithm.HMAC256(secretKey.getBytes());
		JWTVerifier verifier = JWT.require(alg).build();
		DecodedJWT decodedToken = verifier.verify(token);
		return decodedToken;
	}

	public String resolveToken(HttpServletRequest req) {
		String bearerToken = req.getHeader("Authorization");

		if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring("Bearer ".length());
		}
		return null;
	}

	public boolean validateToken(String token) {
		DecodedJWT decodedJWT = decodedToken(token);
		try {
			if (decodedJWT.getExpiresAt().before(new Date())) {
				return false;
			}
			return true;
		} catch (Exception e) {
			throw new InvalidJwtAuthenticationException("Expired or invalid JWT token!");
		}
	}
}
