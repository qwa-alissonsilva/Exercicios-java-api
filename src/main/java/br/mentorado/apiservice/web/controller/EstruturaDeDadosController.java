package br.mentorado.apiservice.web.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mentorado.apiservice.domain.persistence.entity.ContatoFuncionario;
import br.mentorado.apiservice.domain.persistence.entity.Funcionario;
import br.mentorado.apiservice.domain.service.EstruturaDadosListService;
import br.mentorado.apiservice.domain.service.EstruturaDadosMapService;
import br.mentorado.apiservice.domain.service.EstruturaDadosSetService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/v1/estruturaDados")
public class EstruturaDeDadosController {

	@Autowired
	private EstruturaDadosSetService estruturaDadosSetService;

	@Autowired
	private EstruturaDadosMapService estruturaDadosMapService;

	@Autowired
	private EstruturaDadosListService estruturaDadosListService;

	@GetMapping("/set/nomesUnicosOrdenados")
	public Set<String> nomesUnicosOrdenados(@RequestParam List<String> nomes) {
		return this.estruturaDadosSetService.nomesUnicosOrdenados(nomes);
	}

	@GetMapping("/set/valoresPositivosNegativos")
	public Set<String> valoresPositivosNegativos(@RequestParam int[] valores) {
		return this.estruturaDadosSetService.valoresPositivosNegativos(valores);
	}

	@GetMapping("/set/valoresDuplicadosOrdenados")
	public Set<Integer> valoresDuplicadosOrdenados(@RequestParam List<Integer> valores1,
			@RequestParam List<Integer> valores2) {
		return this.estruturaDadosSetService.valoresDuplicadosOrdenados(valores1, valores2);
	}

	@GetMapping("/set/valoresDiferentesOrdenados")
	public Set<Integer> valoresDiferentesOrdenados(@RequestParam List<Integer> valores1,
			@RequestParam List<Integer> valores2) {
		return this.estruturaDadosSetService.valoresDiferentesOrdenados(valores1, valores2);
	}

	@GetMapping("/set/valoresDuplicadosDaPrimeiraListaOrdenados")
	public Set<Integer> valoresDuplicadosDaPrimeiraListaOrdenados(@RequestParam List<Integer> valores1,
			@RequestParam List<Integer> valores2) {
		return this.estruturaDadosSetService.valoresDuplicadosDaPrimeiraListaOrdenados(valores1, valores2);
	}

	@GetMapping("/set/valoresDiferentesDaSegundaListaOrdenados")
	public Set<Integer> valoresDiferentesDaSegundaListaOrdenados(@RequestParam List<Integer> valores1,
			List<Integer> valores2) {
		return this.estruturaDadosSetService.valoresDiferentesDaSegundaListaOrdenados(valores1, valores2);
	}

	@GetMapping("/set/valoresDiferentesDaSegundaListaOrdenados")
	public Set<Funcionario> pessoasUnicasOrdenados(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosSetService.pessoasUnicasOrdenados(pessoas);
	}

	@GetMapping("/set/pessoasDuplicadosOrdenados")
	public Set<Funcionario> pessoasDuplicadosOrdenados(@RequestParam List<Funcionario> pessoas1,
			@RequestParam List<Funcionario> pessoas2) {
		return this.estruturaDadosSetService.pessoasDuplicadosOrdenados(pessoas1, pessoas2);
	}

	@GetMapping("/set/pessoasDiferentesOrdenados")
	public Set<Funcionario> pessoasDiferentesOrdenados(@RequestParam List<Funcionario> pessoas1,
			@RequestParam List<Funcionario> pessoas2) {
		return this.estruturaDadosSetService.pessoasDiferentesOrdenados(pessoas1, pessoas2);
	}

	@GetMapping("/set/pessoasDuplicadosDaPrimeiraListaOrdenados")
	public Set<Funcionario> pessoasDuplicadosDaPrimeiraListaOrdenados(@RequestParam List<Funcionario> pessoas1,
			@RequestParam List<Funcionario> pessoas2) {
		return this.estruturaDadosSetService.pessoasDuplicadosDaPrimeiraListaOrdenados(pessoas1, pessoas2);
	}

	@GetMapping("/set/pessoasDiferentesDaSegundaListaOrdenados")
	public Set<Funcionario> pessoasDiferentesDaSegundaListaOrdenados(@RequestParam List<Funcionario> pessoas1,
			@RequestParam List<Funcionario> pessoas2) {
		return this.estruturaDadosSetService.pessoasDiferentesDaSegundaListaOrdenados(pessoas1, pessoas2);
	}

	@GetMapping("/map/nomeFrequencia")
	public Map<String, Integer> nomeFrequencia(@RequestParam List<String> nomes) {
		return this.estruturaDadosMapService.nomeFrequencia(nomes);
	}

	@GetMapping("/map/mapaFrequenciaValores")
	public Map<String, Integer> mapaFrequenciaValores(@RequestParam Map<String, String> mapa) {
		return this.estruturaDadosMapService.mapaFrequenciaValores(mapa);
	}

	@GetMapping("/map/mapaFrequenciaValoresLista")
	public Map<String, Integer> mapaFrequenciaValoresLista(@RequestParam final Map<String, List<String>> mapa) {
		return this.estruturaDadosMapService.mapaFrequenciaValoresLista(mapa);
	}

	@GetMapping("/map/nomeTelefones")
	public Map<String, List<String>> nomeTelefones(@RequestParam List<String> elemento) {
		return this.estruturaDadosMapService.nomeTelefones(elemento);
	}

	@GetMapping("/map/cpfCnpjTelefonesObjeto")
	public Map<Funcionario, List<ContatoFuncionario>> cpfCnpjTelefonesObjeto(@RequestParam List<String> elemento) {
		return this.estruturaDadosMapService.cpfCnpjTelefonesObjeto(elemento);
	}

	@GetMapping("/map/chavesMapa")
	public List<String> chavesMapa(@RequestParam Map<String, String> mapa) {
		return this.estruturaDadosMapService.chavesMapa(mapa);
	}

	@GetMapping("/map/valoresMapa")
	public List<String> valoresMapa(@RequestParam Map<String, String> mapa) {
		return this.estruturaDadosMapService.valoresMapa(mapa);
	}

	@GetMapping("/map/nomeTelefones")
	public Map<String, List<Integer>> nomeTelefones(@RequestParam int limite) {
		return this.estruturaDadosMapService.nomeTelefones(limite);
	}

	@GetMapping("/map/maiorNumeroEntreValores")
	public Integer maiorNumeroEntreValores(@RequestParam Map<String, List<Integer>> map) {
		return this.estruturaDadosMapService.maiorNumeroEntreValores(map);
	}

	@GetMapping("/map/chaveMaiorNumeroEntreValores")
	public String chaveMaiorNumeroEntreValores(@RequestParam Map<String, List<Integer>> map) {
		return this.estruturaDadosMapService.chaveMaiorNumeroEntreValores(map);
	}

	@GetMapping("/list/nomes")
	public List<String> nomes(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.nomes(pessoas);
	}

	@GetMapping("/list/sobrenomes")
	public List<String> sobrenomes(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.sobrenomes(pessoas);
	}

	@GetMapping("/list/maiores18")
	public List<Integer> maiores18(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.maiores18(pessoas);
	}

	@GetMapping("/list/menores18")
	public List<Integer> menores18(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.menores18(pessoas);
	}

	@GetMapping("/list/pessoaMaisVelha")
	public Integer pessoaMaisVelha(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.pessoaMaisVelha(pessoas);
	}

	@GetMapping("/list/pessoaMaisNova")
	public Integer pessoaMaisNova(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.pessoaMaisNova(pessoas);
	}

	@GetMapping("/list/maiorSalario")
	public BigDecimal maiorSalario(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.maiorSalario(pessoas);
	}

	@GetMapping("/list/menorTaxa")
	public BigDecimal menorTaxa(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.menorTaxa(pessoas);
	}

	@GetMapping("/list/nomePrimeiraPessoa")
	public String nomePrimeiraPessoa(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.nomePrimeiraPessoa(pessoas);
	}

	@GetMapping("/list/nomeUltimaPessoa")
	public String nomeUltimaPessoa(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.nomeUltimaPessoa(pessoas);
	}

	@GetMapping("/list/maiorNome")
	public String maiorNome(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.maiorNome(pessoas);
	}

	@GetMapping("/list/maiorNomeCompleto")
	public String maiorNomeCompleto(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.maiorNomeCompleto(pessoas);
	}

	@GetMapping("/list/quantidadePessoasSexoMasculino")
	public Integer quantidadePessoasSexoMasculino(@RequestParam List<Funcionario> pessoas) {
		return this.estruturaDadosListService.quantidadePessoasSexoMasculino(pessoas);
	}

	@GetMapping("/list/maioresSalariosPeloValor")
	public List<BigDecimal> maioresSalariosPeloValor(@RequestParam List<Funcionario> pessoas,
			@RequestParam BigDecimal valor) {
		return this.estruturaDadosListService.maioresSalariosPeloValor(pessoas, valor);
	}
}
