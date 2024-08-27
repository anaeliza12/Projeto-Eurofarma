package com.eurofarma.euforma.security.vo;

import java.io.Serializable;
import java.util.Objects;

public class AccountCredencialsVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;

	public AccountCredencialsVO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountCredencialsVO other = (AccountCredencialsVO) obj;
		return Objects.equals(password, other.password) && Objects.equals(email, other.email);
	}
}
