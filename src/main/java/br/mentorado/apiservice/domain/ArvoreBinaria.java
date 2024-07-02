package br.mentorado.apiservice.domain;

/**
 * �rvores bin�rias
 * 
 * Uma �rvore bin�ria � uma estrutura de dados mais geral que uma lista
 * encadeada.
 * 
 * N�s e filhos Uma �rvore bin�ria (= binary tree) � um conjunto de registros
 * que satisfaz certas condi��es.
 * 
 * As condi��es n�o ser�o dadas explicitamente, mas elas ficar�o implicitamente
 * claras no contexto.
 * 
 * Os registros ser�o chamados n�s (poderiam tamb�m ser chamados c�lulas).
 * 
 * Cada n� tem um endere�o.
 * 
 * Suporemos por enquanto que cada n� tem apenas tr�s campos: um n�mero inteiro
 * e dois ponteiros para n�s.
 * 
 * @author ronan
 *
 */
public interface ArvoreBinaria {

	public void adicionar(int elemento);

	public int[] todosOrdenado();

	public int primeiro();

	public int ultimo();

	void inserir(int elemento);

	int[] preOrdem();

	int[] posOrdem();

}
