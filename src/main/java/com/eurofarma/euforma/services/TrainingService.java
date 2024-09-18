package com.eurofarma.euforma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.exception.ResourceNotFoundException;
import com.eurofarma.euforma.repositories.TrainingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TrainingService {

	@Autowired
	private TrainingRepository repository;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserTrainingService userTrainingService;

	public List<Training> findAll() {
		return repository.findAll();
	}

	public Training findById(Long id) {
		Optional<Training> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Training: " + id + " not found"));
	}

	public Training insert(Training training) {
		return repository.save(training);
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Training: " + id + " not found");
		}
	}

	public Training subscribe(Training training) {
		var user = securityService.getCurrentUsername();
		var statusPadrao = "Pendente";
		Training entity = repository.getReferenceById(training.getId());

		for (UserTraining u : entity.getUserTraining()) {
			if (u.getTraining().getId() == training.getId()) {
				userTrainingService.delete(u);
				return null;
			}
		}

		var userTraining = new UserTraining((User) user, training, statusPadrao);

		userTrainingService.create(userTraining);

		return updateUserTraining(userTraining, entity);
	}

	public Training updateUserTraining(UserTraining userTraining, Training training) {
		training.getUserTraining().add(userTraining);

		return repository.save(training);
	}

	public Training update(Training newTraining, Long id) {
		var entity = repository.getReferenceById(id);
		try {
			updateData(newTraining, entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Training: " + id + " not found");
		}
		return repository.save(entity);
	}

	private void updateData(Training newTraining, Training entity) {
		entity.setName(newTraining.getName());
		entity.setDepartment(newTraining.getDepartment());
		entity.setDuration(newTraining.getDuration());
		entity.setDate(newTraining.getDate());
		entity.setTime(newTraining.getTime());
		entity.setDescription(newTraining.getDescription());
		entity.setModality(newTraining.getModality());
		entity.setLocal(newTraining.getLocal());
	}
}
