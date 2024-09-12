package com.eurofarma.euforma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.exception.ResourceNotFoundException;
import com.eurofarma.euforma.repositories.TrainingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository repository;

	@Autowired
	private SecurityService securityService;

	public List<Training> findAll() {
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

	public Training update(Training training) {
		var user = securityService.getCurrentUsername();
		try {
			updateData()
		}


	}

	public User update(Long id, User user) {
		User entity = repository.getReferenceById(id);
		try {

			updateData(user, entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		return repository.save(entity);
	}

	private void updateData(User user, User entity) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());

	}

}
