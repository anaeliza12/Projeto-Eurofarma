package com.eurofarma.eurofarma.enums;

public enum Modality {
	
	PRESENCIAL("Presencial"),
	ONLINE("On-line");

	private final String value;

	Modality(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static Modality fromValue(String value) {
		for (Modality modality : Modality.values()) {
			if (modality.getValue() == value) {
				return modality;
			}
		}
		throw new IllegalArgumentException("Valor inválido: " + value);
	}

	public String getName() {
		return this.name();
	}

	public static Modality fromName(String name) {
		try {
			return Modality.valueOf(name);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Nome inválido: " + name);
		}
	}
}
