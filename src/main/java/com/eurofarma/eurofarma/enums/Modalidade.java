package com.eurofarma.eurofarma.enums;

public enum Modalidade {
	
	PRESENCIAL(1),
	ONLINE(2);

	private final int value;

	Modalidade(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static Modalidade fromValue(int value) {
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
