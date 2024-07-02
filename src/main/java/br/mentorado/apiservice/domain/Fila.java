package br.mentorado.apiservice.domain;

import java.util.List;

/**
 * 
 * Uma fila � uma estrutura de dados din�mica que admite remo��o de elementos e
 * inser��o de novos objetos.
 * 
 * Mais especificamente, uma fila (= queue) � uma estrutura sujeita � seguinte
 * regra de opera��o:
 * 
 * sempre que houver uma remo��o, o elemento removido � o que est� na estrutura
 * h� mais tempo.
 * 
 * Em outras palavras, o primeiro objeto inserido na fila � tamb�m o primeiro a
 * ser removido.
 * 
 * Essa pol�tica � conhecida pela sigla FIFO (= First-In-First-Out).
 * 
 * @author ronan
 *
 */
public interface Fila<T> {

	public void remover();

	public void adicionar(T elemento);

	public List<T> todos();

	public T obter(int indice);

}
