package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.EmpresaXmlType;
import br.mentorado.apiservice.domain.xml.type.EnderecoXmlType;

public class EnderecoCsvConverter {
	public List<EnderecoXmlType> converterCsvParaEndereco(File file) throws IOException {
		List<EnderecoXmlType> enderecos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(",");
				EnderecoXmlType endereco = new EnderecoXmlType();
				endereco.setCpfCnpj(campos[0].trim());
				endereco.setTipo(campos[1].trim());
				endereco.setPais(campos[2].trim());
				endereco.setRua(campos[3].trim());
				endereco.setNumero(campos[4].trim());
				endereco.setBairro(campos[5].trim());
				endereco.setCidade(campos[6].trim());
				endereco.setEstado(campos[7].trim());
				endereco.setCep(campos[8].trim());
				endereco.setComplementoCep(campos[9].trim());
				enderecos.add(endereco);
			}
		}
		return enderecos;
	}
}
