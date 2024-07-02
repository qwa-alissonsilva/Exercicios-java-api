package br.mentorado.apiservice.domain.service;

import br.mentorado.apiservice.domain.Recursao;

public class RecursaoService implements Recursao {

	@Override
	public int recursao(int valor, int limite) {
		if (valor > limite) {
			return 0;
		}
		System.out.println(valor);
		return recursao(valor + 1, limite);
	}

	@Override
	public int recursaoSoma(int valor, int limite) {
		if (valor > limite) {
			return 0;
		}
		return valor + recursaoSoma(valor + 1, limite);
	}

	@Override
	public int recursaoFibonacci(int valor, int limite) {
		if (valor <= 1) {
			return valor;
		}
		return recursaoFibonacci(valor - 1, limite) + recursaoFibonacci(valor - 2, limite);
	}

	@Override
	public int recursaoFibonacciIterativa(int n) {
		if (n <= 1) {
			return n;
		}
		int fib1 = 0;
		int fib2 = 1;
		int fibonacci = 1;
		for (int i = 2; i <= n; i++) {
			fibonacci = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibonacci;
		}
		return fibonacci;
	}

}
