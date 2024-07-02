package br.mentorado.apiservice.domain;

public interface Recursao {
	/**
	 * A recursão na programação é bem exemplificada quando uma função é definida em
	 * termos de si mesma. A função chama a si mesma recursivamente até que alcance
	 * o caso base. Ex: funcao recursiva(n): if n == 1: return 1 recursiva(n-1)
	 * Exercício: Escreva uma função recursiva que imprima os n primeiros números
	 * inteiros a partir de 0
	 */

	public int recursao(final int valor, final int limite);

	/**
	 * Escreva uma função recursiva que retorne a soma dos números de 1 a n
	 */
	public int recursaoSoma(final int valor, final int limite);

	/**
	 * Na matem�tica, a sucess�o de Fibonacci (ou sequ�ncia de Fibonacci), � uma
	 * sequ�ncia de n�meros inteiros, come�ando normalmente por 0 e 1, na qual cada
	 * termo subsequente corresponde � soma dos dois anteriores. A sequ�ncia recebeu
	 * o nome do matem�tico italiano Leonardo de Pisa, mais conhecido por Fibonacci,
	 * que descreveu, no ano de 1202, o crescimento de uma popula��o de coelhos, a
	 * partir desta. Esta sequ�ncia j� era, no entanto, conhecida na antiguidade. Os
	 * n�meros de Fibonacci s�o, portanto, os n�meros que comp�em a seguinte
	 * sequ�ncia (sequ�ncia A000045 na OEIS): 0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55,
	 * 89, 144, 233, 377, 610, 987, 1597, 2584, ... .[nota 1][2] Em termos
	 * matem�ticos, a sequ�ncia � definida recursivamente pela f�rmula abaixo: Fn =
	 * F(n - 1) + F(n - 2) e valores iniciais: F1 = 1, F2 = 1 Sabendo disso, escreva
	 * uma fun��o para calcular a sequ�ncia de fibonacci de forma recursiva E outra
	 * de forma iterativa
	 * 
	 */
	public int recursaoFibonacci(final int valor, final int limite);
	
	public int recursaoFibonacciIterativa(final int n);

}
