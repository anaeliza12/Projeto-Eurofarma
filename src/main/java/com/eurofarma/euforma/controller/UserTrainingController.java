package com.eurofarma.euforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.services.UserTrainingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "UserTraining", description = "Endpoints for Managing subscribes")
@RequestMapping(value = "/api-eurofarma/userTraining")
public class UserTrainingController {

	@Autowired
	UserTrainingService service;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/v1/all")
	@Operation(summary = "Finds all subscribes", description = "A method that brings all subscribes from the database", tags = {"UserTraining"},
	responses = { 
			@ApiResponse(description = "Success", responseCode = "200", 
					content = { 
							@Content(
									mediaType = "application/json",
									array =  @ArraySchema(schema = @Schema(implementation = Training.class)))
					}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity findAll() {
		var userTrainings = service.findAll();
		return ResponseEntity.ok(userTrainings);
	}
}
