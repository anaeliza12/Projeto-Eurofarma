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
import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.services.TrainingService;

@RestController
@RequestMapping(value = "/api-eurofarma/training")
public class TrainingController {

	@Autowired
	TrainingService service;

	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/v1/all")
	public ResponseEntity findAll() {
		var trainings = service.findAll();
		return ResponseEntity.ok(trainings);
	}

	@PostMapping(value = "/v1/subscribe")
	public ResponseEntity subscribe(@RequestBody Training training) {
		var subscribe = service.subscribe(training);
		if (subscribe == null) {
			return ResponseEntity.ok().body("Inscrição cancelada com sucesso");
		}
		return ResponseEntity.ok().body(subscribe);
	}

	@PostMapping(value = "/v1/create")
	public ResponseEntity create(@RequestBody Training training) {
		var newTraining = service.insert(training);
		URI uri = ServletUriComponentsBuilder.fromPath("/{ex}").buildAndExpand(training.getId()).toUri();
		return ResponseEntity.created(uri).body(training);
	}

	@DeleteMapping(value = "/v1/delete/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().header("Status", "User-deleted").build();
	}

	@PutMapping(value = "/v1/update/{id}")
	public ResponseEntity update(@RequestBody Training training, @PathVariable Long id) {
		var newTraining = service.update(training, id);
		return ResponseEntity.ok(newTraining);
	}
}
