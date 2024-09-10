package com.eurofarma.euforma.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.eurofarma.euforma.exception.ExceptionResponse;
import com.eurofarma.euforma.exception.InvalidJwtAuthenticationException;

@ControllerAdvice
@RestController
public class CustumizedResponseEntityExceptionHanldler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationException(Exception ex,
			WebRequest request) {

		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));

		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}
}
