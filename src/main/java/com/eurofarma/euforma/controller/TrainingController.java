package com.eurofarma.euforma.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
//	public ResponseEntity subscribe(UserTraining userTraining) {
//		 
//		
//	}
}
