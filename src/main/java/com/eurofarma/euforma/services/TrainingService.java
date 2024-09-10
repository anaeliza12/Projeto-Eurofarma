package com.eurofarma.euforma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.exception.ResourceNotFoundException;
import com.eurofarma.euforma.repositories.TrainingRepository;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository repository;
	
	public List<Training> findAll(){
		return repository.findAll();
	}
	
	public Training findById(Long id) {
		Optional<Training> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Training not found"));
	}

	public Training insert(Training training) {
		return repository.save(training);
	}

	public void delete(Long training) {
		try {
			repository.deleteById(training);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Training not found");
		}
	}
}
