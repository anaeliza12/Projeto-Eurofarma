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

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.security.vo.AccountCredencialsVO;
import com.eurofarma.euforma.security.vo.TokenVO;
import com.eurofarma.euforma.services.AuthService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api-eurofarma/auth")
@Tag(name = "Authentication Endpoint",  description = "Endpoints for authenticate an user")
public class AuthController {

	@Autowired
	AuthService authService;

	@SuppressWarnings("rawtypes")
	@Operation(summary = "Authenticates an user and returns a token", description = "A method that return a JWT token", tags = {
			"Training" }, responses = { @ApiResponse(description = "Success", responseCode = "200", content = {
					@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TokenVO.class)))}),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
			})
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
	@Operation(summary = "Refresh token for authenticated user and returns a token", description = "A method that return a refresh token", tags = {
	"Training" }, responses = { @ApiResponse(description = "Success", responseCode = "200", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = TokenVO.class)))}),
	@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
	})
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