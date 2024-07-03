package br.mentorado.apiservice.domain.xml.factory;

import java.io.File;

import lombok.Data;

@Data
public class CarregarListas {
	private File pessoaFile = new File("src/resources/xml/Pessoa.csv");
	private File contatoFile = new File("src/resources/xml/Contato.csv");
	private File empresaFile = new File("src/resources/xml/Empresa.csv");
	private File enderecoFile = new File("src/resources/xml/Endereco.csv");
	private File escolaridadeFile = new File("src/resources/xml/Escolaridade.csv");
	private File formacaoFile = new File("src/resources/xml/Formacao.csv");
	private File instituicaoFile = new File("src/resources/xml/Instituicao.csv");
	private File profissaoFile = new File("src/resources/xml/Profissao.csv");
}
