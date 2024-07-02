package br.mentorado.apiservice.domain;

import java.util.List;

/**
 * Listas encadeadas
 * 
 * Uma lista encadeada � uma representa��o de uma sequ�ncia de objetos, todos do
 * mesmo tipo.
 * 
 * Cada elemento da sequ�ncia � armazenado em uma c�lula da lista:
 * 
 * o primeiro elemento na primeira c�lula, o segundo na segunda, e assim por
 * diante.
 * 
 * Estrutura de uma lista encadeada Uma lista encadeada (= linked list = lista
 * ligada) � uma sequ�ncia de c�lulas;
 * 
 * cada c�lula cont�m um objeto (todos os objetos s�o do mesmo tipo) e o
 * endere�o da c�lula seguinte.
 * 
 * @author ronan
 *
 * @param <T>
 */
public interface ListaEncadeada<T> {

	public void remover();

	public void adicionar(T elemento);

	public List<T> todos();

	public T obter(int indice);

}