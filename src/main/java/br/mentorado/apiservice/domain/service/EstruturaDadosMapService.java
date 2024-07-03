package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.EstruturaDadosMap;
import br.mentorado.apiservice.domain.persistence.entity.ContatoFuncionario;
import br.mentorado.apiservice.domain.persistence.entity.Funcionario;

@Service
public class EstruturaDadosMapService implements EstruturaDadosMap {

	@Override
	public Map<String, Integer> nomeFrequencia(List<String> nomes) {

		Map<String, Integer> repetição = new HashMap<>();

		for (String nome : nomes) {
			repetição.put(nome, repetição.getOrDefault(nome, 0) + 1);
		}

		return repetição;
	}

	@Override
	public Map<String, Integer> mapaFrequenciaValores(Map<String, String> mapa) {

		Map<String, Integer> frequencias = new HashMap<>();

		for (String letra : mapa.values()) {
			frequencias.put(letra, frequencias.getOrDefault(letra, 0) + 1);
		}

		return frequencias;
	}

	@Override
	public Map<String, Integer> mapaFrequenciaValoresLista(final Map<String, List<String>> mapa) {

		Map<String, Integer> contagem = new HashMap<>();

		for (Map.Entry<String, List<String>> entry : mapa.entrySet()) {
			List<String> valores = entry.getValue();

			for (String valor : valores) {
				if (contagem.containsKey(valor)) {
					contagem.put(valor, contagem.get(valor) + 1);
				} else {
					contagem.put(valor, 1);
				}
			}
		}
		return contagem;
	}

	@Override
	public Map<String, List<String>> nomeTelefones(List<String> elemento) {

		Map<String, List<String>> resultado = new HashMap<>();

		for (String palavra : elemento) {
			String[] partes = palavra.split(";");
			String nome = partes[0];

			List<String> numeros = new ArrayList<>();

			for (int i = 1; i < partes.length; i++) {
				numeros.addAll(Arrays.asList(partes[i].split(",")));
			}

			resultado.put(nome, numeros);
		}
		return resultado;
	}

	@Override
	public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(List<String> elemento) {

		Map<Funcionario, List<ContatoFuncionario>> mapaContatos = new HashMap<>();
		Funcionario funcionario = new Funcionario();
		ContatoFuncionario contato = new ContatoFuncionario();

		for (String palavra : elemento) {
			String[] partes = palavra.split(";");
			String nome = partes[0];
			funcionario.setNome(nome);

			for (int i = 0; i < partes.length; i++) {
				if (partes[i] == partes[0]) {
					continue;
				} else {
					contato.setValor(partes[i]);
				}
			}
			if (!mapaContatos.containsKey(funcionario)) {
				mapaContatos.put(funcionario, new ArrayList<>());
			}
			mapaContatos.get(funcionario).add(contato);
		}
		return mapaContatos;
	}

	@Override
	public List<String> chavesMapa(Map<String, String> mapa) {

		List<String> lista = new ArrayList<>();

		for (String valor : mapa.values()) {
			lista.add(valor);
		}

		return lista;
	}

	@Override
	public List<String> valoresMapa(Map<String, String> mapa) {

		List<String> lista = new ArrayList<>();

		for (String chave : mapa.keySet()) {
			lista.add(chave);
		}

		return lista;
	}

	@Override
	public Map<String, List<Integer>> nomeTelefones(int limite) {

		Map<String, List<Integer>> mapaContatos = new HashMap<>();
		List<Integer> pares = new ArrayList<>();
		List<Integer> impares = new ArrayList<>();
		List<Integer> primo = new ArrayList<>();
		List<Integer> multiploDe10 = new ArrayList<>();
		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				pares.add(i);
			}

			if (i % 2 != 0) {
				impares.add(i);
			}

			if (primo(i)) {
				primo.add(i);
			}
			if (i % 10 == 0 && i != 0) {
				multiploDe10.add(i);
			}
		}

		mapaContatos.put("NUMEROS_PARES", pares);
		mapaContatos.put("NUMEROS_IMPARES", impares);
		mapaContatos.put("NUMEROS_PRIMOS", primo);
		mapaContatos.put("NUMEROS_MULTIPLOS_10", multiploDe10);

		return mapaContatos;
	}

	@Override
	public Integer maiorNumeroEntreValores(Map<String, List<Integer>> map) {

		Integer maiorNumero = 0;
		for (List<Integer> numeros : map.values()) {
			for (Integer numero : numeros) {
				if (numero > maiorNumero) {
					maiorNumero = numero;
				}
			}
		}
		return maiorNumero;
	}

	@Override
	public String chaveMaiorNumeroEntreValores(Map<String, List<Integer>> map) {

		Integer maiorNumero = 0;
		for (List<Integer> numeros : map.values()) {
			for (Integer numero : numeros) {
				if (numero > maiorNumero) {
					maiorNumero = numero;
				}
			}
		}
		return String.valueOf(maiorNumero);

	}

	public boolean primo(int num) {
		if (num <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}