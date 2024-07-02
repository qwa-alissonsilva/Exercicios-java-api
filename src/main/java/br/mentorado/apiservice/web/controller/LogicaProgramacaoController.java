package br.mentorado.apiservice.web.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mentorado.apiservice.domain.persistence.entity.Funcionario;
import br.mentorado.apiservice.domain.service.LogicaProgramacaoService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/v1/logicaProgramacao")
public class LogicaProgramacaoController {

	@Autowired
	private LogicaProgramacaoService logicaProgramacaoService;

	@GetMapping("/tabuada")
	public int[][] tabuada(@RequestParam int valor) {
		return this.logicaProgramacaoService.tabuada(valor);
	}

	@GetMapping("/obterDobrosAteMil")
	public int[] obterDobrosAteMil(@RequestParam int valor) {
		return this.logicaProgramacaoService.obterDobrosAteMil(valor);
	}

	@GetMapping("/obterDobrosAteDez")
	public int[] obterDobrosAteDez(@RequestParam int valor) {
		return this.logicaProgramacaoService.obterDobrosAteDez(valor);
	}

	@GetMapping("/obterDobrosAteDobroInformado")
	public int[] obterDobrosAteDobroInformado(@RequestParam int valor) {
		return this.logicaProgramacaoService.obterDobrosAteDobroInformado(valor);
	}

	@GetMapping("/parOuImparOuZero")
	public String parOuImparOuZero(@RequestParam int valor) {
		return this.logicaProgramacaoService.parOuImparOuZero(valor);
	}

	@GetMapping("/parOuImpar")
	public String parOuImpar(@RequestParam int valor) {
		return this.logicaProgramacaoService.parOuImpar(valor);
	}

	@GetMapping("/multiploDeSete")
	public boolean multiploDeSete(@RequestParam int valor) {
		return this.logicaProgramacaoService.multiploDeSete(valor);
	}

	@GetMapping("/somarValoresPosicoesParesMultiplosDe")
	public Integer somarValoresPosicoesParesMultiplosDe(@RequestParam final Integer limite,
			@RequestParam final Integer multiplo) {
		return this.logicaProgramacaoService.somarValoresPosicoesParesMultiplosDe(limite, multiplo);
	}

	@GetMapping("/somarValoresPrimosPosicoes")
	public Integer somarValoresPrimosPosicoes(@RequestParam final int[] valores) {
		return this.logicaProgramacaoService.somarValoresPrimosPosicoes(valores);
	}

	@GetMapping("/somarValoresImparesPosicoes")
	public Integer somarValoresImparesPosicoes(@RequestParam final int[] valores) {
		return this.logicaProgramacaoService.somarValoresImparesPosicoes(valores);
	}

	@GetMapping("/somarValoresParesPosicoes")
	public Integer somarValoresParesPosicoes(@RequestParam final int[] valores) {
		return this.logicaProgramacaoService.somarValoresParesPosicoes(valores);
	}

	@GetMapping("/somarValoresPosicoes")
	public Integer somarValoresPosicoes(@RequestParam final int[] valores) {
		return this.logicaProgramacaoService.somarValoresPosicoes(valores);
	}

	@GetMapping("/somarValoresPrimos")
	public Integer somarValoresPrimos(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.somarValoresPrimos(limite);
	}

	@GetMapping("/somarValoresImpares")
	public Integer somarValoresImpares(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.somarValoresImpares(limite);
	}

	@GetMapping("/somarValoresPares")
	public Integer somarValoresPares(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.somarValoresPares(limite);
	}

	@GetMapping("/somarValores")
	public Integer somarValores(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.somarValores(limite);
	}

	@GetMapping("/listaTextoDuplicados")
	public List<String> listaTextoDuplicados(@RequestParam final List<String> textos) {
		return this.logicaProgramacaoService.listaTextoDuplicados(textos);
	}

	@GetMapping("/listaDecimalDuplicados")
	public List<BigDecimal> listaDecimalDuplicados(@RequestParam final List<BigDecimal> textos) {
		return this.logicaProgramacaoService.listaDecimalDuplicados(textos);
	}

	@GetMapping("/listaInteirosDuplicados")
	public List<Integer> listaInteirosDuplicados(@RequestParam final List<Integer> numeros) {
		return this.logicaProgramacaoService.listaInteirosDuplicados(numeros);
	}

	@GetMapping("/valorTextoMaiorQtdDuplicados")
	public String valorTextoMaiorQtdDuplicados(@RequestParam final List<String> textos) {
		return this.logicaProgramacaoService.valorTextoMaiorQtdDuplicados(textos);
	}

	@GetMapping("/valorInteiroMaiorQtdDuplicados")
	public Integer valorInteiroMaiorQtdDuplicados(@RequestParam final List<Integer> numeros) {
		return this.logicaProgramacaoService.valorInteiroMaiorQtdDuplicados(numeros);
	}

	@GetMapping("/removerTextosDuplicados")
	public List<String> removerTextosDuplicados(@RequestParam final List<String> textos) {
		return this.logicaProgramacaoService.removerTextosDuplicados(textos);
	}

	@GetMapping("/removerValoresDuplicados")
	public List<BigDecimal> removerValoresDuplicados(@RequestParam final List<BigDecimal> numeros) {
		return this.logicaProgramacaoService.removerValoresDuplicados(numeros);
	}

	@GetMapping("/removerInteirosDuplicados")
	public List<Integer> removerInteirosDuplicados(@RequestParam final List<Integer> numeros) {
		return this.logicaProgramacaoService.removerInteirosDuplicados(numeros);
	}

	@GetMapping("/primeiraUltimaMediaPosicaoArray")
	public int[] primeiraUltimaMediaPosicaoArray(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.primeiraUltimaMediaPosicaoArray(limite);
	}

	@GetMapping("/quantidadeParesImparesPrimos")
	public int[] quantidadeParesImparesPrimos(@RequestParam final List<Integer> valores) {
		return this.logicaProgramacaoService.quantidadeParesImparesPrimos(valores);
	}

	@GetMapping("/primeiraUltimaPosicaoArray")
	public int[] primeiraUltimaPosicaoArray(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.primeiraUltimaPosicaoArray(limite);
	}

	@GetMapping("/numerosPrimosArray")
	public int[] numerosPrimosArray(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosPrimosArray(limite);
	}

	@GetMapping("/numerosImparesArray")
	public int[] numerosImparesArray(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosPrimosArray(limite);
	}

	@GetMapping("/numerosParesArray")
	public int[] numerosParesArray(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosParesArray(limite);
	}

	@GetMapping("/numerosPrimos")
	public List<Integer> numerosPrimos(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosPrimos(limite);
	}

	@GetMapping("/numerosImpares")
	public List<Integer> numerosImpares(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosImpares(limite);
	}

	@GetMapping("/numerosPares")
	public List<Integer> numerosPares(@RequestParam final Integer limite) {
		return this.logicaProgramacaoService.numerosPares(limite);
	}

	@GetMapping("/antecessorSucessorPor")
	public String[] antecessorSucessorPor(@RequestParam final String[] array, @RequestParam final String valor) {
		return this.logicaProgramacaoService.antecessorSucessorPor(array, valor);
	}

	@GetMapping("/antecessorSucessorPor")
	public String[] antecessorSucessorPor(@RequestParam final String[] array, @RequestParam final int posicao) {
		return this.logicaProgramacaoService.antecessorSucessorPor(array, posicao);
	}

	@GetMapping("/arrayMultidimensionalPorValor")
	public String[] arrayMultidimensionalPorValor(@RequestParam final String[][] arrayMultidimensional,
			@RequestParam final String valor) {
		return this.logicaProgramacaoService.arrayMultidimensionalPorValor(arrayMultidimensional, valor);
	}

	@GetMapping("/arrayMultidimensionalPorPosicoes")
	public String[] arrayMultidimensionalPorPosicoes(@RequestParam final String[][] arrayMultidimensional,
			@RequestParam final int coluna, @RequestParam final int linha) {
		return this.logicaProgramacaoService.arrayMultidimensionalPorPosicoes(arrayMultidimensional, coluna, linha);
	}

	@GetMapping("/arrayMultidimensionalParesImparesPrimosResto")
	public int[][] arrayMultidimensionalParesImparesPrimosResto(@RequestParam final int[] array,
			@RequestParam int numeroDivisaoResto) {
		return this.logicaProgramacaoService.arrayMultidimensionalParesImparesPrimosResto(array, numeroDivisaoResto);
	}

	@GetMapping("/conversaoArrayMultidimensionalParaPessoa")
	public List<Funcionario> conversaoArrayMultidimensionalParaPessoa(
			@RequestParam final String[][] arrayMultidimensional) {
		return this.logicaProgramacaoService.conversaoArrayMultidimensionalParaPessoa(arrayMultidimensional);
	}

	@GetMapping("/conversaoArrayParaPessoa")
	public Funcionario conversaoArrayParaPessoa(@RequestParam final String[] array) {
		return this.logicaProgramacaoService.conversaoArrayParaPessoa(array);
	}

	@GetMapping("/conversaoPessoaParaString")
	public List<String> conversaoPessoaParaString(@RequestParam final List<Funcionario> pessoas) {
		return this.logicaProgramacaoService.conversaoPessoaParaString(pessoas);
	}

	@GetMapping("/conversaoStringParaPessoa")
	public List<Funcionario> conversaoStringParaPessoa(@RequestParam final List<String> lista) {
		return this.logicaProgramacaoService.conversaoStringParaPessoa(lista);
	}

}
