package com.eurofarma.euforma.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "treinamentos")
public class Treinamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome_treinamento", nullable = false)
	private String name;

	@Column(name = "departamento", nullable = false)
	private Departamento department;

	@Column(name = "duracao", nullable = false)
	private String duration;

	@Column(name = "data", nullable = false)
	private LocalDate date;

	@Column(name = "horario", nullable = false)
	private LocalTime time;

	@Column(name = "descricao", nullable = false)
	private String description;

	@Column(name = "modalidade", nullable = false)
	private Modalidade modality;

	@Column(name = "local", nullable = true)
	private String local;

	public Treinamento() {
	}

	public Treinamento(Long id, String name, Departamento department, String duration, LocalDate date, LocalTime time,
			String description, Modalidade modality, String local) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.duration = duration;
		this.date = date;
		this.time = time;
		this.description = description;
		this.modality = modality;
		this.local = local;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Departamento getDepartment() {
		return department;
	}

	public void setDepartment(Departamento department) {
		this.department = department;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Modalidade getModality() {
		return modality;
	}

	public void setModality(Modalidade modality) {
		this.modality = modality;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treinamento other = (Treinamento) obj;
		return Objects.equals(id, other.id);
	}

}
