package com.eurofarma.euforma.entities;

import java.util.Objects;

import com.eurofarma.euforma.entities.pk.UserTrainingPK;
import com.eurofarma.eurofarma.enums.Status;

import jakarta.persistence.EmbeddedId;
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

	@EmbeddedId
	private UserTrainingPK id = new UserTrainingPK();
	private String status;

	public UserTraining() {
	}

	public UserTraining(User user, Training training, Status status) {
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

	public Training getTraining() {
		return id.getTraining();
	}

	public void setTraining(Training training) {
		id.setTraining(training);
	}

	public Status getStatus(String value) {
		return Status.fromValue(value);
	}

	public void setStatus(Status status) {
		this.status = status.getValue();
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
