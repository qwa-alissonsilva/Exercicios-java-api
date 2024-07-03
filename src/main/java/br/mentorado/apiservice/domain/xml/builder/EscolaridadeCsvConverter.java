package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.EnderecoXmlType;
import br.mentorado.apiservice.domain.xml.type.EscolaridadeXmlType;

public class EscolaridadeCsvConverter {
	public List<EscolaridadeXmlType> converterCsvParaEscolaridade(File file) throws IOException {
		List<EscolaridadeXmlType> EscolaridadeXmlTypes = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(",");
				EscolaridadeXmlType EscolaridadeXmlType = new EscolaridadeXmlType();
				EscolaridadeXmlType.setCpfCnpj(campos[0].trim());
				EscolaridadeXmlType.setCodigoInstituicao(campos[1].trim());
				EscolaridadeXmlType.setConcluido(campos[2].trim());
				EscolaridadeXmlType.setDataTermino(campos[3].trim());
				EscolaridadeXmlType.setSemestreAtual(campos[4].trim());
				EscolaridadeXmlTypes.add(EscolaridadeXmlType);
			}
		}
		return EscolaridadeXmlTypes;
	}
}
