package com.eurofarma.euforma.entities;

import java.util.Objects;

import com.eurofarma.eurofarma.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_treinamento")
public class UserTraining {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "treinamento_id")
	private Training training;

	private String status;

	public UserTraining() {
	}

	public UserTraining(Long id, User user, Training training, Status status) {
		this.id = id;
		this.user = user;
		this.training = training;
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Training getTraining() {
		return training;
	}

	public void setTraining(Training training) {
		this.training = training;
	}

	public Status getStatus(String value) {
		return Status.fromValue(value);
	}

	public void setStatus(Status status) {
		if(this.status != null) {
			this.status = status.getValue();			
		}
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
		UserTraining other = (UserTraining) obj;
		return Objects.equals(id, other.id);
	}
}
