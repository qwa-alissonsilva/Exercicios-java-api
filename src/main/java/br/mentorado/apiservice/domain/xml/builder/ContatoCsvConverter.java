package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.ContatoXmlType;

public class ContatoCsvConverter {
	public List<ContatoXmlType> converterCsvParaContato(File file) throws IOException {
		List<ContatoXmlType> contatos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(",");
				ContatoXmlType contato = new ContatoXmlType();
				contato.setCpfCnpj(campos[0].trim());
				contato.setTipo(campos[1].trim());
				contato.setValor(campos[2].trim());
				contatos.add(contato);

			}
		}
		return contatos;
	}
}
