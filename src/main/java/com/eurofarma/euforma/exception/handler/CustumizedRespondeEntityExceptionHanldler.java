package com.eurofarma.euforma.exception.handler;

import java.nio.file.AccessDeniedException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.eurofarma.euforma.exception.InvalidJwtAuthenticationException;

@ControllerAdvice
@RestController
public class CustumizedRespondeEntityExceptionHanldler {

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException ex) {
		return new ResponseEntity<>("Você não tem permissão para acessar esse recurso.", HttpStatus.FORBIDDEN);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<String> handleInvalidJwtAuthenticationException(Exception ex, WebRequest request) {

		return new ResponseEntity<>("JWT inválido.", HttpStatus.FORBIDDEN);
	}

}
