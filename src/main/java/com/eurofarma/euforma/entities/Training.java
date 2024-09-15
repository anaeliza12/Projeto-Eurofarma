package com.eurofarma.euforma.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

import com.eurofarma.eurofarma.enums.Modality;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "treinamentos")
public class Training {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_treinamento", nullable = false)
	private String name;

	@ManyToOne()
	@JoinColumn(name = "departamento_id", nullable = false)
	private Departament department;

	@Column(name = "duracao", nullable = false)
	private String duration;

	@Column(name = "data", nullable = false)
	private LocalDate date;

	@Column(name = "horario", nullable = false)
	private LocalTime time;

	@Column(name = "descricao", nullable = false)
	private String description;

	@Column(name = "modalidade", nullable = false)
	private String modality;

	@Column(name = "local", nullable = true)
	private String local;

	@OneToMany(mappedBy = "training")
	private List<UserTraining> userTrainings;



	public Training() {
	}

	public Training(Long id, String name, Departament department, String duration, LocalDate date, LocalTime time,
			String description, Modality modality, String local) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.duration = duration;
		this.date = date;
		this.time = time;
		this.description = description;
		setModality(modality);
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

	public Departament getDepartment() {
		return department;
	}

	public void setDepartment(Departament department) {
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

	public Modality getModality(String modallity) {
		return Modality.fromValue(modallity);
	}

	public void setModality(Modality modality) {
		if (this.modality != null) {
			this.modality = modality.getName();
		}
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public List<UserTraining> getUserTraining() {
		return userTrainings;
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
		Training other = (Training) obj;
		return Objects.equals(id, other.id);
	}

}
