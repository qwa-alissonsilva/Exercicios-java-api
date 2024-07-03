package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.PessoaXmlType;

public class PessoaCsvConverter {
	public List<PessoaXmlType> converterCsvParaPessoas(File file) throws IOException {
		List<PessoaXmlType> pessoas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(",");
				PessoaXmlType pessoa = new PessoaXmlType();
				pessoa.setNome(campos[0].trim());
				pessoa.setSobrenome(campos[1].trim());
				pessoa.setDataNascimento(campos[2].trim());
				pessoa.setSexo(campos[3].trim());
				pessoa.setCpfCnpj(campos[4].trim());
				pessoa.setEstadoCivil(campos[5].trim());
				pessoas.add(pessoa);

			}
		} catch (Exception e) {

		}

		return pessoas;
	}
}
