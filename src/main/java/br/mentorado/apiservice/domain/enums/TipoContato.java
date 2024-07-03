package br.mentorado.apiservice.domain.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TipoContato {
	TELEFONE(1, "Telefone"), CELULAR(2, "Celular"), EMAIL(2, "Email");

	private final int id;
	private final String nome;

}
