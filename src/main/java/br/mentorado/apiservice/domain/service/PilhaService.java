package br.mentorado.apiservice.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.Pilha;
@Service
public class PilhaService<T> implements Pilha<T> {

	private List<T> elementos;

	public PilhaService() {
		this.elementos = new ArrayList<>();
	}

	@Override
	public void empilhar(T elemento) {
		this.elementos.add(elemento);
	}

	@Override
	public T desempilhar() {
		if (estaVazia()) {
			throw new IllegalStateException("A pilha está vazia. Não é possível desempilhar.");
		}
		return this.elementos.remove(elementos.size() - 1);
	}

	@Override
	public List<T> obterTodos() {
		return new ArrayList<>(elementos);
	}

	public boolean estaVazia() {
		return this.elementos.isEmpty();
	}
}