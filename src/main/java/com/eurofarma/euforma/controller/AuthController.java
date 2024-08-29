package com.eurofarma.euforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurofarma.euforma.security.vo.AccountCredencialsVO;
import com.eurofarma.euforma.services.AuthService;

@RestController
@RequestMapping(name = "/eurofarma")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping(value = "/v1/login")
	public ResponseEntity signIn(@RequestBody AccountCredencialsVO data) {
		if (checkIfParamIsNotNull(data)) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}

		var token = authService.signIn(data);

		if (token == null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid client request");
		}
		return ResponseEntity.ok(token);
	}

	private boolean checkIfParamIsNotNull(AccountCredencialsVO data) {
		return data == null || data.getEmail() == null || data.getEmail().isBlank() || data.getPassword() == null
				|| data.getPassword().isBlank();
	}
}
