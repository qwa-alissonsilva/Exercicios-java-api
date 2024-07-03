package br.mentorado.apiservice.domain.xml.type;

import lombok.Data;

@Data
public class EscolaridadeXmlType {
	private String cpfCnpj;
	private String codigoInstituicao;
	private String concluido;
	private String dataTermino;
	private String SemestreAtual;
}
