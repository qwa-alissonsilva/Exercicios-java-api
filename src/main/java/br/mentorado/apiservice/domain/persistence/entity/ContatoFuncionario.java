package br.mentorado.apiservice.domain.persistence.entity;

public class ContatoFuncionario {

	/**
	 * 0 - telefone 1 - celular 2 - email
	 */
	private int tipo;

	private String valor;

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getTipo() {
		return tipo;
	}

	public String getValor() {
		return valor;
	}

}
