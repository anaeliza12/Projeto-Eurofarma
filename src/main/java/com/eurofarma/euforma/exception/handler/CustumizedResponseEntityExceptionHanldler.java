package com.eurofarma.euforma.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.eurofarma.euforma.exception.ExceptionResponse;
import com.eurofarma.euforma.exception.InvalidJwtAuthenticationException;
import com.eurofarma.euforma.exception.ResourceNotFoundException;


@ControllerAdvice
public class CustumizedResponseEntityExceptionHanldler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TokenExpiredException.class)
	public final ResponseEntity<ExceptionResponse> handleTokenExpiredException(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.UNAUTHORIZED);
	}

}
