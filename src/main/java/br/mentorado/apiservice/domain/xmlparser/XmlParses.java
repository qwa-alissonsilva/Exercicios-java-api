package br.mentorado.apiservice.domain.xmlparser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class XmlParses {

	public void criarObjeto(String[] values, Consumer<String>... setters) {
		for (int i = 0; i < Math.min(values.length, setters.length); i++) {
			try {	
				setters[i].accept(values[i]);
			} catch (Exception e) {
				setters[i].accept("");
			}
		}
	}

	public List<String> converter(Scanner arquivo) {
		List<String> lista = new ArrayList<>();
		while (arquivo.hasNextLine()) {
			String linha1 = arquivo.nextLine();
			lista.add(linha1);
		}

		return lista;
	}
}
