package br.mentorado.apiservice.domain.xml.type;

import lombok.Data;

@Data
public class ContatoXmlType {
	private String cpfCnpj;
	private String tipo;
	private String valor;
}
