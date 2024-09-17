package com.eurofarma.euforma.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.repositories.UserTrainingRepository;

public class UserTrainingService {

	@Autowired
	private UserTrainingRepository repository;

	public UserTraining update(UserTraining userTraining) {
		return repository.save(userTraining);
	}

}
