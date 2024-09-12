package com.eurofarma.euforma.services;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.repositories.UserRepository;
import com.eurofarma.euforma.security.jwt.TokenProvider;
import com.eurofarma.euforma.security.vo.AccountCredencialsVO;
import com.eurofarma.euforma.security.vo.TokenVO;


@Service
public class AuthService {

	@Autowired
	private TokenProvider tokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserRepository repository;

	@SuppressWarnings("rawtypes")
	public ResponseEntity signIn(AccountCredencialsVO data) {
		try {
			 Logger logger = Logger.getLogger(ResponseEntity.class.getName());
			logger.info("CHAMANDO  AuthService ");	
			
			var email = data.getEmail();
			var password = data.getPassword();

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));

			var user = repository.findByUsername(email);

			var tokenResponse = new TokenVO();

			if (user != null) {
				tokenResponse = tokenProvider.createAccessToken(email, user.getRoles());

			} else {
				throw new UsernameNotFoundException("Email " + email + " not found!");
			}
			return ResponseEntity.ok(tokenResponse);

		} catch (Exception e) {
			throw new BadCredentialsException("Invalid email/password supplied!");
		}
	}
	
	@SuppressWarnings("rawtypes")
	public ResponseEntity refreshToken(String email, String refreshToken) {
		var user = repository.findByUsername(email);
		
		var tokenResponse = new TokenVO();	
		if (user != null) {
			tokenResponse = tokenProvider.refreshToken(refreshToken);
			
		} else {
			throw new UsernameNotFoundException("Email " + email + " not found!");
		}
		return ResponseEntity.ok(tokenResponse);

	}
}
