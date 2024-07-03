package br.mentorado.apiservice.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoEndereco {
	RESIDENCIAL(1, "Telefone"), PROFISSIONAL(2, "Celular");

	private final int id;
	private final String nome;

}
