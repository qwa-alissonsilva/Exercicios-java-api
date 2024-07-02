package br.mentorado.apiservice.domain.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.mentorado.apiservice.domain.LogicaProgramacao;
import br.mentorado.apiservice.domain.persistence.entity.Funcionario;

public class LogicaProgramacaoService implements LogicaProgramacao {

	@Override
	public List<Funcionario> conversaoStringParaPessoa(List<String> lista) {

		List<Funcionario> listaFuncionarios = new ArrayList<>();

		for (int i = 0; i < lista.size(); i++) {
			if (verificaLista(lista.get(i))) {

				int idade = 0;
				LocalDate data = null;
				BigDecimal salario = null;
				BigDecimal resultado = null;

				Funcionario funcionario = new Funcionario();

				String dataASerFormatada = lista.get(i).substring(40, 48);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");

				try {
					data = LocalDate.parse(dataASerFormatada, formatter);
					LocalDate dataAtual = LocalDate.now();
					Period periodo = Period.between(data, dataAtual);
					idade = periodo.getYears();
				} catch (DateTimeParseException e) {
					continue;
				}

				Instant instant = data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
				Date dataTipoDate = Date.from(instant);

				try {
					salario = new BigDecimal(lista.get(i).substring(142, 153).replaceAll("\\D", ""));
				} catch (NumberFormatException e) {
					continue;
				}

				resultado = salario;

				if (idade < 18) {
					BigDecimal taxaIdadeMenor18 = new BigDecimal("0.2");
					resultado = resultado.multiply(taxaIdadeMenor18);

				} else if (idade <= 23) {
					BigDecimal taxaIdadeMenorIgual23 = new BigDecimal("0.15");
					resultado = resultado.multiply(taxaIdadeMenorIgual23);

				} else if (idade <= 31) {
					BigDecimal taxaIdadeMenorIgual31 = new BigDecimal("0.1");
					resultado = resultado.multiply(taxaIdadeMenorIgual31);

				} else if (idade <= 50) {
					BigDecimal taxaIdadeMenorIgual50 = new BigDecimal("0.05");
					resultado = resultado.multiply(taxaIdadeMenorIgual50);

				} else {
					BigDecimal taxaIdadeMaior50 = new BigDecimal("0.01");
					resultado = resultado.multiply(taxaIdadeMaior50);

				}

				BigDecimal salarioLiquido = salario.subtract(resultado);

				funcionario.setNome(lista.get(i).substring(0, 20).trim());
				funcionario.setSobrenome(lista.get(i).substring(20, 40).trim());
				funcionario.setSexo(lista.get(i).substring(48, 49).trim());
				funcionario.setProfissao(lista.get(i).substring(49, 89).trim());
				funcionario.setCpfCnpj(lista.get(i).substring(89, 103).trim());
				funcionario.setEscolaridade(lista.get(i).substring(103, 143).trim());
				funcionario.setDataNascimento(dataTipoDate);
				funcionario.setSalario(salario);
				funcionario.setIdade(idade);
				funcionario.setMaiorIdade(idade >= 18);
				funcionario.setTaxa(resultado);
				funcionario.setSalarioLiquido(salarioLiquido);

				listaFuncionarios.add(funcionario);

			}
		}

		return listaFuncionarios;
	}

	private boolean verificaLista(String palavra) {
		return palavra.length() == 153;
	}

	@Override
	public List<String> conversaoPessoaParaString(List<Funcionario> pessoas) {

		List<String> listaString = new ArrayList<>();

		for (Funcionario funcionario : pessoas) {
			StringBuilder stringBuilder = new StringBuilder();
			try {
				stringBuilder.append(verificaString(funcionario.getNome(), 20));
				stringBuilder.append(verificaString(funcionario.getSobrenome(), 20));

				SimpleDateFormat formatoData = new SimpleDateFormat("ddMMyyyy");
				String dataNascimento = formatoData.format(funcionario.getDataNascimento());
				stringBuilder.append(verificaString(dataNascimento, 8));
				stringBuilder.append(verificaString(funcionario.getSexo(), 1));
				stringBuilder.append(verificaString(funcionario.getProfissao(), 40));
				stringBuilder.append(verificaString(funcionario.getCpfCnpj(), 14));
				stringBuilder.append(verificaString(funcionario.getEscolaridade(), 40));

				stringBuilder.append(verificaString(funcionario.getSalario().toString(), 10));
			} catch (Exception e) {
				continue;
			}

			listaString.add(stringBuilder.toString());
		}
		return listaString;
	}

	private String verificaString(String texto, int tamanho) {

		if (texto.length() >= tamanho) {
			return texto.substring(0, tamanho);
		} else {
			StringBuilder sb = new StringBuilder(texto);
			while (sb.length() < tamanho) {
				sb.append(' ');
			}
			return sb.toString();
		}
	}

	@Override
	public Funcionario conversaoArrayParaPessoa(String[] array) {
		Funcionario funcionario = new Funcionario();
		if (array.length == 8) {

			try {
				String dataASerFormatada = array[2];
				LocalDate data = null;

				if (!dataASerFormatada.trim().isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
					data = LocalDate.parse(dataASerFormatada, formatter);
				}

				Date dataTipoDate = null;
				if (data != null) {
					Instant instant = data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
					dataTipoDate = Date.from(instant);
				}

				BigDecimal salario = null;
				if (!array[7].trim().isEmpty()) {
					salario = new BigDecimal(array[7]);
				}

				BigDecimal resultado = salario;

				if (data != null && salario != null) {
					LocalDate dataAtual = LocalDate.now();
					Period periodo = Period.between(data, dataAtual);
					int idade = periodo.getYears();

					if (idade < 18) {
						BigDecimal taxaIdadeMenor18 = new BigDecimal("0.2");
						resultado = resultado.multiply(taxaIdadeMenor18);
					} else if (idade <= 23) {
						BigDecimal taxaIdadeMenorIgual23 = new BigDecimal("0.15");
						resultado = resultado.multiply(taxaIdadeMenorIgual23);
					} else if (idade <= 31) {
						BigDecimal taxaIdadeMenorIgual31 = new BigDecimal("0.1");
						resultado = resultado.multiply(taxaIdadeMenorIgual31);
					} else if (idade <= 50) {
						BigDecimal taxaIdadeMenorIgual50 = new BigDecimal("0.05");
						resultado = salario.multiply(taxaIdadeMenorIgual50);
					} else {
						BigDecimal taxaIdadeMaior50 = new BigDecimal("0.01");
						resultado = resultado.multiply(taxaIdadeMaior50);
					}

					funcionario.setIdade(idade);
					funcionario.setMaiorIdade(idade >= 18);

					funcionario.setTaxa(resultado);
				}
				BigDecimal salarioLiquido = salario.subtract(resultado);

				funcionario.setNome(array[0].trim());
				funcionario.setSobrenome(array[1].trim());
				funcionario.setDataNascimento(dataTipoDate);
				funcionario.setSexo(array[3].trim());
				funcionario.setProfissao(array[4].trim());
				funcionario.setCpfCnpj(array[5].trim());
				funcionario.setEscolaridade(array[6].trim());
				funcionario.setSalario(salario);
				funcionario.setSalarioLiquido(salarioLiquido);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return funcionario;
	}

	@Override
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(String[][] arrayMultidimensional) {

		List<Funcionario> listaFuncionario = new ArrayList<>();

		for (int i = 0; i < arrayMultidimensional.length; i++) {
			Funcionario funcionario = new Funcionario();

			try {
				String dataASerFormatada = arrayMultidimensional[i][2];
				LocalDate data = null;

				if (!dataASerFormatada.trim().isEmpty()) {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
					data = LocalDate.parse(dataASerFormatada, formatter);
				}

				Date dataTipoDate = null;
				if (data != null) {
					Instant instant = data.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
					dataTipoDate = Date.from(instant);
				}

				BigDecimal salario = null;
				if (!arrayMultidimensional[i][7].trim().isEmpty()) {
					salario = new BigDecimal(arrayMultidimensional[i][7]);
				}

				BigDecimal resultado = salario;

				if (data != null && salario != null) {
					LocalDate dataAtual = LocalDate.now();
					Period periodo = Period.between(data, dataAtual);
					int idade = periodo.getYears();

					if (idade < 18) {
						BigDecimal taxa = new BigDecimal("0.2");
						resultado = resultado.multiply(taxa);

					} else if (idade <= 23) {
						BigDecimal taxa = new BigDecimal("0.15");
						resultado = resultado.multiply(taxa);

					} else if (idade <= 31) {
						BigDecimal taxa = new BigDecimal("0.1");
						resultado = resultado.multiply(taxa);

					} else if (idade <= 50) {
						BigDecimal taxa = new BigDecimal("0.05");
						resultado = resultado.multiply(taxa);

					} else {
						BigDecimal taxa = new BigDecimal("0.01");
						resultado = resultado.multiply(taxa);

					}

					funcionario.setIdade(idade);
					funcionario.setMaiorIdade(idade >= 18);
					funcionario.setTaxa(resultado);
				}
				BigDecimal salarioLiquido = salario.subtract(resultado);

				funcionario.setNome(arrayMultidimensional[i][0].trim());
				funcionario.setSobrenome(arrayMultidimensional[i][1].trim());
				funcionario.setDataNascimento(dataTipoDate);
				funcionario.setSexo(arrayMultidimensional[i][3].trim());
				funcionario.setProfissao(arrayMultidimensional[i][4].trim());
				funcionario.setCpfCnpj(arrayMultidimensional[i][5].trim());
				funcionario.setEscolaridade(arrayMultidimensional[i][6].trim());
				funcionario.setSalario(salario);
				funcionario.setSalarioLiquido(salarioLiquido);
			} catch (Exception e) {
				e.printStackTrace();
				funcionario.setSalario(null);
			}

			listaFuncionario.add(funcionario);
		}
		return listaFuncionario;
	}

	@Override
	public int[][] arrayMultidimensionalParesImparesPrimosResto(int[] array, int numeroDivisaoResto) {
		int[][] resultado = new int[array.length][4];
		int i = 0;
		for (int num : array) {
			resultado[i][0] = (num % 2 == 0) ? num : 0;
			resultado[i][1] = (num % 2 != 0) ? num : 0;
			resultado[i][2] = (primo(num)) ? num : 0;
			resultado[i][3] = num % numeroDivisaoResto;
			i++;
		}

		return resultado;
	}

	private static boolean isPrimo(int num) {
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

	private static int[] convertToIntArray(ArrayList<Integer> list) {
		int[] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	@Override
	public String[] arrayMultidimensionalPorPosicoes(String[][] arrayMultidimensional, int coluna, int linha) {

		String[] array = { "", "", "", "" };

		try {
			if (coluna == 0) {
				array[0] = "Não há antecessor";
			} else {
				array[0] = arrayMultidimensional[linha][coluna - 1];
			}

			if (coluna == arrayMultidimensional[linha].length - 1) {
				array[1] = "Não há sucessor";
			} else {
				array[1] = arrayMultidimensional[linha][coluna + 1];
			}

			if (linha == 0) {
				array[2] = "Não há valor acima";
			} else {
				array[2] = arrayMultidimensional[linha - 1][coluna];
			}

			if (linha == arrayMultidimensional.length - 1) {
				array[3] = "Não há valor a baixo";
			} else {
				array[3] = arrayMultidimensional[linha + 1][coluna];
			}
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return array;
	}

	@Override
	public String[] arrayMultidimensionalPorValor(String[][] arrayMultidimensional, String valor) {

		int coluna = -1;
		int linha = -1;
		String[] array = new String[4];

		for (int i = 0; i < arrayMultidimensional.length; i++) {
			for (int j = 0; j < arrayMultidimensional[i].length; j++) {
				if (arrayMultidimensional[i][j].equals(valor)) {
					linha = i;
					coluna = j;
					break;
				}
			}
		}

		try {
			array[0] = arrayMultidimensional[linha][coluna - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			array[0] = "Não existe antecessor.";
		}

		try {
			array[1] = arrayMultidimensional[linha][coluna + 1];
		} catch (ArrayIndexOutOfBoundsException e) {
			array[1] = "Não existe sucessor.";
		}

		try {
			array[2] = arrayMultidimensional[linha - 1][coluna];
		} catch (ArrayIndexOutOfBoundsException e) {
			array[2] = "Não existe valor acima.";
		}

		try {
			array[3] = arrayMultidimensional[linha + 1][coluna];
		} catch (ArrayIndexOutOfBoundsException e) {
			array[3] = "Não existe valor abaixo.";
		}

		return array;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, int posicao) {

		String antecessor = "";
		String sucessor = "";

		try {
			if (posicao >= 0 && posicao < array.length) {
				if (posicao == array.length - 1) {
					sucessor = "não há sucessor!";
				} else {
					sucessor = array[posicao + 1];
				}

				if (posicao == 0) {
					antecessor = "não há antecessor!";
				} else {
					antecessor = array[posicao - 1];
				}
			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

		String[] antecessorSucessorPor = { antecessor, sucessor };

		return antecessorSucessorPor;
	}

	@Override
	public String[] antecessorSucessorPor(String[] array, String valor) {

		int posicao = 0;
		String antecessor = "";
		String sucessor = "";

		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(valor)) {
				posicao = i;
				break;
			}
		}

		try {
			if (valor == array[0]) {
				antecessor = "Não há antecessor!";
			} else {
				antecessor = array[posicao - 1];
			}

			if (valor == array[array.length - 1]) {
				sucessor = "Não há sucessor!";
			} else {
				sucessor = array[posicao + 1];
			}

		} catch (ArrayIndexOutOfBoundsException e) {

		}

		String[] antecessorSucessor = { antecessor, sucessor };

		return antecessorSucessor;
	}

	@Override
	public List<Integer> numerosPares(Integer limite) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				lista.add(i);
			}
		}
		return lista;
	}

	@Override
	public List<Integer> numerosImpares(Integer limite) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			if (i % 2 != 0) {
				lista.add(i);
			}
		}
		return lista;
	}

	@Override
	public List<Integer> numerosPrimos(Integer limite) {

		List<Integer> lista = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			if (primo(i)) {
				lista.add(i);
			}
		}
		return lista;
	}

	@Override
	public int[] numerosParesArray(Integer limite) {

		List<Integer> parList = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				parList.add(i);
			}
		}

		int vetor[] = new int[parList.size()];

		for (int i = 0; i < parList.size(); i++) {
			vetor[i] = parList.get(i);
		}
		return vetor;
	}

	@Override
	public int[] numerosImparesArray(Integer limite) {

		List<Integer> imparList = new ArrayList<>();

		for (int i = 0; i <= limite; i++) {
			if (i % 2 != 0) {
				imparList.add(i);
			}
		}

		int vetor[] = new int[imparList.size()];

		for (int i = 0; i < imparList.size(); i++) {
			vetor[i] = imparList.get(i);
		}
		return vetor;
	}

	@Override
	public int[] numerosPrimosArray(Integer limite) {

		List<Integer> primosList = new ArrayList<>();

		for (int i = 2; i < limite; i++) {
			if (primo(i)) {
				primosList.add(i);
			}
		}

		int[] vetor = new int[primosList.size()];

		for (int i = 0; i < primosList.size(); i++) {
			vetor[i] = primosList.get(i);
		}

		return vetor;
	}

	@Override
	public int[] primeiraUltimaPosicaoArray(Integer limite) {

		int vetor[] = new int[2];

		vetor[0] = 0;
		vetor[1] = limite - 1;

		return vetor;
	}

	@Override
	public int[] quantidadeParesImparesPrimos(List<Integer> valores) {

		int pares = 0;
		int impares = 0;
		int primos = 0;

		int[] vetor = new int[3];

		for (int i = 0; i < valores.size(); i++) {

			if (valores.get(i) % 2 == 0) {
				pares++;
			}
			if (valores.get(i) % 2 != 0) {
				impares++;
			}
			if (primo(valores.get(i))) {
				primos++;
			}
		}

		vetor[0] = pares;
		vetor[1] = impares;
		vetor[2] = primos;

		return vetor;
	}

	@Override
	public int[] primeiraUltimaMediaPosicaoArray(Integer limite) {

		int vetor[] = new int[3];

		int soma = 0;

		if (limite > 0) {

			for (int i = 0; i < limite; i++) {
				soma += i;
			}

			vetor[0] = 0;
			vetor[1] = limite;
			vetor[2] = soma / limite;
		}
		return vetor;
	}

	@Override
	public List<Integer> removerInteirosDuplicados(List<Integer> numeros) {

		List<Integer> lista = new ArrayList<>();

		for (Integer valor : numeros) {

			if (!lista.contains(valor)) {
				lista.add(valor);
			}
		}
		return lista;
	}

	@Override
	public List<BigDecimal> removerValoresDuplicados(final List<BigDecimal> numeros) {

		List<BigDecimal> listaSemRepeticao = new ArrayList<>();

		for (BigDecimal valor : numeros) {

			if (!listaSemRepeticao.contains(valor)) {
				listaSemRepeticao.add(valor);
			}
		}
		return listaSemRepeticao;
	}

	@Override
	public List<String> removerTextosDuplicados(List<String> textos) {

		List<String> listaSemRepeticao = new ArrayList<>();

		for (String palavra : textos) {
			if (!listaSemRepeticao.contains(palavra)) {
				listaSemRepeticao.add(palavra);
			}
		}
		return listaSemRepeticao;
	}

	@Override
	public Integer valorInteiroMaiorQtdDuplicados(List<Integer> numeros) {

//		Integer maisRepete = 0;
//		 Integer palavraQueRepete = -1;
//	     Integer numeroMaisOcorrencias =0;
//	     
//		ArrayList<Integer> lista = new ArrayList<>();
//		ArrayList<Integer> contagem = new ArrayList<>();
//
//		for (int i = 0; i < numeros.size(); i++) {
//			Integer guardar = numeros.get(i);
//
//			if (lista.contains(guardar)) {
//				Integer indexDoTexto = lista.indexOf(guardar);
//				contagem.set(indexDoTexto, contagem.get(indexDoTexto) + 1);
//			} else {
//				lista.add(guardar);
//				contagem.add(1);
//			}
//
//		}
//		for (int i = 0; i < contagem.size(); i++) {
//		    if (contagem.get(i) > maisRepete) {
//		    	maisRepete = contagem.get(i);
//		        palavraQueRepete = i;
//		    }
//		}
//		
//		if (palavraQueRepete != -1) {
//			numeroMaisOcorrencias = lista.get(palavraQueRepete);
//		} else {
//		    System.out.println("Lista vazia.");
//		}
//		return numeroMaisOcorrencias;

		Map<Integer, Integer> contagem = new HashMap<>();

		for (Integer elemento : numeros) {
			contagem.put(elemento, contagem.getOrDefault(elemento, 0) + 1);
		}

		Integer valorMaisRepetido = null;

		int maiorContagem = 0;

		for (Map.Entry<Integer, Integer> entrada : contagem.entrySet()) {
			if (entrada.getValue() > maiorContagem) {
				maiorContagem = entrada.getValue();
				valorMaisRepetido = entrada.getKey();
			}
		}

		return valorMaisRepetido;
	}

	@Override
	public String valorTextoMaiorQtdDuplicados(List<String> textos) {
		// MAP
		// MANTER ESSE
//		int maisRepete = 0;
//	    int palavraQueRepete = -1;
//	     String palavraMaisOcorrencias ="";
//	     
//		ArrayList<String> lista = new ArrayList<>();
//		ArrayList<Integer> contagem = new ArrayList<>();
//
//		for (int i = 0; i < textos.size(); i++) {
//			String guardar = textos.get(i);
//
//			if (lista.contains(guardar)) {
//				Integer indexDoTexto = lista.indexOf(guardar);
//				contagem.set(indexDoTexto, contagem.get(indexDoTexto) + 1);
//			} else {
//				lista.add(guardar);
//				contagem.add(1);
//			}
//
//		}
//		
//		for (int i = 0; i < contagem.size(); i++) {
//		    if (contagem.get(i) > maisRepete) {
//		    	maisRepete = contagem.get(i);
//		        palavraQueRepete = i;
//		    }
//		}
//		
//		if (palavraQueRepete != -1) {
//		    palavraMaisOcorrencias = lista.get(palavraQueRepete);
//		} else {
//		    System.out.println("Lista vazia.");
//		}

//		return palavraMaisOcorrencias;

		String valorMaisRepetido = null;
		int maiorContagem = 0;

		Map<String, Integer> contagem = new HashMap<>();

		for (String palavra : textos) {
			contagem.put(palavra, contagem.getOrDefault(palavra, 0) + 1);
		}

		for (Map.Entry<String, Integer> entrada : contagem.entrySet()) {
			if (entrada.getValue() > maiorContagem) {
				maiorContagem = entrada.getValue();
				valorMaisRepetido = entrada.getKey();
			}
		}
		return valorMaisRepetido;
	}

	@Override
	public List<Integer> listaInteirosDuplicados(List<Integer> numeros) {

		List<Integer> lista = new ArrayList<>();

		Map<Integer, Integer> contagem = new HashMap<>();

		for (Integer numero : numeros) {
			contagem.put(numero, contagem.getOrDefault(numero, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
			if (entry.getValue() > 1) {
				lista.add(entry.getKey());
			}
		}
		return lista;
	}

	@Override
	public List<BigDecimal> listaDecimalDuplicados(List<BigDecimal> numeros) {

		List<BigDecimal> lista = new ArrayList<>();

		Map<BigDecimal, Integer> contagem = new HashMap<>();

		for (BigDecimal numero : numeros) {
			contagem.put(numero, contagem.getOrDefault(numero, 0) + 1);
		}

		for (Map.Entry<BigDecimal, Integer> entry : contagem.entrySet()) {
			if (entry.getValue() > 1) {
				lista.add(entry.getKey());
			}
		}
		return lista;
	}

	@Override
	public List<String> listaTextoDuplicados(List<String> textos) {

		List<String> lista = new ArrayList<>();

		Map<String, Integer> contagem = new HashMap<>();

		for (String texto : textos) {
			contagem.put(texto, contagem.getOrDefault(texto, 0) + 1);
		}

		for (Map.Entry<String, Integer> entry : contagem.entrySet()) {
			if (entry.getValue() > 1) {
				lista.add(entry.getKey());
			}
		}
		return lista;
	}

	@Override
	public Integer somarValores(Integer limite) {

		Integer soma = 0;

		for (int i = 0; i <= limite; i++) {
			soma += i;
		}
		return soma;
	}

	@Override
	public Integer somarValoresPares(Integer limite) {

		Integer soma = 0;

		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				soma += i;
			}
		}

		return soma;
	}

	@Override
	public Integer somarValoresImpares(Integer limite) {

		Integer soma = 0;

		for (int i = 0; i <= limite; i++) {
			if (i % 2 != 0) {
				soma += i;
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPrimos(Integer limite) {

		Integer soma = 0;

		for (int i = 0; i <= limite; i++) {
			if (primo(i)) {
				soma += i;
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoes(int[] valores) {

		Integer soma = 0;

		for (int i = 0; i < valores.length; i++) {
			soma += valores[i];
		}
		return soma;
	}

	@Override
	public Integer somarValoresParesPosicoes(int[] valores) {

		Integer soma = 0;

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 2 == 0) {
				soma += valores[i];
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresImparesPosicoes(int[] valores) {

		Integer soma = 0;

		for (int i = 0; i < valores.length; i++) {
			if (valores[i] % 2 != 0) {
				soma += valores[i];
			}
		}

		return soma;
	}

	@Override
	public Integer somarValoresPrimosPosicoes(int[] valores) {

		Integer soma = 0;

		for (Integer i = 0; i < valores.length; i++) {

			if (primo(valores[i])) {
				soma += valores[i];
			}
		}
		return soma;
	}

	@Override
	public Integer somarValoresPosicoesParesMultiplosDe(Integer limite, Integer multiplo) {

		Integer valor = 0;

		for (int i = 0; i <= limite; i++) {
			if (i % 2 == 0) {
				valor += i * multiplo;
			}
		}
		return valor;
	}

	@Override
	public boolean multiploDeSete(int valor) {
		return valor % 7 == 0 && valor != 0 ? true : false;
	}

	@Override
	public String parOuImpar(int valor) {
		return valor % 2 == 0 ? "PAR" : "IMPAR";
	}

	@Override
	public String parOuImparOuZero(int valor) {
		return valor % 2 == 0 && valor != 0 ? "PAR" : (valor % 2 != 0) ? "IMPAR" : "ZERO";
	}

	@Override
	public int[] obterDobrosAteDobroInformado(int valor) {
		int quadruplo = valor * 2;

		List<Integer> dobrados = new ArrayList<>();

		if (valor < 0) {
			while (valor >= quadruplo) {
				dobrados.add(valor * 2);
				valor--;
			}
		} else {
			while (valor <= quadruplo) {
				dobrados.add(valor * 2);
				valor++;
			}
		}

		int[] vetor = new int[dobrados.size()];

		for (int i = 0; i < dobrados.size(); i++) {
			vetor[i] = dobrados.get(i);
		}
		return vetor;
	}

	@Override
	public int[] obterDobrosAteDez(int valor) {

		List<Integer> dobrados = new ArrayList<>();

		while (valor <= 10) {
			dobrados.add(valor * 2);
			valor++;
		}

		int[] vetor = new int[dobrados.size()];

		for (int i = 0; i < dobrados.size(); i++) {
			vetor[i] = dobrados.get(i);
		}

		return vetor;
	}

	@Override
	public int[] obterDobrosAteMil(int valor) {
		int[] vetor = new int[0];

		if (valor != 0) {
			if (valor < 0) {
				valor = Math.abs(valor) * 2;
			}

			List<Integer> dobrados = new ArrayList<>();

			valor *= 2;

			while (valor <= 1000) {
				dobrados.add(valor);
				valor *= 2;
			}

			if (valor > 1000) {
				dobrados.add(valor);
			}

			vetor = new int[dobrados.size()];

			for (int i = 0; i < dobrados.size(); i++) {
				vetor[i] = dobrados.get(i);
			}
		}

		return vetor;
	}

	@Override
	public int[][] tabuada(int valor) {

		int[][] tabuada = new int[valor * 10][3];
		int index = 0;

		for (int i = 1; i <= valor; i++) {
			for (int j = 1; j <= 10; j++) {
				tabuada[index][0] = i;
				tabuada[index][1] = j;
				tabuada[index][2] = i * j;
				index++;
			}
		}
		return tabuada;
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