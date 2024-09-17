package com.eurofarma.euforma.services;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.exception.ResourceNotFoundException;
import com.eurofarma.euforma.repositories.TrainingRepository;
import com.eurofarma.eurofarma.enums.Status;

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

	public Training subscribe(Training training) {
		var user = securityService.getCurrentUsername();

		Training entity = repository.getReferenceById(training.getId());
		
		var userTraining = new UserTraining((User) user, training, Status.PENDENTE);

		return updateUserTraining(training, user);
	}

	public Training updateUserTraining(UserTraining userTraining) {
		
		entity.getUserTraining().add(userTraining);
		
		var teste = repository.save(entity);
		
		if(teste == null)
			return entity;
		
		return null;
	}

	private void updateData(Training training, Training entity) {
		entity.setName(training.getName());
		entity.setTime(training.getTime());
		entity.setDate(training.getDate());
		entity.setDepartment(training.getDepartment());
		entity.setDescription(training.getDescription());
		entity.setLocal(training.getLocal());
		entity.setModality(training.getModality());

	}
}
