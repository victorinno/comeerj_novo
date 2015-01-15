/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author floriano.peixoto
 */
@Entity
@Table(name = "comeerj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comeerj.findAll", query = "SELECT c FROM Comeerj c"),
    @NamedQuery(name = "Comeerj.findByCodFichaInscricaoComeerjId", query = "SELECT c FROM Comeerj c WHERE c.codFichaInscricaoComeerjId = :codFichaInscricaoComeerjId"),
    @NamedQuery(name = "Comeerj.findByNumComeerj", query = "SELECT c FROM Comeerj c WHERE c.numComeerj = :numComeerj"),
    @NamedQuery(name = "Comeerj.findByNumFichaInscricao", query = "SELECT c FROM Comeerj c WHERE c.numFichaInscricao = :numFichaInscricao"),
    @NamedQuery(name = "Comeerj.findByDscTipoParticipacao", query = "SELECT c FROM Comeerj c WHERE c.dscTipoParticipacao = :dscTipoParticipacao"),
    @NamedQuery(name = "Comeerj.findByDscTipoComissao", query = "SELECT c FROM Comeerj c WHERE c.dscTipoComissao = :dscTipoComissao"),
    @NamedQuery(name = "Comeerj.findByDatNascimento", query = "SELECT c FROM Comeerj c WHERE c.datNascimento = :datNascimento"),
    @NamedQuery(name = "Comeerj.findByDscProfissao", query = "SELECT c FROM Comeerj c WHERE c.dscProfissao = :dscProfissao"),
    @NamedQuery(name = "Comeerj.findByCodOpcao1Polo", query = "SELECT c FROM Comeerj c WHERE c.codOpcao1Polo = :codOpcao1Polo"),
    @NamedQuery(name = "Comeerj.findByCodOpcao2Polo", query = "SELECT c FROM Comeerj c WHERE c.codOpcao2Polo = :codOpcao2Polo"),
    @NamedQuery(name = "Comeerj.findByNomCompleto", query = "SELECT c FROM Comeerj c WHERE c.nomCompleto = :nomCompleto"),
    @NamedQuery(name = "Comeerj.findByCodSexo", query = "SELECT c FROM Comeerj c WHERE c.codSexo = :codSexo"),
    @NamedQuery(name = "Comeerj.findByNomCracha", query = "SELECT c FROM Comeerj c WHERE c.nomCracha = :nomCracha"),
    @NamedQuery(name = "Comeerj.findByDscEnderecoMoradia", query = "SELECT c FROM Comeerj c WHERE c.dscEnderecoMoradia = :dscEnderecoMoradia"),
    @NamedQuery(name = "Comeerj.findByDscComplementoMoradia", query = "SELECT c FROM Comeerj c WHERE c.dscComplementoMoradia = :dscComplementoMoradia"),
    @NamedQuery(name = "Comeerj.findByNomBairroMoradia", query = "SELECT c FROM Comeerj c WHERE c.nomBairroMoradia = :nomBairroMoradia"),
    @NamedQuery(name = "Comeerj.findByCodCepMoradia", query = "SELECT c FROM Comeerj c WHERE c.codCepMoradia = :codCepMoradia"),
    @NamedQuery(name = "Comeerj.findByNomCidadeMoradia", query = "SELECT c FROM Comeerj c WHERE c.nomCidadeMoradia = :nomCidadeMoradia"),
    @NamedQuery(name = "Comeerj.findBySigUfMoradia", query = "SELECT c FROM Comeerj c WHERE c.sigUfMoradia = :sigUfMoradia"),
    @NamedQuery(name = "Comeerj.findByCodTipoContato1", query = "SELECT c FROM Comeerj c WHERE c.codTipoContato1 = :codTipoContato1"),
    @NamedQuery(name = "Comeerj.findByNumContato1", query = "SELECT c FROM Comeerj c WHERE c.numContato1 = :numContato1"),
    @NamedQuery(name = "Comeerj.findByCodTipoContato2", query = "SELECT c FROM Comeerj c WHERE c.codTipoContato2 = :codTipoContato2"),
    @NamedQuery(name = "Comeerj.findByNumContato2", query = "SELECT c FROM Comeerj c WHERE c.numContato2 = :numContato2"),
    @NamedQuery(name = "Comeerj.findByCodTipoContato3", query = "SELECT c FROM Comeerj c WHERE c.codTipoContato3 = :codTipoContato3"),
    @NamedQuery(name = "Comeerj.findByNumContato3", query = "SELECT c FROM Comeerj c WHERE c.numContato3 = :numContato3"),
    @NamedQuery(name = "Comeerj.findByDscEmail", query = "SELECT c FROM Comeerj c WHERE c.dscEmail = :dscEmail"),
    @NamedQuery(name = "Comeerj.findByIndOutraComeerj", query = "SELECT c FROM Comeerj c WHERE c.indOutraComeerj = :indOutraComeerj"),
    @NamedQuery(name = "Comeerj.findByQtdOutraComeerj", query = "SELECT c FROM Comeerj c WHERE c.qtdOutraComeerj = :qtdOutraComeerj"),
    @NamedQuery(name = "Comeerj.findByIndFazUsoMedicacao", query = "SELECT c FROM Comeerj c WHERE c.indFazUsoMedicacao = :indFazUsoMedicacao"),
    @NamedQuery(name = "Comeerj.findByDscListaMedicamento", query = "SELECT c FROM Comeerj c WHERE c.dscListaMedicamento = :dscListaMedicamento"),
    @NamedQuery(name = "Comeerj.findByIndTemConvenioMedico", query = "SELECT c FROM Comeerj c WHERE c.indTemConvenioMedico = :indTemConvenioMedico"),
    @NamedQuery(name = "Comeerj.findByNomConvenioMedico", query = "SELECT c FROM Comeerj c WHERE c.nomConvenioMedico = :nomConvenioMedico"),
    @NamedQuery(name = "Comeerj.findByIndVegetariano", query = "SELECT c FROM Comeerj c WHERE c.indVegetariano = :indVegetariano"),
    @NamedQuery(name = "Comeerj.findByDscListaAlimentacao", query = "SELECT c FROM Comeerj c WHERE c.dscListaAlimentacao = :dscListaAlimentacao"),
    @NamedQuery(name = "Comeerj.findByIndAlergico", query = "SELECT c FROM Comeerj c WHERE c.indAlergico = :indAlergico"),
    @NamedQuery(name = "Comeerj.findByDscListaAlergia", query = "SELECT c FROM Comeerj c WHERE c.dscListaAlergia = :dscListaAlergia"),
    @NamedQuery(name = "Comeerj.findByNomAutorizacaoMenor", query = "SELECT c FROM Comeerj c WHERE c.nomAutorizacaoMenor = :nomAutorizacaoMenor"),
    @NamedQuery(name = "Comeerj.findByNumIdentidadeAutorizacaoMenor", query = "SELECT c FROM Comeerj c WHERE c.numIdentidadeAutorizacaoMenor = :numIdentidadeAutorizacaoMenor"),
    @NamedQuery(name = "Comeerj.findByNomIeParticipa", query = "SELECT c FROM Comeerj c WHERE c.nomIeParticipa = :nomIeParticipa"),
    @NamedQuery(name = "Comeerj.findByNumCeuIea", query = "SELECT c FROM Comeerj c WHERE c.numCeuIea = :numCeuIea"),
    @NamedQuery(name = "Comeerj.findByDscEnderecoIea", query = "SELECT c FROM Comeerj c WHERE c.dscEnderecoIea = :dscEnderecoIea"),
    @NamedQuery(name = "Comeerj.findByNomBairroIea", query = "SELECT c FROM Comeerj c WHERE c.nomBairroIea = :nomBairroIea"),
    @NamedQuery(name = "Comeerj.findByCodCepIea", query = "SELECT c FROM Comeerj c WHERE c.codCepIea = :codCepIea"),
    @NamedQuery(name = "Comeerj.findByNomCidadeIea", query = "SELECT c FROM Comeerj c WHERE c.nomCidadeIea = :nomCidadeIea"),
    @NamedQuery(name = "Comeerj.findBySigUfIea", query = "SELECT c FROM Comeerj c WHERE c.sigUfIea = :sigUfIea"),
    @NamedQuery(name = "Comeerj.findByCodTipoContatoIea", query = "SELECT c FROM Comeerj c WHERE c.codTipoContatoIea = :codTipoContatoIea"),
    @NamedQuery(name = "Comeerj.findByNumContatoIea", query = "SELECT c FROM Comeerj c WHERE c.numContatoIea = :numContatoIea"),
    @NamedQuery(name = "Comeerj.findByDscDiaReuniaoJuventude", query = "SELECT c FROM Comeerj c WHERE c.dscDiaReuniaoJuventude = :dscDiaReuniaoJuventude"),
    @NamedQuery(name = "Comeerj.findByDscHorarioReuniaoJuventude", query = "SELECT c FROM Comeerj c WHERE c.dscHorarioReuniaoJuventude = :dscHorarioReuniaoJuventude"),
    @NamedQuery(name = "Comeerj.findByCodTipoParticipacaoIea", query = "SELECT c FROM Comeerj c WHERE c.codTipoParticipacaoIea = :codTipoParticipacaoIea"),
    @NamedQuery(name = "Comeerj.findByDscOutraParticipacao", query = "SELECT c FROM Comeerj c WHERE c.dscOutraParticipacao = :dscOutraParticipacao"),
    @NamedQuery(name = "Comeerj.findByDatCadastramento", query = "SELECT c FROM Comeerj c WHERE c.datCadastramento = :datCadastramento"),
    @NamedQuery(name = "Comeerj.findByIndPagouInscricao", query = "SELECT c FROM Comeerj c WHERE c.indPagouInscricao = :indPagouInscricao"),
    @NamedQuery(name = "Comeerj.findByDatPagamentoInscricao", query = "SELECT c FROM Comeerj c WHERE c.datPagamentoInscricao = :datPagamentoInscricao"),
    @NamedQuery(name = "Comeerj.findByIndCompareceu", query = "SELECT c FROM Comeerj c WHERE c.indCompareceu = :indCompareceu"),
    @NamedQuery(name = "Comeerj.findByNomContato4", query = "SELECT c FROM Comeerj c WHERE c.nomContato4 = :nomContato4"),
    @NamedQuery(name = "Comeerj.findByNumContato4", query = "SELECT c FROM Comeerj c WHERE c.numContato4 = :numContato4"),
    @NamedQuery(name = "Comeerj.findByPwdSenhaCadastro", query = "SELECT c FROM Comeerj c WHERE c.pwdSenhaCadastro = :pwdSenhaCadastro"),
    @NamedQuery(name = "Comeerj.findByNomFilhoInscritoPolo", query = "SELECT c FROM Comeerj c WHERE c.nomFilhoInscritoPolo = :nomFilhoInscritoPolo"),
    @NamedQuery(name = "Comeerj.findByNumTelConvenioMedico", query = "SELECT c FROM Comeerj c WHERE c.numTelConvenioMedico = :numTelConvenioMedico"),
    @NamedQuery(name = "Comeerj.findByCodStatusFichaInscricao", query = "SELECT c FROM Comeerj c WHERE c.codStatusFichaInscricao = :codStatusFichaInscricao"),
    @NamedQuery(name = "Comeerj.findByNomOutraCidadeMoradia", query = "SELECT c FROM Comeerj c WHERE c.nomOutraCidadeMoradia = :nomOutraCidadeMoradia"),
    @NamedQuery(name = "Comeerj.findByNomOutraCidadeIea", query = "SELECT c FROM Comeerj c WHERE c.nomOutraCidadeIea = :nomOutraCidadeIea"),
    @NamedQuery(name = "Comeerj.findByIndicImportouDados", query = "SELECT c FROM Comeerj c WHERE c.indicImportouDados = :indicImportouDados"),
    @NamedQuery(name = "Comeerj.findByIndicPortadorNEspecial", query = "SELECT c FROM Comeerj c WHERE c.indicPortadorNEspecial = :indicPortadorNEspecial"),
    @NamedQuery(name = "Comeerj.findByDscObservacaoNEspecial", query = "SELECT c FROM Comeerj c WHERE c.dscObservacaoNEspecial = :dscObservacaoNEspecial"),
    @NamedQuery(name = "Comeerj.findByIndicTemRespPeqCompanheiro", query = "SELECT c FROM Comeerj c WHERE c.indicTemRespPeqCompanheiro = :indicTemRespPeqCompanheiro"),
    @NamedQuery(name = "Comeerj.findByNumInscricaoRespPeqCompanheiro", query = "SELECT c FROM Comeerj c WHERE c.numInscricaoRespPeqCompanheiro = :numInscricaoRespPeqCompanheiro"),
    @NamedQuery(name = "Comeerj.findByNumInscricaoConjuge", query = "SELECT c FROM Comeerj c WHERE c.numInscricaoConjuge = :numInscricaoConjuge"),
    @NamedQuery(name = "Comeerj.findByDscHabilidades", query = "SELECT c FROM Comeerj c WHERE c.dscHabilidades = :dscHabilidades"),
    @NamedQuery(name = "Comeerj.findByIndicTemConjuge", query = "SELECT c FROM Comeerj c WHERE c.indicTemConjuge = :indicTemConjuge"),
    @NamedQuery(name = "Comeerj.findByCodEstadoCivil", query = "SELECT c FROM Comeerj c WHERE c.codEstadoCivil = :codEstadoCivil"),
    @NamedQuery(name = "Comeerj.findByDscEmailCoordenador", query = "SELECT c FROM Comeerj c WHERE c.dscEmailCoordenador = :dscEmailCoordenador"),
    @NamedQuery(name = "Comeerj.findByIndicPortadorNEduEspecial", query = "SELECT c FROM Comeerj c WHERE c.indicPortadorNEduEspecial = :indicPortadorNEduEspecial"),
    @NamedQuery(name = "Comeerj.findByDscObservacaoNEduEspecial", query = "SELECT c FROM Comeerj c WHERE c.dscObservacaoNEduEspecial = :dscObservacaoNEduEspecial")})
public class Comeerj implements Serializable {
    @OneToMany(mappedBy = "aluno")
    private List<TurmaAlunos> turmaAlunosList;
    @OneToMany(mappedBy = "coordenador")
    private List<AlojamentoCoordenador> alojamentoCoordenadorList;
    @OneToMany(mappedBy = "membro")
    private List<AlojamentoMembros> alojamentoMembrosList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    private Integer codFichaInscricaoComeerjId;
    @Column(name = "NUM_COMEERJ")
    private Integer numComeerj;
    @Column(name = "NUM_FICHA_INSCRICAO")
    private Integer numFichaInscricao;
    @Size(max = 21)
    @Column(name = "DSC_TIPO_PARTICIPACAO")
    private String dscTipoParticipacao;
    @Size(max = 69)
    @Column(name = "DSC_TIPO_COMISSAO")
    private String dscTipoComissao;
    @Size(max = 10)
    @Column(name = "DAT_NASCIMENTO")
    private String datNascimento;
    @Size(max = 1)
    @Column(name = "DSC_PROFISSAO")
    private String dscProfissao;
    @Size(max = 13)
    @Column(name = "COD_OPCAO_1_POLO")
    private String codOpcao1Polo;
    @Size(max = 27)
    @Column(name = "COD_OPCAO_2_POLO")
    private String codOpcao2Polo;
    @Size(max = 47)
    @Column(name = "NOM_COMPLETO")
    private String nomCompleto;
    @Size(max = 1)
    @Column(name = "COD_SEXO")
    private String codSexo;
    @Size(max = 25)
    @Column(name = "NOM_CRACHA")
    private String nomCracha;
    @Size(max = 48)
    @Column(name = "DSC_ENDERECO_MORADIA")
    private String dscEnderecoMoradia;
    @Size(max = 25)
    @Column(name = "DSC_COMPLEMENTO_MORADIA")
    private String dscComplementoMoradia;
    @Size(max = 34)
    @Column(name = "NOM_BAIRRO_MORADIA")
    private String nomBairroMoradia;
    @Size(max = 9)
    @Column(name = "COD_CEP_MORADIA")
    private String codCepMoradia;
    @Size(max = 14)
    @Column(name = "NOM_CIDADE_MORADIA")
    private String nomCidadeMoradia;
    @Size(max = 2)
    @Column(name = "SIG_UF_MORADIA")
    private String sigUfMoradia;
    @Size(max = 11)
    @Column(name = "COD_TIPO_CONTATO_1")
    private String codTipoContato1;
    @Size(max = 15)
    @Column(name = "NUM_CONTATO_1")
    private String numContato1;
    @Size(max = 11)
    @Column(name = "COD_TIPO_CONTATO_2")
    private String codTipoContato2;
    @Size(max = 15)
    @Column(name = "NUM_CONTATO_2")
    private String numContato2;
    @Size(max = 11)
    @Column(name = "COD_TIPO_CONTATO_3")
    private String codTipoContato3;
    @Size(max = 15)
    @Column(name = "NUM_CONTATO_3")
    private String numContato3;
    @Size(max = 39)
    @Column(name = "DSC_EMAIL")
    private String dscEmail;
    @Size(max = 1)
    @Column(name = "IND_OUTRA_COMEERJ")
    private String indOutraComeerj;
    @Column(name = "QTD_OUTRA_COMEERJ")
    private Integer qtdOutraComeerj;
    @Size(max = 1)
    @Column(name = "IND_FAZ_USO_MEDICACAO")
    private String indFazUsoMedicacao;
    @Size(max = 48)
    @Column(name = "DSC_LISTA_MEDICAMENTO")
    private String dscListaMedicamento;
    @Size(max = 1)
    @Column(name = "IND_TEM_CONVENIO_MEDICO")
    private String indTemConvenioMedico;
    @Size(max = 39)
    @Column(name = "NOM_CONVENIO_MEDICO")
    private String nomConvenioMedico;
    @Size(max = 1)
    @Column(name = "IND_VEGETARIANO")
    private String indVegetariano;
    @Size(max = 40)
    @Column(name = "DSC_LISTA_ALIMENTACAO")
    private String dscListaAlimentacao;
    @Size(max = 1)
    @Column(name = "IND_ALERGICO")
    private String indAlergico;
    @Size(max = 50)
    @Column(name = "DSC_LISTA_ALERGIA")
    private String dscListaAlergia;
    @Size(max = 38)
    @Column(name = "NOM_AUTORIZACAO_MENOR")
    private String nomAutorizacaoMenor;
    @Size(max = 17)
    @Column(name = "NUM_IDENTIDADE_AUTORIZACAO_MENOR")
    private String numIdentidadeAutorizacaoMenor;
    @Size(max = 52)
    @Column(name = "NOM_IE_PARTICIPA")
    private String nomIeParticipa;
    @Size(max = 7)
    @Column(name = "NUM_CEU_IEA")
    private String numCeuIea;
    @Size(max = 50)
    @Column(name = "DSC_ENDERECO_IEA")
    private String dscEnderecoIea;
    @Size(max = 20)
    @Column(name = "NOM_BAIRRO_IEA")
    private String nomBairroIea;
    @Size(max = 9)
    @Column(name = "COD_CEP_IEA")
    private String codCepIea;
    @Size(max = 14)
    @Column(name = "NOM_CIDADE_IEA")
    private String nomCidadeIea;
    @Size(max = 2)
    @Column(name = "SIG_UF_IEA")
    private String sigUfIea;
    @Size(max = 20)
    @Column(name = "COD_TIPO_CONTATO_IEA")
    private String codTipoContatoIea;
    @Size(max = 15)
    @Column(name = "NUM_CONTATO_IEA")
    private String numContatoIea;
    @Size(max = 13)
    @Column(name = "DSC_DIA_REUNIAO_JUVENTUDE")
    private String dscDiaReuniaoJuventude;
    @Size(max = 5)
    @Column(name = "DSC_HORARIO_REUNIAO_JUVENTUDE")
    private String dscHorarioReuniaoJuventude;
    @Size(max = 37)
    @Column(name = "COD_TIPO_PARTICIPACAO_IEA")
    private String codTipoParticipacaoIea;
    @Size(max = 50)
    @Column(name = "DSC_OUTRA_PARTICIPACAO")
    private String dscOutraParticipacao;
    @Column(name = "DAT_CADASTRAMENTO")
    @Temporal(TemporalType.DATE)
    private Date datCadastramento;
    @Size(max = 1)
    @Column(name = "IND_PAGOU_INSCRICAO")
    private String indPagouInscricao;
    @Size(max = 10)
    @Column(name = "DAT_PAGAMENTO_INSCRICAO")
    private String datPagamentoInscricao;
    @Size(max = 1)
    @Column(name = "IND_COMPARECEU")
    private String indCompareceu;
    @Size(max = 43)
    @Column(name = "NOM_CONTATO_4")
    private String nomContato4;
    @Size(max = 15)
    @Column(name = "NUM_CONTATO_4")
    private String numContato4;
    @Size(max = 6)
    @Column(name = "PWD_SENHA_CADASTRO")
    private String pwdSenhaCadastro;
    @Size(max = 37)
    @Column(name = "NOM_FILHO_INSCRITO_POLO")
    private String nomFilhoInscritoPolo;
    @Size(max = 15)
    @Column(name = "NUM_TEL_CONVENIO_MEDICO")
    private String numTelConvenioMedico;
    @Size(max = 10)
    @Column(name = "COD_STATUS_FICHA_INSCRICAO")
    private String codStatusFichaInscricao;
    @Size(max = 1)
    @Column(name = "NOM_OUTRA_CIDADE_MORADIA")
    private String nomOutraCidadeMoradia;
    @Size(max = 1)
    @Column(name = "NOM_OUTRA_CIDADE_IEA")
    private String nomOutraCidadeIea;
    @Size(max = 1)
    @Column(name = "INDIC_IMPORTOU_DADOS")
    private String indicImportouDados;
    @Size(max = 1)
    @Column(name = "INDIC_PORTADOR_N_ESPECIAL")
    private String indicPortadorNEspecial;
    @Size(max = 20)
    @Column(name = "DSC_OBSERVACAO_N_ESPECIAL")
    private String dscObservacaoNEspecial;
    @Size(max = 1)
    @Column(name = "INDIC_TEM_RESP_PEQ_COMPANHEIRO")
    private String indicTemRespPeqCompanheiro;
    @Column(name = "NUM_INSCRICAO_RESP_PEQ_COMPANHEIRO")
    private Integer numInscricaoRespPeqCompanheiro;
    @Column(name = "NUM_INSCRICAO_CONJUGE")
    private Integer numInscricaoConjuge;
    @Size(max = 35)
    @Column(name = "DSC_HABILIDADES")
    private String dscHabilidades;
    @Size(max = 1)
    @Column(name = "INDIC_TEM_CONJUGE")
    private String indicTemConjuge;
    @Size(max = 13)
    @Column(name = "COD_ESTADO_CIVIL")
    private String codEstadoCivil;
    @Size(max = 38)
    @Column(name = "DSC_EMAIL_COORDENADOR")
    private String dscEmailCoordenador;
    @Size(max = 1)
    @Column(name = "INDIC_PORTADOR_N_EDU_ESPECIAL")
    private String indicPortadorNEduEspecial;
    @Size(max = 7)
    @Column(name = "DSC_OBSERVACAO_N_EDU_ESPECIAL")
    private String dscObservacaoNEduEspecial;
    @OneToMany(mappedBy = "dados")
    private List<DadosEquipe> dadosEquipeList;

    public Comeerj() {
    }

    public Comeerj(Integer codFichaInscricaoComeerjId) {
        this.codFichaInscricaoComeerjId = codFichaInscricaoComeerjId;
    }

    public Integer getCodFichaInscricaoComeerjId() {
        return codFichaInscricaoComeerjId;
    }

    public void setCodFichaInscricaoComeerjId(Integer codFichaInscricaoComeerjId) {
        this.codFichaInscricaoComeerjId = codFichaInscricaoComeerjId;
    }

    public Integer getNumComeerj() {
        return numComeerj;
    }

    public void setNumComeerj(Integer numComeerj) {
        this.numComeerj = numComeerj;
    }

    public Integer getNumFichaInscricao() {
        return numFichaInscricao;
    }

    public void setNumFichaInscricao(Integer numFichaInscricao) {
        this.numFichaInscricao = numFichaInscricao;
    }

    public String getDscTipoParticipacao() {
        return dscTipoParticipacao;
    }

    public void setDscTipoParticipacao(String dscTipoParticipacao) {
        this.dscTipoParticipacao = dscTipoParticipacao;
    }

    public String getDscTipoComissao() {
        return dscTipoComissao;
    }

    public void setDscTipoComissao(String dscTipoComissao) {
        this.dscTipoComissao = dscTipoComissao;
    }

    public String getDatNascimento() {
        return datNascimento;
    }

    public void setDatNascimento(String datNascimento) {
        this.datNascimento = datNascimento;
    }

    public String getDscProfissao() {
        return dscProfissao;
    }

    public void setDscProfissao(String dscProfissao) {
        this.dscProfissao = dscProfissao;
    }

    public String getCodOpcao1Polo() {
        return codOpcao1Polo;
    }

    public void setCodOpcao1Polo(String codOpcao1Polo) {
        this.codOpcao1Polo = codOpcao1Polo;
    }

    public String getCodOpcao2Polo() {
        return codOpcao2Polo;
    }

    public void setCodOpcao2Polo(String codOpcao2Polo) {
        this.codOpcao2Polo = codOpcao2Polo;
    }

    public String getNomCompleto() {
        return nomCompleto;
    }

    public void setNomCompleto(String nomCompleto) {
        this.nomCompleto = nomCompleto;
    }

    public String getCodSexo() {
        return codSexo;
    }

    public void setCodSexo(String codSexo) {
        this.codSexo = codSexo;
    }

    public String getNomCracha() {
        return nomCracha;
    }

    public void setNomCracha(String nomCracha) {
        this.nomCracha = nomCracha;
    }

    public String getDscEnderecoMoradia() {
        return dscEnderecoMoradia;
    }

    public void setDscEnderecoMoradia(String dscEnderecoMoradia) {
        this.dscEnderecoMoradia = dscEnderecoMoradia;
    }

    public String getDscComplementoMoradia() {
        return dscComplementoMoradia;
    }

    public void setDscComplementoMoradia(String dscComplementoMoradia) {
        this.dscComplementoMoradia = dscComplementoMoradia;
    }

    public String getNomBairroMoradia() {
        return nomBairroMoradia;
    }

    public void setNomBairroMoradia(String nomBairroMoradia) {
        this.nomBairroMoradia = nomBairroMoradia;
    }

    public String getCodCepMoradia() {
        return codCepMoradia;
    }

    public void setCodCepMoradia(String codCepMoradia) {
        this.codCepMoradia = codCepMoradia;
    }

    public String getNomCidadeMoradia() {
        return nomCidadeMoradia;
    }

    public void setNomCidadeMoradia(String nomCidadeMoradia) {
        this.nomCidadeMoradia = nomCidadeMoradia;
    }

    public String getSigUfMoradia() {
        return sigUfMoradia;
    }

    public void setSigUfMoradia(String sigUfMoradia) {
        this.sigUfMoradia = sigUfMoradia;
    }

    public String getCodTipoContato1() {
        return codTipoContato1;
    }

    public void setCodTipoContato1(String codTipoContato1) {
        this.codTipoContato1 = codTipoContato1;
    }

    public String getNumContato1() {
        return numContato1;
    }

    public void setNumContato1(String numContato1) {
        this.numContato1 = numContato1;
    }

    public String getCodTipoContato2() {
        return codTipoContato2;
    }

    public void setCodTipoContato2(String codTipoContato2) {
        this.codTipoContato2 = codTipoContato2;
    }

    public String getNumContato2() {
        return numContato2;
    }

    public void setNumContato2(String numContato2) {
        this.numContato2 = numContato2;
    }

    public String getCodTipoContato3() {
        return codTipoContato3;
    }

    public void setCodTipoContato3(String codTipoContato3) {
        this.codTipoContato3 = codTipoContato3;
    }

    public String getNumContato3() {
        return numContato3;
    }

    public void setNumContato3(String numContato3) {
        this.numContato3 = numContato3;
    }

    public String getDscEmail() {
        return dscEmail;
    }

    public void setDscEmail(String dscEmail) {
        this.dscEmail = dscEmail;
    }

    public String getIndOutraComeerj() {
        return indOutraComeerj;
    }

    public void setIndOutraComeerj(String indOutraComeerj) {
        this.indOutraComeerj = indOutraComeerj;
    }

    public Integer getQtdOutraComeerj() {
        return qtdOutraComeerj;
    }

    public void setQtdOutraComeerj(Integer qtdOutraComeerj) {
        this.qtdOutraComeerj = qtdOutraComeerj;
    }

    public String getIndFazUsoMedicacao() {
        return indFazUsoMedicacao;
    }

    public void setIndFazUsoMedicacao(String indFazUsoMedicacao) {
        this.indFazUsoMedicacao = indFazUsoMedicacao;
    }

    public String getDscListaMedicamento() {
        return dscListaMedicamento;
    }

    public void setDscListaMedicamento(String dscListaMedicamento) {
        this.dscListaMedicamento = dscListaMedicamento;
    }

    public String getIndTemConvenioMedico() {
        return indTemConvenioMedico;
    }

    public void setIndTemConvenioMedico(String indTemConvenioMedico) {
        this.indTemConvenioMedico = indTemConvenioMedico;
    }

    public String getNomConvenioMedico() {
        return nomConvenioMedico;
    }

    public void setNomConvenioMedico(String nomConvenioMedico) {
        this.nomConvenioMedico = nomConvenioMedico;
    }

    public String getIndVegetariano() {
        return indVegetariano;
    }

    public void setIndVegetariano(String indVegetariano) {
        this.indVegetariano = indVegetariano;
    }

    public String getDscListaAlimentacao() {
        return dscListaAlimentacao;
    }

    public void setDscListaAlimentacao(String dscListaAlimentacao) {
        this.dscListaAlimentacao = dscListaAlimentacao;
    }

    public String getIndAlergico() {
        return indAlergico;
    }

    public void setIndAlergico(String indAlergico) {
        this.indAlergico = indAlergico;
    }

    public String getDscListaAlergia() {
        return dscListaAlergia;
    }

    public void setDscListaAlergia(String dscListaAlergia) {
        this.dscListaAlergia = dscListaAlergia;
    }

    public String getNomAutorizacaoMenor() {
        return nomAutorizacaoMenor;
    }

    public void setNomAutorizacaoMenor(String nomAutorizacaoMenor) {
        this.nomAutorizacaoMenor = nomAutorizacaoMenor;
    }

    public String getNumIdentidadeAutorizacaoMenor() {
        return numIdentidadeAutorizacaoMenor;
    }

    public void setNumIdentidadeAutorizacaoMenor(String numIdentidadeAutorizacaoMenor) {
        this.numIdentidadeAutorizacaoMenor = numIdentidadeAutorizacaoMenor;
    }

    public String getNomIeParticipa() {
        return nomIeParticipa;
    }

    public void setNomIeParticipa(String nomIeParticipa) {
        this.nomIeParticipa = nomIeParticipa;
    }

    public String getNumCeuIea() {
        return numCeuIea;
    }

    public void setNumCeuIea(String numCeuIea) {
        this.numCeuIea = numCeuIea;
    }

    public String getDscEnderecoIea() {
        return dscEnderecoIea;
    }

    public void setDscEnderecoIea(String dscEnderecoIea) {
        this.dscEnderecoIea = dscEnderecoIea;
    }

    public String getNomBairroIea() {
        return nomBairroIea;
    }

    public void setNomBairroIea(String nomBairroIea) {
        this.nomBairroIea = nomBairroIea;
    }

    public String getCodCepIea() {
        return codCepIea;
    }

    public void setCodCepIea(String codCepIea) {
        this.codCepIea = codCepIea;
    }

    public String getNomCidadeIea() {
        return nomCidadeIea;
    }

    public void setNomCidadeIea(String nomCidadeIea) {
        this.nomCidadeIea = nomCidadeIea;
    }

    public String getSigUfIea() {
        return sigUfIea;
    }

    public void setSigUfIea(String sigUfIea) {
        this.sigUfIea = sigUfIea;
    }

    public String getCodTipoContatoIea() {
        return codTipoContatoIea;
    }

    public void setCodTipoContatoIea(String codTipoContatoIea) {
        this.codTipoContatoIea = codTipoContatoIea;
    }

    public String getNumContatoIea() {
        return numContatoIea;
    }

    public void setNumContatoIea(String numContatoIea) {
        this.numContatoIea = numContatoIea;
    }

    public String getDscDiaReuniaoJuventude() {
        return dscDiaReuniaoJuventude;
    }

    public void setDscDiaReuniaoJuventude(String dscDiaReuniaoJuventude) {
        this.dscDiaReuniaoJuventude = dscDiaReuniaoJuventude;
    }

    public String getDscHorarioReuniaoJuventude() {
        return dscHorarioReuniaoJuventude;
    }

    public void setDscHorarioReuniaoJuventude(String dscHorarioReuniaoJuventude) {
        this.dscHorarioReuniaoJuventude = dscHorarioReuniaoJuventude;
    }

    public String getCodTipoParticipacaoIea() {
        return codTipoParticipacaoIea;
    }

    public void setCodTipoParticipacaoIea(String codTipoParticipacaoIea) {
        this.codTipoParticipacaoIea = codTipoParticipacaoIea;
    }

    public String getDscOutraParticipacao() {
        return dscOutraParticipacao;
    }

    public void setDscOutraParticipacao(String dscOutraParticipacao) {
        this.dscOutraParticipacao = dscOutraParticipacao;
    }

    public Date getDatCadastramento() {
        return datCadastramento;
    }

    public void setDatCadastramento(Date datCadastramento) {
        this.datCadastramento = datCadastramento;
    }

    public String getIndPagouInscricao() {
        return indPagouInscricao;
    }

    public void setIndPagouInscricao(String indPagouInscricao) {
        this.indPagouInscricao = indPagouInscricao;
    }

    public String getDatPagamentoInscricao() {
        return datPagamentoInscricao;
    }

    public void setDatPagamentoInscricao(String datPagamentoInscricao) {
        this.datPagamentoInscricao = datPagamentoInscricao;
    }

    public String getIndCompareceu() {
        return indCompareceu;
    }

    public void setIndCompareceu(String indCompareceu) {
        this.indCompareceu = indCompareceu;
    }

    public String getNomContato4() {
        return nomContato4;
    }

    public void setNomContato4(String nomContato4) {
        this.nomContato4 = nomContato4;
    }

    public String getNumContato4() {
        return numContato4;
    }

    public void setNumContato4(String numContato4) {
        this.numContato4 = numContato4;
    }

    public String getPwdSenhaCadastro() {
        return pwdSenhaCadastro;
    }

    public void setPwdSenhaCadastro(String pwdSenhaCadastro) {
        this.pwdSenhaCadastro = pwdSenhaCadastro;
    }

    public String getNomFilhoInscritoPolo() {
        return nomFilhoInscritoPolo;
    }

    public void setNomFilhoInscritoPolo(String nomFilhoInscritoPolo) {
        this.nomFilhoInscritoPolo = nomFilhoInscritoPolo;
    }

    public String getNumTelConvenioMedico() {
        return numTelConvenioMedico;
    }

    public void setNumTelConvenioMedico(String numTelConvenioMedico) {
        this.numTelConvenioMedico = numTelConvenioMedico;
    }

    public String getCodStatusFichaInscricao() {
        return codStatusFichaInscricao;
    }

    public void setCodStatusFichaInscricao(String codStatusFichaInscricao) {
        this.codStatusFichaInscricao = codStatusFichaInscricao;
    }

    public String getNomOutraCidadeMoradia() {
        return nomOutraCidadeMoradia;
    }

    public void setNomOutraCidadeMoradia(String nomOutraCidadeMoradia) {
        this.nomOutraCidadeMoradia = nomOutraCidadeMoradia;
    }

    public String getNomOutraCidadeIea() {
        return nomOutraCidadeIea;
    }

    public void setNomOutraCidadeIea(String nomOutraCidadeIea) {
        this.nomOutraCidadeIea = nomOutraCidadeIea;
    }

    public String getIndicImportouDados() {
        return indicImportouDados;
    }

    public void setIndicImportouDados(String indicImportouDados) {
        this.indicImportouDados = indicImportouDados;
    }

    public String getIndicPortadorNEspecial() {
        return indicPortadorNEspecial;
    }

    public void setIndicPortadorNEspecial(String indicPortadorNEspecial) {
        this.indicPortadorNEspecial = indicPortadorNEspecial;
    }

    public String getDscObservacaoNEspecial() {
        return dscObservacaoNEspecial;
    }

    public void setDscObservacaoNEspecial(String dscObservacaoNEspecial) {
        this.dscObservacaoNEspecial = dscObservacaoNEspecial;
    }

    public String getIndicTemRespPeqCompanheiro() {
        return indicTemRespPeqCompanheiro;
    }

    public void setIndicTemRespPeqCompanheiro(String indicTemRespPeqCompanheiro) {
        this.indicTemRespPeqCompanheiro = indicTemRespPeqCompanheiro;
    }

    public Integer getNumInscricaoRespPeqCompanheiro() {
        return numInscricaoRespPeqCompanheiro;
    }

    public void setNumInscricaoRespPeqCompanheiro(Integer numInscricaoRespPeqCompanheiro) {
        this.numInscricaoRespPeqCompanheiro = numInscricaoRespPeqCompanheiro;
    }

    public Integer getNumInscricaoConjuge() {
        return numInscricaoConjuge;
    }

    public void setNumInscricaoConjuge(Integer numInscricaoConjuge) {
        this.numInscricaoConjuge = numInscricaoConjuge;
    }

    public String getDscHabilidades() {
        return dscHabilidades;
    }

    public void setDscHabilidades(String dscHabilidades) {
        this.dscHabilidades = dscHabilidades;
    }

    public String getIndicTemConjuge() {
        return indicTemConjuge;
    }

    public void setIndicTemConjuge(String indicTemConjuge) {
        this.indicTemConjuge = indicTemConjuge;
    }

    public String getCodEstadoCivil() {
        return codEstadoCivil;
    }

    public void setCodEstadoCivil(String codEstadoCivil) {
        this.codEstadoCivil = codEstadoCivil;
    }

    public String getDscEmailCoordenador() {
        return dscEmailCoordenador;
    }

    public void setDscEmailCoordenador(String dscEmailCoordenador) {
        this.dscEmailCoordenador = dscEmailCoordenador;
    }

    public String getIndicPortadorNEduEspecial() {
        return indicPortadorNEduEspecial;
    }

    public void setIndicPortadorNEduEspecial(String indicPortadorNEduEspecial) {
        this.indicPortadorNEduEspecial = indicPortadorNEduEspecial;
    }

    public String getDscObservacaoNEduEspecial() {
        return dscObservacaoNEduEspecial;
    }

    public void setDscObservacaoNEduEspecial(String dscObservacaoNEduEspecial) {
        this.dscObservacaoNEduEspecial = dscObservacaoNEduEspecial;
    }

    @XmlTransient
    public List<DadosEquipe> getDadosEquipeList() {
        return dadosEquipeList;
    }

    public void setDadosEquipeList(List<DadosEquipe> dadosEquipeList) {
        this.dadosEquipeList = dadosEquipeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFichaInscricaoComeerjId != null ? codFichaInscricaoComeerjId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comeerj)) {
            return false;
        }
        Comeerj other = (Comeerj) object;
        if ((this.codFichaInscricaoComeerjId == null && other.codFichaInscricaoComeerjId != null) || (this.codFichaInscricaoComeerjId != null && !this.codFichaInscricaoComeerjId.equals(other.codFichaInscricaoComeerjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.Comeerj[ codFichaInscricaoComeerjId=" + codFichaInscricaoComeerjId + " ]";
    }

    @XmlTransient
    public List<AlojamentoMembros> getAlojamentoMembrosList() {
        return alojamentoMembrosList;
    }

    public void setAlojamentoMembrosList(List<AlojamentoMembros> alojamentoMembrosList) {
        this.alojamentoMembrosList = alojamentoMembrosList;
    }

    @XmlTransient
    public List<AlojamentoCoordenador> getAlojamentoCoordenadorList() {
        return alojamentoCoordenadorList;
    }

    public void setAlojamentoCoordenadorList(List<AlojamentoCoordenador> alojamentoCoordenadorList) {
        this.alojamentoCoordenadorList = alojamentoCoordenadorList;
    }

    @XmlTransient
    public List<TurmaAlunos> getTurmaAlunosList() {
        return turmaAlunosList;
    }

    public void setTurmaAlunosList(List<TurmaAlunos> turmaAlunosList) {
        this.turmaAlunosList = turmaAlunosList;
    }
    
}
