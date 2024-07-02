package br.mentorado.apiservice.domain;

import java.util.List;

/**
 * Uma pilha � uma estrutura de dados que admite remo��o de elementos e inser��o
 * de novos objetos. Mais especificamente, uma pilha (= stack) � uma estrutura
 * sujeita � seguinte regra de opera��o:
 * 
 * sempre que houver uma remo��o, o elemento removido � o que est� na estrutura
 * h� menos tempo.
 * 
 * Em outras palavras, o primeiro objeto a ser inserido na pilha � o �ltimo a
 * ser removido.
 * 
 * Essa pol�tica � conhecida pela sigla LIFO (= Last-In-First-Out).
 * 
 * @author ronan
 */
public interface Pilha<T> {

	public void empilhar(T elemento);

	public T desempilhar();

	public List<T> obterTodos();

}
