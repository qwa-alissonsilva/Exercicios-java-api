package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.factory.CarregarListas;

public class XmlParser {

	public List<String[]> fazLeituraArquivo(File file) throws IOException {
		List<String[]> lista = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] fields = line.split(",");
				lista.add(fields);
			}
		}

		return lista;
	}

}
