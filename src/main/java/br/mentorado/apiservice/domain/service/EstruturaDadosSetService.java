package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.EstruturaDadosSet;
import br.mentorado.apiservice.domain.persistence.entity.Funcionario;

@Service
public class EstruturaDadosSetService implements EstruturaDadosSet {

	@Override
	public Set<String> nomesUnicosOrdenados(List<String> nomes) {

		Set<String> seRepetem = new TreeSet<>();
		Set<String> nomesUnicos = new HashSet<>();
		Set<String> auxiliar = new HashSet<>();

		for (String nome : nomes) {
			if (!nomesUnicos.add(nome)) {
				seRepetem.add(nome);
				auxiliar.add(nome);
			} else if (!auxiliar.contains(nome)) {
				nomesUnicos.add(nome);
			}
		}

		return seRepetem;
	}

	@Override
	public Set<String> valoresPositivosNegativos(int[] valores) {

		int maior = 0;

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] < 10 && valores[i] > maior) {
				maior = valores[i];
			}
		}

		Set<String> maiorValor = new HashSet<>();
		maiorValor.add(String.valueOf(maior));

		return maiorValor;
	}

	@Override
	public Set<Integer> valoresDuplicadosOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> valoresIguais = new TreeSet<>();

		for (Integer valores : valores1) {
			if (valores2.contains(valores)) {
				valoresIguais.add(valores);
			}
		}

		return valoresIguais;
	}

	@Override
	public Set<Integer> valoresDiferentesOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> valoresDiferentes = new TreeSet<>();

		for (Integer valores : valores1) {
			if (!valores2.contains(valores)) {
				valoresDiferentes.add(valores);
			}
		}

		for (Integer valores : valores2) {
			if (!valores1.contains(valores)) {
				valoresDiferentes.add(valores);
			}
		}

		return valoresDiferentes;
	}

	@Override
	public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> valoresDiferentesDaLista1 = new TreeSet<>();

		for (Integer valores : valores1) {
			if (!valores2.contains(valores)) {
				valoresDiferentesDaLista1.add(valores);
			}
		}

		return valoresDiferentesDaLista1;
	}

	@Override
	public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(List<Integer> valores1, List<Integer> valores2) {

		Set<Integer> valoresDiferentesDaLista2 = new TreeSet<>();

		for (Integer valores : valores2) {
			if (!valores1.contains(valores)) {
				valoresDiferentesDaLista2.add(valores);
			}
		}

		return valoresDiferentesDaLista2;
	}

	@Override
	public Set<Funcionario> pessoasUnicasOrdenados(List<Funcionario> pessoas) {

		Set<Funcionario> funcionariosComCpfRepetido = new HashSet<>();

		for (int i = 0; i < pessoas.size(); i++) {
			for (int j = i + 1; j < pessoas.size(); j++) {
				if (pessoas.get(i).getCpfCnpj().equals(pessoas.get(j).getCpfCnpj())) {
					funcionariosComCpfRepetido.add(pessoas.get(i));
					funcionariosComCpfRepetido.add(pessoas.get(j));
				}
			}
		}

		List<Funcionario> listaOrdenada = new ArrayList<>(funcionariosComCpfRepetido);

		Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));

		Set<Funcionario> conjuntoOrdenado = new LinkedHashSet<>(listaOrdenada);

		return conjuntoOrdenado;
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {

		Set<Funcionario> funcionariosComCpfRepetido = new HashSet<>();

		for (Funcionario func1 : pessoas1) {
			for (Funcionario func2 : pessoas2) {
				if (func1.getCpfCnpj().equals(func2.getCpfCnpj())) {
					funcionariosComCpfRepetido.add(func2);
				}
			}
		}

		List<Funcionario> listaOrdenada = new ArrayList<>(funcionariosComCpfRepetido);

		Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));

		Set<Funcionario> conjuntoOrdenado = new LinkedHashSet<>(listaOrdenada);

		return conjuntoOrdenado;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesOrdenados(List<Funcionario> pessoas1, List<Funcionario> pessoas2) {
		Set<Funcionario> funcionariosComCpfRepetido = new HashSet<>();

		for (Funcionario func1 : pessoas1) {
			for (Funcionario func2 : pessoas2) {
				if (!func1.getCpfCnpj().equals(func2.getCpfCnpj())) {
					funcionariosComCpfRepetido.add(func1);
					funcionariosComCpfRepetido.add(func2);
				}
			}
		}

		List<Funcionario> listaOrdenada = new ArrayList<>(funcionariosComCpfRepetido);

		Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));

		Set<Funcionario> conjuntoOrdenado = new LinkedHashSet<>(listaOrdenada);

		return conjuntoOrdenado;
	}

	@Override
	public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {
		Set<Funcionario> funcionariosComCpfDiferente = new HashSet<>();

		for (Funcionario func1 : pessoas1) {
			for (Funcionario func2 : pessoas2) {
				if (!func1.getCpfCnpj().equals(func2.getCpfCnpj())) {
					funcionariosComCpfDiferente.add(func1);
				}
			}
		}

		List<Funcionario> listaOrdenada = new ArrayList<>(funcionariosComCpfDiferente);

		Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));

		Set<Funcionario> conjuntoOrdenado = new LinkedHashSet<>(listaOrdenada);

		return conjuntoOrdenado;
	}

	@Override
	public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(List<Funcionario> pessoas1,
			List<Funcionario> pessoas2) {
		boolean found = false;
		Set<Funcionario> funcionariosComCpfRepetido = new HashSet<>();

		for (Funcionario func1 : pessoas1) {
			for (Funcionario func2 : pessoas2) {
				if (!func1.getCpfCnpj().equals(func2.getCpfCnpj())) {
					funcionariosComCpfRepetido.add(func1);
				}
			}
		}
		List<Funcionario> listaOrdenada = new ArrayList<>(funcionariosComCpfRepetido);

		Collections.sort(listaOrdenada, Comparator.comparing(Funcionario::getNome));

		Set<Funcionario> conjuntoOrdenado = new LinkedHashSet<>(listaOrdenada);

		return conjuntoOrdenado;
	}

}