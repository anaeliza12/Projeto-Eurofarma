package com.eurofarma.euforma.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.repositories.UserTrainingRepository;

@Service
public class UserTrainingService {

	@Autowired
	private UserTrainingRepository repository;

	public UserTraining create(UserTraining userTraining) {
		return repository.save(userTraining);
	}

}
