package com.eurofarma.euforma.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_treinamento")
public class UsuarioTreinamento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "treinamento_id")
	private Treinamento training;

	private Status status;

	public UsuarioTreinamento() {
	}

	public UsuarioTreinamento(Long id, User user, Treinamento training, Status status) {
		this.id = id;
		this.user = user;
		this.training = training;
		this.status = status;
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

	public Treinamento getTraining() {
		return training;
	}

	public void setTraining(Treinamento training) {
		this.training = training;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
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
		UsuarioTreinamento other = (UsuarioTreinamento) obj;
		return Objects.equals(id, other.id);
	}
}
