package com.eurofarma.eurofarma.enums;

public enum Status {
	PENDENTE(1), 
	EM_ANDAMENTO(2), 
	CONCLUIDO(3);

	private final int valor;

	Status(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static Status fromValor(int valor) {
		for (Status status : Status.values()) {
			if (status.getValor() == valor) {
				return status;
			}
		}
		throw new IllegalArgumentException("Valor de status inválido: " + valor);
	}
}