package br.mentorado.apiservice.domain.xml.type;

import lombok.Data;

@Data
public class EnderecoXmlType {
	private String cpfCnpj;
	private String tipo;
	private String pais;
	private String rua;
	private String numero;
	private String bairro;
	private String cidade;
	private String estado;
	private String cep;
	private String complementoCep;
}
