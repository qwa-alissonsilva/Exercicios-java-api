package br.mentorado.apiservice.domain.persistence.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Pessoa {
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String sexo;
	private String cpfCnpj;
	private String estadoCivil;
	private List<Endereco> enderecos;
	private List<Contato> contatos;
	private Empresa empresa;
	private List<Formacao> formacoes;
	private Pessoa conjuge;
}
