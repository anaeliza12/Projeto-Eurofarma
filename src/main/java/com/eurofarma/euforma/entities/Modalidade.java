package com.eurofarma.euforma.entities;

public enum Modalidade {
	
	PRESENCIAL(1),
	ONLINE(2);

	private final int valor;

	Modalidade(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static Modalidade fromValor(int valor) {
		for (Modalidade modalidade : Modalidade.values()) {
			if (modalidade.getValor() == valor) {
				return modalidade;
			}
		}
		throw new IllegalArgumentException("Valor inválido: " + valor);
	}

	public String getNome() {
		return this.name();
	}

	public static Modalidade fromNome(String nome) {
		try {
			return Modalidade.valueOf(nome);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("Nome inválido: " + nome);
		}
	}
}
