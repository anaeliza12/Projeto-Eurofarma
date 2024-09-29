package com.eurofarma.euforma.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.eurofarma.euforma.entities.Departament;
import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.exception.ResourceNotFoundException;
import com.eurofarma.euforma.repositories.DepartmentRepository;
import com.eurofarma.euforma.repositories.TrainingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;

	public List<Departament> findAll() {
		return repository.findAll();
	}

}
