/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Victor
 */
@Entity
@Table(name = "relacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relacao.findAll",
                query = "SELECT r FROM Relacao r"),
    @NamedQuery(name = "Relacao.findByCodFichaInscricaoComeerjId",
                query = "SELECT r FROM Relacao r WHERE r.codFichaInscricaoComeerjId = :codFichaInscricaoComeerjId"),
    @NamedQuery(name = "Relacao.findByNumComeerj",
                query = "SELECT r FROM Relacao r WHERE r.numComeerj = :numComeerj"),
    @NamedQuery(name = "Relacao.findByNumFichaInscricao",
                query = "SELECT r FROM Relacao r WHERE r.numFichaInscricao = :numFichaInscricao"),
    @NamedQuery(name = "Relacao.findByQtdOutraComeerj",
                query = "SELECT r FROM Relacao r WHERE r.qtdOutraComeerj = :qtdOutraComeerj")})
public class Relacao implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    private Long codFichaInscricaoComeerjId;

    @Column(name = "NUM_COMEERJ")
    private BigInteger numComeerj;

    @Column(name = "NUM_FICHA_INSCRICAO")
    private BigInteger numFichaInscricao;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_TIPO_PARTICIPACAO")
    private String dscTipoParticipacao;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_TIPO_COMISSAO")
    private String dscTipoComissao;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_NOME")
    private String dscNome;

    @Lob
    @Size(max = 255)
    @Column(name = "DAT_NASCIMENTO")
    private String datNascimento;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_PROFISSAO")
    private String dscProfissao;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_OPCAO_1_POLO")
    private String codOpcao1Polo;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_OPCAO_2_POLO")
    private String codOpcao2Polo;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_SEXO")
    private String codSexo;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_CRACHA")
    private String nomCracha;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_ENDERECO_MORADIA")
    private String dscEnderecoMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_COMPLEMENTO_MORADIA")
    private String dscComplementoMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_BAIRRO_MORADIA")
    private String nomBairroMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_CEP_MORADIA")
    private String codCepMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_CIDADE_MORADIA")
    private String nomCidadeMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "SIG_UF_MORADIA")
    private String sigUfMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_TIPO_CONTATO_1")
    private String codTipoContato1;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CONTATO_1")
    private String numContato1;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_TIPO_CONTATO_2")
    private String codTipoContato2;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CONTATO_2")
    private String numContato2;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_TIPO_CONTATO_3")
    private String codTipoContato3;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CONTATO_3")
    private String numContato3;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_EMAIL")
    private String dscEmail;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_OUTRA_COMEERJ")
    private String indOutraComeerj;

    @Column(name = "QTD_OUTRA_COMEERJ")
    private BigInteger qtdOutraComeerj;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_FAZ_USO_MEDICACAO")
    private String indFazUsoMedicacao;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_LISTA_MEDICAMENTO")
    private String dscListaMedicamento;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_TEM_CONVENIO_MEDICO")
    private String indTemConvenioMedico;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_CONVENIO_MEDICO")
    private String nomConvenioMedico;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_VEGETARIANO")
    private String indVegetariano;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_LISTA_ALIMENTACAO")
    private String dscListaAlimentacao;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_ALERGICO")
    private String indAlergico;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_LISTA_ALERGIA")
    private String dscListaAlergia;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_AUTORIZACAO_MENOR")
    private String nomAutorizacaoMenor;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_IDENTIDADE_AUTORIZACAO_MENOR")
    private String numIdentidadeAutorizacaoMenor;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_IE_PARTICIPA")
    private String nomIeParticipa;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CEU_IEA")
    private String numCeuIea;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_ENDERECO_IEA")
    private String dscEnderecoIea;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_BAIRRO_IEA")
    private String nomBairroIea;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_CEP_IEA")
    private String codCepIea;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_CIDADE_IEA")
    private String nomCidadeIea;

    @Lob
    @Size(max = 255)
    @Column(name = "SIG_UF_IEA")
    private String sigUfIea;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_TIPO_CONTATO_IEA")
    private String codTipoContatoIea;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CONTATO_IEA")
    private String numContatoIea;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_DIA_REUNIAO_JUVENTUDE")
    private String dscDiaReuniaoJuventude;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_HORARIO_REUNIAO_JUVENTUDE")
    private String dscHorarioReuniaoJuventude;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_TIPO_PARTICIPACAO_IEA")
    private String codTipoParticipacaoIea;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_OUTRA_PARTICIPACAO")
    private String dscOutraParticipacao;

    @Lob
    @Size(max = 255)
    @Column(name = "DAT_CADASTRAMENTO")
    private String datCadastramento;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_PAGOU_INSCRICAO")
    private String indPagouInscricao;

    @Lob
    @Size(max = 255)
    @Column(name = "DAT_PAGAMENTO_INSCRICAO")
    private String datPagamentoInscricao;

    @Lob
    @Size(max = 255)
    @Column(name = "IND_COMPARECEU")
    private String indCompareceu;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_CONTATO_4")
    private String nomContato4;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_CONTATO_4")
    private String numContato4;

    @Lob
    @Size(max = 255)
    @Column(name = "PWD_SENHA_CADASTRO")
    private String pwdSenhaCadastro;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_FILHO_INSCRITO_POLO")
    private String nomFilhoInscritoPolo;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_TEL_CONVENIO_MEDICO")
    private String numTelConvenioMedico;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_STATUS_FICHA_INSCRICAO")
    private String codStatusFichaInscricao;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_OUTRA_CIDADE_MORADIA")
    private String nomOutraCidadeMoradia;

    @Lob
    @Size(max = 255)
    @Column(name = "NOM_OUTRA_CIDADE_IEA")
    private String nomOutraCidadeIea;

    @Lob
    @Size(max = 255)
    @Column(name = "INDIC_IMPORTOU_DADOS")
    private String indicImportouDados;

    @Lob
    @Size(max = 255)
    @Column(name = "INDIC_PORTADOR_N_ESPECIAL")
    private String indicPortadorNEspecial;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_OBSERVACAO_N_ESPECIAL")
    private String dscObservacaoNEspecial;

    @Lob
    @Size(max = 255)
    @Column(name = "INDIC_TEM_RESP_PEQ_COMPANHEIRO")
    private String indicTemRespPeqCompanheiro;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_INSCRICAO_RESP_PEQ_COMPANHEIRO")
    private String numInscricaoRespPeqCompanheiro;

    @Lob
    @Size(max = 255)
    @Column(name = "NUM_INSCRICAO_CONJUGE")
    private String numInscricaoConjuge;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_HABILIDADES")
    private String dscHabilidades;

    @Lob
    @Size(max = 255)
    @Column(name = "INDIC_TEM_CONJUGE")
    private String indicTemConjuge;

    @Lob
    @Size(max = 255)
    @Column(name = "COD_ESTADO_CIVIL")
    private String codEstadoCivil;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_EMAIL_COORDENADOR")
    private String dscEmailCoordenador;

    @Lob
    @Size(max = 255)
    @Column(name = "INDIC_PORTADOR_N_EDU_ESPECIAL")
    private String indicPortadorNEduEspecial;

    @Lob
    @Size(max = 255)
    @Column(name = "DSC_OBSERVACAO_N_EDU_ESPECIAL")
    private String dscObservacaoNEduEspecial;

    @Lob
    @Size(max = 255)
    @Column(name = "IDADE")
    private String idade;

    @Lob
    @Size(max = 255)
    @Column(name = "FAIXA")
    private String faixa;

    public Relacao() {
    }

    public Relacao(Long codFichaInscricaoComeerjId) {
        this.codFichaInscricaoComeerjId = codFichaInscricaoComeerjId;
    }

    public Long getCodFichaInscricaoComeerjId() {
        return codFichaInscricaoComeerjId;
    }

    public void setCodFichaInscricaoComeerjId(Long codFichaInscricaoComeerjId) {
        this.codFichaInscricaoComeerjId = codFichaInscricaoComeerjId;
    }

    public BigInteger getNumComeerj() {
        return numComeerj;
    }

    public void setNumComeerj(BigInteger numComeerj) {
        this.numComeerj = numComeerj;
    }

    public BigInteger getNumFichaInscricao() {
        return numFichaInscricao;
    }

    public void setNumFichaInscricao(BigInteger numFichaInscricao) {
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

    public String getDscNome() {
        return dscNome;
    }

    public void setDscNome(String dscNome) {
        this.dscNome = dscNome;
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

    public BigInteger getQtdOutraComeerj() {
        return qtdOutraComeerj;
    }

    public void setQtdOutraComeerj(BigInteger qtdOutraComeerj) {
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

    public String getDatCadastramento() {
        return datCadastramento;
    }

    public void setDatCadastramento(String datCadastramento) {
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

    public String getNumInscricaoRespPeqCompanheiro() {
        return numInscricaoRespPeqCompanheiro;
    }

    public void setNumInscricaoRespPeqCompanheiro(String numInscricaoRespPeqCompanheiro) {
        this.numInscricaoRespPeqCompanheiro = numInscricaoRespPeqCompanheiro;
    }

    public String getNumInscricaoConjuge() {
        return numInscricaoConjuge;
    }

    public void setNumInscricaoConjuge(String numInscricaoConjuge) {
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
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
        if (!(object instanceof Relacao)) {
            return false;
        }
        Relacao other = (Relacao) object;
        if ((this.codFichaInscricaoComeerjId == null && other.codFichaInscricaoComeerjId != null) 
            || (this.codFichaInscricaoComeerjId != null 
                && !this.codFichaInscricaoComeerjId.equals(other.codFichaInscricaoComeerjId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ultradata.comeerj1.entidades.Relacao[ codFichaInscricaoComeerjId=" + codFichaInscricaoComeerjId + " ]";
    }
    
}
