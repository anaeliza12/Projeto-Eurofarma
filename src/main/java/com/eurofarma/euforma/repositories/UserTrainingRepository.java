package com.eurofarma.euforma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eurofarma.euforma.entities.UserTraining;

@Repository
public interface UserTrainingRepository extends JpaRepository<UserTraining, Long> {

}
