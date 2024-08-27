package com.eurofarma.euforma.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.eurofarma.euforma.entities.User;
import com.eurofarma.euforma.repositories.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}

}
