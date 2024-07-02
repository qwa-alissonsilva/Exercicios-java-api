package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.List;

import br.mentorado.apiservice.domain.ListaEncadeada;

public class ListaEncadeadaProviderService<T> implements ListaEncadeada<T> {

	private class No {
		T elemento;
		No proximo;

		public No(T elemento) {
			this.elemento = elemento;
			this.proximo = null;
		}
	}

	private No inicio;

	public ListaEncadeadaProviderService() {
		this.inicio = null;
	}

	@Override
	public void remover() {
		if (inicio == null) {
			throw new IllegalStateException("Lista vazia, não é possível remover.");
		}
		inicio = inicio.proximo;
	}

	@Override
	public void adicionar(T elemento) {
		No novoNo = new No(elemento);
		if (inicio == null) {
			inicio = novoNo;
		} else {
			No atual = inicio;
			while (atual.proximo != null) {
				atual = atual.proximo;
			}
			atual.proximo = novoNo;
		}
	}

	@Override
	public List<T> todos() {
		List<T> lista = new ArrayList<>();
		No atual = inicio;
		while (atual != null) {
			lista.add(atual.elemento);
			atual = atual.proximo;
		}
		return lista;
	}

	@Override
	public T obter(int indice) {
		No atual = inicio;
		int contador = 0;
		while (atual != null) {
			if (contador == indice) {
				return atual.elemento;
			}
			atual = atual.proximo;
			contador++;
		}
		throw new IndexOutOfBoundsException("Índice fora dos limites da lista.");
	}

}
