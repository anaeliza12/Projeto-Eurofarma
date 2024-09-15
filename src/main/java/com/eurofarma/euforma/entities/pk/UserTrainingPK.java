package com.eurofarma.euforma.entities.pk;

import java.util.Objects;

import com.eurofarma.euforma.entities.Training;
import com.eurofarma.euforma.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class UserTrainingPK {

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "training_id")
	private Training training;

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

	@Override
	public int hashCode() {
		return Objects.hash(training, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserTrainingPK other = (UserTrainingPK) obj;
		return Objects.equals(training, other.training) && Objects.equals(user, other.user);
	}

}
