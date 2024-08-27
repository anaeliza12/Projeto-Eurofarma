package com.eurofarma.euforma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eurofarma.euforma.entities.User;


public interface UserRepository extends JpaRepository<UserRepository, Long> {

	@Query("SELECT u FROM Usuarios u WHERE email =:email")
	User findByEmail(@Param("email") String email);
}
