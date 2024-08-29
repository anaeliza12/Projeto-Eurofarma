package com.eurofarma.euforma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eurofarma.euforma.entities.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

}
