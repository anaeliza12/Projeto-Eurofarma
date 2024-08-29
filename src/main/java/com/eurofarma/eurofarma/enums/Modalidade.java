package com.eurofarma.eurofarma.enums;

public enum Modalidade {
	
	PRESENCIAL("Presencial"),
	ONLINE("On-line");

	private final String value;

	Modalidade(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Modalidade fromValue(String value) {
		for (Modalidade modality : Modalidade.values()) {
			if (modality.getValue() == value) {
				return modality;
			}
		}
		throw new IllegalArgumentException("Valor inválido: " + value);
	}

	public String getName() {
		return this.name();
	}

	public static Modalidade fromName(String name) {
		try {
			return Modalidade.valueOf(name);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Nome inválido: " + name);
		}
	}
}
