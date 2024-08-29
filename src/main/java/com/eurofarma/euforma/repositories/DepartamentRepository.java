package com.eurofarma.euforma.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eurofarma.euforma.entities.Departament;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {

}
