package com.eurofarma.euforma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eurofarma.euforma.entities.UserTraining;
import com.eurofarma.euforma.entities.pk.UserTrainingPK;

@Repository
public interface UserTrainingRepository extends JpaRepository<UserTraining, UserTrainingPK> {

}
