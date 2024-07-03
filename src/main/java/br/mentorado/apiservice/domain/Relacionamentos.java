package br.mentorado.apiservice.domain;

import java.math.BigDecimal;
import java.util.List;

import br.mentorado.apiservice.domain.xml.type.ContatoXmlType;
import br.mentorado.apiservice.domain.xml.type.EnderecoXmlType;
import br.mentorado.apiservice.domain.xml.type.PessoaXmlType;

/**
 * Precisamos criar os relacionamentos entre os modelos abaixo:
 * 
 * Pessoa 				 | possui muitos 	| Endereços
 * Pessoa 				 | possui muitos 	| Contatos
 * Pessoa 				 | trabalha em uma	| Empresa
 * Pessoa 				 | possui muitas 	| Formações
 * Pessoa 				 | casada com uma	| Pessoa (Conjuge)
 * Empresa				 | possui muitas	| Profissões
 * Instituição de Ensino | possui muitas 	| Formações
 */
public interface Relacionamentos {

	/**
	 * Criar e preencher as informações dos modelos com base nos (.csv na pasta
	 * resource) e armazenar em uma estrutura de dados que preferir.
	 * 
	 * Classes dos modelos encontra-se em
	 * "br.com.qwasolucoes.mentoria.modelagem_dados"
	 */
	public void iniciar();

	public List<String> buscarCPFsDasPessoasMaioresIdade();

	public List<String> buscarNomeSobrenomeDasPessoasPorAnorNascimento(final Integer ano);

	public List<String> buscarNomeSobrenomeDasPessoasPorEstadoCivil(final String estadoCivil);

	public List<PessoaXmlType> buscarPessoasPorTipoResidencia(final String tipoResidencia);

	public List<PessoaXmlType> buscarPessoasPorTipoContato(final String tipoContato);

	public List<PessoaXmlType> buscarPessoasPorBairro(final String bairro);

	public List<PessoaXmlType> buscarPessoasPorNomeBairroContem(final String valor);

	public List<PessoaXmlType> buscarPessoasPorEstado(final String estado);

	public List<PessoaXmlType> buscarPessoasPorProfissao(final String nomeProfissao);

	public List<PessoaXmlType> buscarPessoasPorProfissaoNomeAreaAtuacaoContem(final String valor);

	public List<PessoaXmlType> buscarPessoasPorSalarioBaseMaiorQue(final BigDecimal salarioBase);

	public List<PessoaXmlType> buscarPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);

	public List<PessoaXmlType> buscarPessoasPorSalarioBaseEntre(final BigDecimal salarioBaseInicio,
			final BigDecimal salarioBaseFim);

	public List<PessoaXmlType> buscarPessoasPorEscolaridadeConcluida();

	public List<PessoaXmlType> buscarPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);

	public List<PessoaXmlType> buscarPessoasPorEscolaridadeAnoTermino(final Integer ano);

	public List<PessoaXmlType> buscarPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);

	public List<PessoaXmlType> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadeConcluido(final String areaAtuacao);

	public List<PessoaXmlType> buscarPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao,
			final Integer semestre);

	public List<PessoaXmlType> buscarPessoasPorEstadoCivilProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			final String estadoCivil, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public List<EnderecoXmlType> buscarEnderecoDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public List<EnderecoXmlType> buscarEnderecoPorTipoEndereco(final String tipoEndereco);

	public List<EnderecoXmlType> buscarNomeRuaEnderecoPorCidadePorPessoaSexoConjungeComAnoNascimento(final String cidade,
			final String sexo, final Integer anoNascimentoConjunge);

	public List<String> buscarNomeDoConjungeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public List<String> buscarNomeDoConjungeDasPessoasPorEstadoCivil(final List<String> estadoCivil);

	public List<String> buscarNomeDoConjungeMaioresDeIdadeDasPessoasPorEstadoCivil(final String estadoCivil);

	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacao(final String areaAtuacao);

	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadoEBairro(final String areaAtuacao,
			final String estado, final String bairro);

	public List<ContatoXmlType> buscarContatoPorProfissaoAreaAtuacaoEnderecoPorEstadosEBairro(final String areaAtuacao,
			final List<String> estados, final String bairro);

	public List<ContatoXmlType> buscarContatoPorTipoContato(final String tipoContato);

	public List<ContatoXmlType> buscarContatoPorTiposContato(final List<String> tipoContato);

	public List<String> buscarEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public List<String> buscarNomeInstituicaoPorPorAreaAtuacao(final String areaAtuacaoProfissao);

	public List<String> buscarNomePessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);

	public List<String> buscarNomePessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);

	public Integer buscarQuantidadeTotalPessoasPorProfissaoPorAreaAtuacao(final String areaAtuacaoProfissao);

	public Integer buscarQuantidadeTotalPessoasPorEscolaridadePorAreaAtuacao(final String areaAtuacaoEscolaridade);

	public Integer buscarQuantidadeTotalPessoasMaioresIdade();

	public Integer buscarQuantidadeTotalDasPessoasPorEstadoCivil(final String estadoCivil);

	public Integer buscarQuantidadeTotalPessoasPorBairro(final String bairro);

	public Integer buscarQuantidadeTotalPessoasPorProfissao(final String nomeProfissao);

	public Integer buscarQuantidadeTotalPessoasPorSalarioBaseMaiorIgual(final BigDecimal salarioBase);

	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeAreaAtuacao(final String areaAtuacao);

	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeQuantidadeSemestre(final Integer semestre);

	public Integer buscarQuantidadeTotalPessoasPorProfissaoAreaAtuacaoEscolaridadePorSemestre(final String areaAtuacao,
			final Integer semestre);

	public Integer buscarQuantidadeTotalEmailPorPessoaAnoNascimentoProfissaoAreaAtuacaoEscolaridadePorAreaAtuacao(
			final Integer anoNasicmento, final String areaAtuacaoProfissao, final String areaAtuacaoEscolaridade);

	public Integer buscarQuantidadeTotalConjugeDasPessoasMaioresIdadeEEstadoCivil(final String estadoCivil);

	public Integer buscarQuantidadeTotalContatosPorTipoContato(final String tipoContato);

	public Integer buscarQuantidadeTotalPessoasPorEscolaridadeNaoConcluida();

	public Integer buscarQuantidadeTotalPessoasPorBairroPorProfissaoPorAreaAtuacao(final String bairro,
			final String areaAtuacaoProfissao);

	public Integer buscarQuantidadeTotalContatoPorTiposContato(final List<String> tipoContato);

}
