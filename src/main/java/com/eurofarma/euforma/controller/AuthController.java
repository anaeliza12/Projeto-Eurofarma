package com.eurofarma.euforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurofarma.euforma.security.vo.AccountCredencialsVO;
import com.eurofarma.euforma.services.AuthService;

@RestController
@RequestMapping("/api-eurofarma/auth")
public class AuthController {

	@Autowired
	AuthService authService;

	@SuppressWarnings("rawtypes")
	@PostMapping(value = "/v1/login")
	public ResponseEntity signIn(@RequestBody AccountCredencialsVO data) {
		if (checkIfParamIsNotNull(data))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		var token = authService.signIn(data);
		if (token == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		return token;
	}

	@SuppressWarnings("rawtypes")
	@PutMapping(value = "v1/refresh/{email}")
	public ResponseEntity refreshToken(@PathVariable String email,
			@RequestHeader("Authorization") String refreshToken) {
		if (checkIfParamIsNotNull(email, refreshToken))
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		var token = authService.refreshToken(email, refreshToken);
		if (token == null)
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		return token;
	}

	private boolean checkIfParamIsNotNull(String email, String refreshToken) {
		return refreshToken == null || refreshToken.isBlank() || email == null || email.isBlank();
	}

	private boolean checkIfParamIsNotNull(AccountCredencialsVO data) {
		return data == null || data.getEmail() == null || data.getEmail().isBlank() || data.getPassword() == null
				|| data.getPassword().isBlank();
	}
}