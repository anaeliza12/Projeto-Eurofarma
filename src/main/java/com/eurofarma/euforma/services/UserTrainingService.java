package com.eurofarma.euforma.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Departament;
import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.repositories.UserTrainingRepository;

@Service
public class UserTrainingService {

	@Autowired
	private UserTrainingRepository repository;

	@Autowired
	private SecurityService securityService;

	public UserTraining create(UserTraining userTraining) {
		return repository.save(userTraining);
	}

	public void delete(UserTraining userTraining) {
		repository.delete(userTraining);
	}

	public List<Training> findAll() {
		var user = (User) securityService.getCurrentUsername();
		var subscribes = repository.findAll();
		List<Training> subsUser = new ArrayList<>();

		for (UserTraining u : subscribes) {
			if (u.getUser().getId() == user.getId()) {
				subsUser.add(u.getTraining());
			}
		}

		return subsUser;

	}

}
