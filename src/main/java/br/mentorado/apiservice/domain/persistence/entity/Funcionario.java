package br.mentorado.apiservice.domain.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Funcionario {

	private String nome;

	private String sobrenome;

	private Date dataNascimento;

	private Integer idade;

	private String sexo;

	private String profissao;

	private String cpfCnpj;

	private String escolaridade;

	private BigDecimal salario;

	private boolean maiorIdade;

	private BigDecimal taxa;

	private BigDecimal salarioLiquido;

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", sobrenome=" + sobrenome + ", dataNascimento=" + dataNascimento
				+ ", idade=" + idade + ", sexo=" + sexo + ", profissao=" + profissao + ", cpfCnpj=" + cpfCnpj
				+ ", escolaridade=" + escolaridade + ", salario=" + salario + ", maiorIdade=" + maiorIdade + ", taxa="
				+ taxa + ", salarioLiquido=" + salarioLiquido + "]";
	}

}
