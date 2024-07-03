package br.mentorado.apiservice.domain.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.EstruturaDadosList;
import br.mentorado.apiservice.domain.persistence.entity.Funcionario;

@Service
public class EstruturaDadosListService implements EstruturaDadosList {

	@Override
	public List<String> nomes(List<Funcionario> pessoas) {

		List<String> nomes = new ArrayList<>();

		for (Funcionario funcionarios : pessoas) {
			nomes.add(funcionarios.getNome());
		}

		return nomes;
	}

	@Override
	public List<String> sobrenomes(List<Funcionario> pessoas) {

		List<String> sobrenomes = new ArrayList<>();

		for (Funcionario funcionarios : pessoas) {
			sobrenomes.add(funcionarios.getSobrenome());
		}

		return sobrenomes;
	}

	@Override
	public List<Integer> maiores18(List<Funcionario> pessoas) {

		List<Integer> maiorDe18 = new ArrayList<>();

		for (Funcionario funcionarios : pessoas) {
			if (funcionarios.getIdade() > 18) {
				maiorDe18.add(funcionarios.getIdade());
			}
		}

		return maiorDe18;
	}

	@Override
	public List<Integer> menores18(List<Funcionario> pessoas) {

		List<Integer> maiorDe18 = new ArrayList<>();

		for (Funcionario funcionarios : pessoas) {
			if (funcionarios.getIdade() < 18) {
				maiorDe18.add(funcionarios.getIdade());
			}
		}

		return maiorDe18;
	}

	@Override
	public Integer pessoaMaisVelha(List<Funcionario> pessoas) {

		Integer maisVelho = 0;

		for (Funcionario funcionarios : pessoas) {
			if (funcionarios.getIdade() > maisVelho) {
				maisVelho = funcionarios.getIdade();
			}

		}

		return maisVelho;
	}

	@Override
	public Integer pessoaMaisNova(List<Funcionario> pessoas) {

		Funcionario primeiroFuncionario = pessoas.get(0);
		Integer menorIdade = primeiroFuncionario.getIdade();

		for (Funcionario funcionarios : pessoas) {
			if (funcionarios.getIdade() < menorIdade) {
				menorIdade = funcionarios.getIdade();
			}
		}

		return menorIdade;
	}

	@Override
	public BigDecimal maiorSalario(List<Funcionario> pessoas) {

		BigDecimal maiorSalario = BigDecimal.ZERO;

		for (Funcionario funcionario : pessoas) {
			if (funcionario.getSalario().compareTo(maiorSalario) > 0) {
				maiorSalario = funcionario.getSalario();
			}
		}

		return maiorSalario;
	}

	@Override
	public BigDecimal menorTaxa(List<Funcionario> pessoas) {

		Funcionario primeiroFuncionario = pessoas.get(0);
		BigDecimal menorTaxa = primeiroFuncionario.getTaxa();

		for (Funcionario funcionario : pessoas) {
			if (funcionario.getTaxa().compareTo(menorTaxa) < 0) {
				menorTaxa = funcionario.getTaxa();
			}
		}

		return menorTaxa;
	}

	@Override
	public String nomePrimeiraPessoa(List<Funcionario> pessoas) {

		Funcionario primeiroFuncionario = pessoas.get(0);

		String nomePrimeiraPessoa = primeiroFuncionario.getNome();

		return nomePrimeiraPessoa;
	}

	@Override
	public String nomeUltimaPessoa(List<Funcionario> pessoas) {

		Funcionario primeiroFuncionario = pessoas.get(pessoas.size() - 1);

		String nomeUltimaPessoa = primeiroFuncionario.getNome();

		return nomeUltimaPessoa;
	}

	@Override
	public String maiorNome(List<Funcionario> pessoas) {

		String maiorNome = "";

		for (Funcionario funcionario : pessoas) {
			String nomeFuncionarios = funcionario.getNome();

			if (nomeFuncionarios.length() > maiorNome.length()) {
				maiorNome = nomeFuncionarios;
			}
		}

		return maiorNome;
	}

	@Override
	public String maiorNomeCompleto(List<Funcionario> pessoas) {
		Funcionario primeiroFuncionario = pessoas.get(0);
		String maiorNomeCompleto = primeiroFuncionario.getNome() + primeiroFuncionario.getSobrenome();

		for (Funcionario funcionario : pessoas) {
			String nomeFuncionarios = funcionario.getNome() + funcionario.getSobrenome();

			if (nomeFuncionarios.length() > maiorNomeCompleto.length()) {
				maiorNomeCompleto = nomeFuncionarios;
			}
		}

		return maiorNomeCompleto;
	}

	@Override
	public Integer quantidadePessoasSexoMasculino(List<Funcionario> pessoas) {

		Integer pessoasSexoMasculino = 0;

		for (Funcionario funcionario : pessoas) {
			if (funcionario.getSexo() == "M") {
				pessoasSexoMasculino++;
			}
		}

		return pessoasSexoMasculino;
	}

	@Override
	public List<BigDecimal> maioresSalariosPeloValor(List<Funcionario> pessoas, BigDecimal valor) {

		List<BigDecimal> maiorSalarioPeloValor = new ArrayList<>();

		for (Funcionario funcionario : pessoas) {
			if (funcionario.getSalario().compareTo(valor) > 0) {
				maiorSalarioPeloValor.add(funcionario.getSalario());
			}
		}

		return maiorSalarioPeloValor;
	}

}