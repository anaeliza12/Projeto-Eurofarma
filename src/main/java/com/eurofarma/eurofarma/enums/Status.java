package com.eurofarma.eurofarma.enums;

public enum Status {
	
	PENDENTE("Pendente"), 
	EM_ANDAMENTO("Em andamento"), 
	CONCLUIDO("Concluído");

	private final String valor;

	Status(String valor) {
		this.valor = valor;
	}

	public String getValue() {
		return valor;
	}

	public static Status fromValue(String valor) {
		for (Status status : Status.values()) {
			if (status.getValue() == valor) {
				return status;
			}
		}
		throw new IllegalArgumentException("Valor de status inválido: " + valor);
	}
}