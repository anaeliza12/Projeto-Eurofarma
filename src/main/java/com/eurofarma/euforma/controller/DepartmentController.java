package com.eurofarma.euforma.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eurofarma.euforma.entities.Departament;
import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.services.DepartmentService;
import com.eurofarma.euforma.services.TrainingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Department", description = "Endpoints for Department Trainings")
@RequestMapping(value = "/api-eurofarma/department")
public class DepartmentController {

	@Autowired
	DepartmentService service;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/v1/all")
	@Operation(summary = "Finds all departments", description = "A method that brings all departments from the database", tags = {"Department"},
	responses = { 
			@ApiResponse(description = "Success", responseCode = "200", 
					content = { 
							@Content(
									mediaType = "application/json",
									array =  @ArraySchema(schema = @Schema(implementation = Departament.class)))
					}),
			@ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
			@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
			@ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
			@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity findAll() {
		var department = service.findAll();
		return ResponseEntity.ok(department);
	}

}
