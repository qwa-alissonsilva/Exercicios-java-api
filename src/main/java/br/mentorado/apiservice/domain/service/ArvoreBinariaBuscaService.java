package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.ArvoreBinariaBusca;

public class ArvoreBinariaBuscaService implements ArvoreBinariaBusca {
	private Nodo raiz;

	public ArvoreBinariaBuscaService() {
		this.raiz = null;
	}

	@Override
	public void inserir(int elemento) {
		this.raiz = inserirRecursivamente(this.raiz, elemento);
	}

	private Nodo inserirRecursivamente(Nodo nodo, int elemento) {
		if (nodo == null) {
			return new Nodo(elemento);
		}

		if (elemento < nodo.valor) {
			nodo.esquerda = inserirRecursivamente(nodo.esquerda, elemento);
		} else if (elemento > nodo.valor) {
			nodo.direita = inserirRecursivamente(nodo.direita, elemento);
		}

		return nodo;
	}

	@Override
	public int[] todosOrdenado() {
		List<Integer> elementos = new ArrayList<>();
		inOrdem(this.raiz, elementos);
		return elementos.stream().mapToInt(Integer::intValue).toArray();
	}

	private void inOrdem(Nodo nodo, List<Integer> elementos) {
		if (nodo != null) {
			inOrdem(nodo.esquerda, elementos);
			elementos.add(nodo.valor);
			inOrdem(nodo.direita, elementos);
		}
	}

	@Override
	public int[] preOrdem() {
		List<Integer> elementos = new ArrayList<>();
		preOrdem(this.raiz, elementos);
		return elementos.stream().mapToInt(Integer::intValue).toArray();
	}

	private void preOrdem(Nodo nodo, List<Integer> elementos) {
		if (nodo != null) {
			elementos.add(nodo.valor);
			preOrdem(nodo.esquerda, elementos);
			preOrdem(nodo.direita, elementos);
		}
	}

	@Override
	public int[] posOrdem() {
		List<Integer> elementos = new ArrayList<>();
		posOrdem(this.raiz, elementos);
		return elementos.stream().mapToInt(Integer::intValue).toArray();
	}

	private void posOrdem(Nodo nodo, List<Integer> elementos) {
		if (nodo != null) {
			posOrdem(nodo.esquerda, elementos);
			posOrdem(nodo.direita, elementos);
			elementos.add(nodo.valor);
		}
	}

	@Override
	public int primeiro() {
		Nodo atual = this.raiz;
		while (atual.esquerda != null) {
			atual = atual.esquerda;
		}
		return atual.valor;
	}

	@Override
	public int ultimo() {
		Nodo atual = this.raiz;
		while (atual.direita != null) {
			atual = atual.direita;
		}
		return atual.valor;
	}

	private static class Nodo {
		int valor;
		Nodo esquerda;
		Nodo direita;

		Nodo(int valor) {
			this.valor = valor;
			this.esquerda = null;
			this.direita = null;
		}
	}
}
