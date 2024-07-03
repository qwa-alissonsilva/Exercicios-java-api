package br.mentorado.apiservice.domain.persistence.entity;

import lombok.Data;

@Data
public class Endereco {
	private Pessoa pessoa;
	private String logradouro;
	private String cidade;
	private String estado;
}
