package br.mentorado.apiservice.web.controller;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.mentorado.apiservice.domain.service.ArvoreBinariaBuscaService;
import br.mentorado.apiservice.domain.service.ArvoreBinariaService;
import br.mentorado.apiservice.domain.service.FilaService;
import br.mentorado.apiservice.domain.service.ListaEncadeadaProviderService;
import br.mentorado.apiservice.domain.service.OrdenacaoService;
import br.mentorado.apiservice.domain.service.PilhaService;
import br.mentorado.apiservice.domain.service.RecursaoService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/v1/algoritmos")
public class AlgoritmosController {

	@Autowired
	private RecursaoService recursaoService;

	@Autowired
	private PilhaService<T> pilhaService;

	@Autowired
	private OrdenacaoService ordenacaoService;

	@Autowired
	private ListaEncadeadaProviderService<T> listaEncadeadaProviderService;

	@Autowired
	private FilaService<T> filaService;

	@Autowired
	private ArvoreBinariaBuscaService arvoreBinariaBuscaService;

	@Autowired
	private ArvoreBinariaService arvoreBinariaService;

	@GetMapping("/recursao")
	public int recursao(@RequestParam int valor, @RequestParam int limite) {
		return this.recursaoService.recursao(valor, limite);
	}

	@GetMapping("/recursao/recursaoSoma")
	public int recursaoSoma(@RequestParam int valor, @RequestParam int limite) {
		return this.recursaoService.recursaoSoma(valor, limite);
	}

	@GetMapping("/recursao/recursaoFibonacci")
	public int recursaoFibonacci(@RequestParam int valor, @RequestParam int limite) {
		return this.recursaoService.recursaoFibonacci(valor, limite);
	}

	@GetMapping("/recursao/recursaoFibonacciIterativa")
	public int recursaoFibonacciIterativa(@RequestParam int valor) {
		return this.recursaoService.recursaoFibonacciIterativa(valor);
	}

	@PostMapping("/pilha/empilhar")
	public void empilhar(@RequestParam T elemento) {
		this.pilhaService.empilhar(elemento);
	}

	@PostMapping("/pilha/desempilhar")
	public void desempilhar() {
		this.pilhaService.desempilhar();
	}

	@GetMapping("/pilha/desempilhar")
	public List<T> obterTodos() {
		return this.pilhaService.obterTodos();
	}

	@GetMapping("/ordenacao/ordenar")
	public int[] ordenar(@RequestParam int[] elementos) {
		return this.ordenacaoService.ordenar(elementos);
	}

	@GetMapping("/ordenacao/quicksort")
	public int[] quicksort(@RequestParam int[] elementos) {
		return this.ordenacaoService.quicksort(elementos);
	}

	@GetMapping("/ordenacao/mergesort")
	public int[] mergesort(@RequestParam int[] elementos) {
		return this.ordenacaoService.mergesort(elementos);
	}

	@GetMapping("/ordenacao/bubbleSort")
	public int[] bubbleSort(@RequestParam int[] elementos) {
		return this.ordenacaoService.bubbleSort(elementos);
	}

	@GetMapping("/ordenacao/particaoPositivosNegativos")
	public int[] particaoPositivosNegativos(@RequestParam int[] elementos) {
		return this.ordenacaoService.particaoPositivosNegativos(elementos);
	}

	@DeleteMapping("/listaEncadeada/remover")
	public void removerListaEncadeada() {
		this.listaEncadeadaProviderService.remover();
	}

	@PostMapping("/listaEncadeada/adicionar")
	public void adicionarListaEncadeada(@RequestParam T elemento) {
		this.listaEncadeadaProviderService.adicionar(elemento);
	}

	@GetMapping("/listaEncadeada/todos")
	public List<T> todosListaEncadeada() {
		return this.listaEncadeadaProviderService.todos();
	}

	@GetMapping("/listaEncadeada/obter")
	public T obterListaEncadeada(@RequestParam int indice) {
		return this.listaEncadeadaProviderService.obter(indice);
	}

	@DeleteMapping("/fila/remover")
	public void removerFila() {
		this.filaService.remover();
	}

	@PostMapping("/fila/adicionar")
	public void adicionarFila(@RequestParam T elemento) {
		this.filaService.adicionar(elemento);
	}

	@GetMapping("/fila/todos")
	public List<T> todosDaFila() {
		return this.filaService.todos();
	}

	@GetMapping("/fila/obter")
	public T obterDaFila(@RequestParam int indice) {
		return this.filaService.obter(indice);
	}

	@PostMapping("/arvoreBusca/inserir")
	public void inserirArvoreBusca(@RequestParam int elemento) {
		this.arvoreBinariaBuscaService.inserir(elemento);
	}

	@GetMapping("/arvoreBusca/todosOrdenado")
	public int[] todosOrdenadoArvoreBusca() {
		return this.arvoreBinariaBuscaService.todosOrdenado();
	}

	@GetMapping("/arvoreBusca/preOrdem")
	public int[] preOrdemArvoreBusca() {
		return this.arvoreBinariaBuscaService.preOrdem();
	}

	@GetMapping("/arvoreBusca/posOrdem")
	public int[] posOrdemArvoreBusca() {
		return this.arvoreBinariaBuscaService.posOrdem();
	}

	@GetMapping("/arvoreBusca/primeiro")
	public int primeiroArvoreBusca() {
		return this.arvoreBinariaBuscaService.primeiro();
	}

	@GetMapping("/arvoreBusca/ultimo")
	public int ultimoArvoreBusca() {
		return this.arvoreBinariaBuscaService.ultimo();
	}

	@PostMapping("/arvore/adicionar")
	public void adicionarArvore(@RequestParam int elemento) {
		this.arvoreBinariaService.adicionar(elemento);
	}

	@GetMapping("/arvore/todosOrdenado")
	public int[] todosOrdenadoArvore() {
		return this.arvoreBinariaService.todosOrdenado();
	}

	@GetMapping("/arvore/primeiro")
	public int primeiroDaArvore() {
		return this.arvoreBinariaService.primeiro();
	}

	@GetMapping("/arvore/ultimo")
	public int ultimoDaArvore() {
		return this.arvoreBinariaService.ultimo();
	}

	@PostMapping("/arvore/inserir")
	public void inserirArvore(@RequestParam int elemento) {
		this.arvoreBinariaService.inserir(elemento);
	}

	@GetMapping("/arvore/preOrdem")
	public int[] preOrdemArvore() {
		return this.arvoreBinariaService.preOrdem();
	}

	@GetMapping("/arvore/posOrdem")
	public int[] posOrdemArvore() {
		return this.arvoreBinariaService.posOrdem();
	}
}
