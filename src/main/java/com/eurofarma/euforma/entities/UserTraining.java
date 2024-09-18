package com.eurofarma.euforma.entities;

import java.util.Objects;

import com.eurofarma.euforma.entities.pk.UserTrainingPK;
import com.eurofarma.eurofarma.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_treinamento")
public class UserTraining {

	@EmbeddedId
	private UserTrainingPK id = new UserTrainingPK();
	
	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private Status status;

	public UserTraining() {
	}

	public UserTraining(User user, Training training, String status) {
		id.setTraining(training);
		id.setUser(user);
		setStatus(status);
	}
	
	public User getUser() {
		return id.getUser();
	}

	public void setUser(User user) {
		id.setUser(user);
	}
	
	@JsonIgnore
	public Training getTraining() {
		return id.getTraining();
	}

	public void setTraining(Training training) {
		id.setTraining(training);
	}

	public String getStatus() {
		return status.getValue();
	}

	public void setStatus(String status) {
		this.status = Status.fromValue(status);
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
