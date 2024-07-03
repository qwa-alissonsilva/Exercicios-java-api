package br.mentorado.apiservice.domain.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import br.mentorado.apiservice.domain.Relacionamentos;
import br.mentorado.apiservice.domain.xml.type.ContatoXmlType;
import br.mentorado.apiservice.domain.xml.type.EnderecoXmlType;
import br.mentorado.apiservice.domain.xml.type.PessoaXmlType;
@Service
public class RelacionamentoProvider implements Relacionamentos {

	@Override
	public void iniciar() {
		// XXX Auto-generated method stub

	}

	@Override
	public List<String> buscarCPFsDasPessoasMaioresIdade() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(Integer ano) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorTipoResidencia(String tipoResidencia) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorTipoContato(String tipoContato) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorBairro(String bairro) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorNomeBairroContem(String valor) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEstado(String estado) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorProfissao(String nomeProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(String valor) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorSalarioBaseMaiorQue(BigDecimal salarioBase) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorSalarioBaseEntre(BigDecimal salarioBaseInicio, BigDecimal salarioBaseFim) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEscolaridadeConcluida() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEscolaridadeAnoTermino(Integer ano) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(String areaAtuacao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<PessoaXmlType> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(String estadoCivil,
			String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<EnderecoXmlType> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<EnderecoXmlType> buscarEnderecoPorTipoEndereco(String tipoEndereco) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<EnderecoXmlType> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(String cidade,
			String sexo, Integer anoNascimentoConjunge) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(List<String> estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacao(String areaAtuacao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(String areaAtuacao, String estado,
			String bairro) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(String areaAtuacao,
			List<String> estados, String bairro) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContatoXmlType> buscarContatoPorTipoContato(String tipoContato) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<ContatoXmlType> buscarContatoPorTiposContato(List<String> tipoContato) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(String areaAtuacaoProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(String areaAtuacaoProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(String areaAtuacaoEscolaridade) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasMaioresIdade() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairro(String bairro) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissao(String nomeProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(BigDecimal salarioBase) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(String areaAtuacao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(Integer semestre) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(String areaAtuacao,
			Integer semestre) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			Integer anoNasicmento, String areaAtuacaoProfissao, String areaAtuacaoEscolaridade) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(String estadoCivil) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatosPorTipoContato(String tipoContato) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida() {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(String bairro,
			String areaAtuacaoProfissao) {
		// XXX Auto-generated method stub
		return null;
	}

	@Override
	public Integer buscarQuantidadeTotalContatoPorTiposContato(List<String> tipoContato) {
		// XXX Auto-generated method stub
		return null;
	}

}
