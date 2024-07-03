package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.ArvoreBinaria;
@Service
public class ArvoreBinariaService implements ArvoreBinaria {

	private Nodo raiz;

	private class Nodo {
		int elemento;
		Nodo esquerdo;
		Nodo direito;

		Nodo(int elemento) {
			this.elemento = elemento;
			this.esquerdo = null;
			this.direito = null;
		}
	}

	@Override
	public void adicionar(int elemento) {
		raiz = adicionarRecursivo(raiz, elemento);
	}

	private Nodo adicionarRecursivo(Nodo raizAtual, int elemento) {
		if (raizAtual == null) {
			return new Nodo(elemento);
		}

		if (elemento < raizAtual.elemento) {
			raizAtual.esquerdo = adicionarRecursivo(raizAtual.esquerdo, elemento);
		} else if (elemento > raizAtual.elemento) {
			raizAtual.direito = adicionarRecursivo(raizAtual.direito, elemento);
		}

		return raizAtual;
	}

	@Override
	public int[] todosOrdenado() {
		List<Integer> elementos = new ArrayList<>();
		todosOrdenadoRecursivo(raiz, elementos);
		return elementos.stream().mapToInt(i -> i).toArray();
	}

	private void todosOrdenadoRecursivo(Nodo raizAtual, List<Integer> elementos) {
		if (raizAtual != null) {
			todosOrdenadoRecursivo(raizAtual.esquerdo, elementos);
			elementos.add(raizAtual.elemento);
			todosOrdenadoRecursivo(raizAtual.direito, elementos);
		}
	}

	@Override
	public int primeiro() {
		if (raiz == null) {
			throw new IllegalStateException("Árvore vazia");
		}

		Nodo nodoAtual = raiz;
		while (nodoAtual.esquerdo != null) {
			nodoAtual = nodoAtual.esquerdo;
		}
		return nodoAtual.elemento;
	}

	@Override
	public int ultimo() {
		if (raiz == null) {
			throw new IllegalStateException("Árvore vazia");
		}

		Nodo nodoAtual = raiz;
		while (nodoAtual.direito != null) {
			nodoAtual = nodoAtual.direito;
		}
		return nodoAtual.elemento;
	}

	@Override
	public void inserir(int elemento) {
		adicionar(elemento);
	}

	@Override
	public int[] preOrdem() {
		List<Integer> elementos = new ArrayList<>();
		preOrdemRecursivo(raiz, elementos);
		return elementos.stream().mapToInt(i -> i).toArray();
	}

	private void preOrdemRecursivo(Nodo raizAtual, List<Integer> elementos) {
		if (raizAtual != null) {
			elementos.add(raizAtual.elemento);
			preOrdemRecursivo(raizAtual.esquerdo, elementos);
			preOrdemRecursivo(raizAtual.direito, elementos);
		}
	}

	@Override
	public int[] posOrdem() {
		List<Integer> elementos = new ArrayList<>();
		posOrdemRecursivo(raiz, elementos);
		return elementos.stream().mapToInt(i -> i).toArray();
	}

	private void posOrdemRecursivo(Nodo raizAtual, List<Integer> elementos) {
		if (raizAtual != null) {
			posOrdemRecursivo(raizAtual.esquerdo, elementos);
			posOrdemRecursivo(raizAtual.direito, elementos);
			elementos.add(raizAtual.elemento);
		}
	}
}
