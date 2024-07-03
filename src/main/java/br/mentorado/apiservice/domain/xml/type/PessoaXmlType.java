package br.mentorado.apiservice.domain.xml.type;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class PessoaXmlType {
	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private Integer idade;
	private String sexo;
	private String cpfCnpj;
	private String estadoCivil;
	private List<EnderecoXmlType> enderecos;
	private List<ContatoXmlType> contatos;
	private EmpresaXmlType empresa;
	private List<FormacaoXmlType> formacoes;
	private PessoaXmlType conjuge;

}
