package br.mentorado.apiservice.domain.xml.builder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.EmpresaXmlType;

public class EmpresaCsvConverter {
	public List<EmpresaXmlType> converterCsvParaEmpresa(File file) throws IOException {
		List<EmpresaXmlType> empresas = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] campos = line.split(",");
				EmpresaXmlType empresa = new EmpresaXmlType();
				empresa.setNomeEmpresa(campos[0].trim());
				empresa.setCodigoProfissao(campos[1].trim());
				empresa.setCpfCnpj(campos[2].trim());
				empresas.add(empresa);

			}
		}
		return empresas;
	}
}
