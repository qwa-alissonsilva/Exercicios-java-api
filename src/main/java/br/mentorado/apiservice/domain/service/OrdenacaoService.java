package br.mentorado.apiservice.domain.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.Ordenacao;
@Service
public class OrdenacaoService implements Ordenacao {

	@Override
	public int[] ordenar(int[] elementos) {
		int[] sortedArray = Arrays.copyOf(elementos, elementos.length);
		Arrays.sort(sortedArray);
		return sortedArray;
	}

	@Override
	public int[] quicksort(int[] elementos) {
		if (elementos == null || elementos.length == 0) {
			return elementos;
		}
		quicksort(elementos, 0, elementos.length - 1);
		return elementos;
	}

	private void quicksort(int[] elementos, int inicio, int fim) {
		if (inicio < fim) {
			int indicePivo = particionar(elementos, inicio, fim);
			quicksort(elementos, inicio, indicePivo - 1);
			quicksort(elementos, indicePivo + 1, fim);
		}
	}

	private int particionar(int[] elementos, int inicio, int fim) {
		int pivô = elementos[fim];
		int i = inicio - 1;
		for (int j = inicio; j < fim; j++) {
			if (elementos[j] < pivô) {
				i++;
				int temp = elementos[i];
				elementos[i] = elementos[j];
				elementos[j] = temp;
			}
		}
		int temp = elementos[i + 1];
		elementos[i + 1] = elementos[fim];
		elementos[fim] = temp;

		return i + 1;
	}

	@Override
	public int[] mergesort(int[] elementos) {
		if (elementos.length <= 1) {
			return elementos;
		}

		int meio = elementos.length / 2;

		int[] esquerda = new int[meio];
		int[] direita = new int[elementos.length - meio];
		System.arraycopy(elementos, 0, esquerda, 0, meio);
		System.arraycopy(elementos, meio, direita, 0, elementos.length - meio);

		esquerda = mergesort(esquerda);
		direita = mergesort(direita);
		return merge(esquerda, direita);
	}

	private int[] merge(int[] esquerda, int[] direita) {
		int[] resultado = new int[esquerda.length + direita.length];
		int i = 0, j = 0, k = 0;

		while (i < esquerda.length && j < direita.length) {
			if (esquerda[i] <= direita[j]) {
				resultado[k++] = esquerda[i++];
			} else {
				resultado[k++] = direita[j++];
			}
		}
		while (i < esquerda.length) {
			resultado[k++] = esquerda[i++];
		}
		while (j < direita.length) {
			resultado[k++] = direita[j++];
		}

		return resultado;
	}

	@Override
	public int[] bubbleSort(int[] elementos) {
		int n = elementos.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (elementos[j] > elementos[j + 1]) {
					int temp = elementos[j];
					elementos[j] = elementos[j + 1];
					elementos[j + 1] = temp;
				}
			}
		}
		return elementos;
	}

	@Override
	public int[] particaoPositivosNegativos(int[] valores) {
		if (valores == null || valores.length <= 1) {
			return valores;
		}

		int esquerda = 0;
		int direita = valores.length - 1;

		while (esquerda < direita) {
			while (esquerda < direita && valores[esquerda] % 2 == 0) {
				esquerda++;
			}
			while (esquerda < direita && valores[direita] % 2 != 0) {
				direita--;
			}

			if (esquerda < direita) {
				int temp = valores[esquerda];
				valores[esquerda] = valores[direita];
				valores[direita] = temp;
				esquerda++;
				direita--;
			}
		}

		return valores;
	}

}
