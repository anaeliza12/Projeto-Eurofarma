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

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.services.TrainingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Training", description = "Endpoints for Managing Trainings")
@RequestMapping(value = "/api-eurofarma/training")
public class TrainingController {

	@Autowired
	TrainingService service;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/v1/all")
	@Operation(summary = "Finds all Trainings", description = "A method that brings all trainings from the database", tags = {"Training"},
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
		var trainings = service.findAll();
		return ResponseEntity.ok(trainings);
	}

	@PostMapping(value = "/v1/subscribe")
	@Operation(summary = "Subscribe Training", description = "A method that subscribe the current user by passing JWT access token on Headers and the training in a JSON representation of the training! ", tags = {"Training"},
	   responses =  {@ApiResponse( description = "Success" ,responseCode = "200", 
	   content = {
			   @Content( mediaType = "application/json",
					   schema = @Schema(implementation = Training.class))
	   }),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity subscribe(@RequestBody Training training) {
		var subscribe = service.subscribe(training);
		if (subscribe == null) {
			return ResponseEntity.ok().body("Inscrição cancelada com sucesso");
		}
		return ResponseEntity.ok().body(subscribe);
	}

	@PostMapping(value = "/v1/create")
	@Operation(summary = "Create Training", description = "A method that create a training by passing in a JSON representation of the training! ", tags = {"Training"},
	   responses =  {@ApiResponse( description = "Success" ,responseCode = "200", 
	   content = {
			   @Content( mediaType = "application/json",
					   schema = @Schema(implementation = Training.class))
	   }),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity create(@RequestBody Training training) {
		var newTraining = service.insert(training);
		URI uri = ServletUriComponentsBuilder.fromPath("/{ex}").buildAndExpand(training.getId()).toUri();
		return ResponseEntity.created(uri).body(training);
	}
	
	
	@DeleteMapping(value = "/v1/delete/{id}")
	@Operation(summary = "Delete Training", description = "c ", tags = {"Training"},
	   responses =  {@ApiResponse( description = "Success" ,responseCode = "200", 
	   content = {
			   @Content( mediaType = "application/json",
					   schema = @Schema(implementation = Training.class))
	   }),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "No content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().header("Status", "User-deleted").build();
	}

	@PutMapping(value = "/v1/update/{id}")
	@Operation(summary = "Delete Training", description = "A method that delete a training by passing the id in path variable! ", tags = {"Training"},
	   responses =  {@ApiResponse( description = "Success" ,responseCode = "200", 
	   content = {
			   @Content( mediaType = "application/json",
					   schema = @Schema(implementation = Training.class))
	   }),
		@ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
		@ApiResponse(description = "No content", responseCode = "204", content = @Content),
		@ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)})
	public ResponseEntity update(@RequestBody Training training, @PathVariable Long id) {
		var newTraining = service.update(training, id);
		return ResponseEntity.ok(newTraining);
	}
}
