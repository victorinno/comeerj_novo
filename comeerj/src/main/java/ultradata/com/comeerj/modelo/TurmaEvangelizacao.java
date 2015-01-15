/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author floriano.peixoto
 */
@Entity
@Table(name = "turma_evangelizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaEvangelizacao.findAll", query = "SELECT t FROM TurmaEvangelizacao t"),
    @NamedQuery(name = "TurmaEvangelizacao.findByIdturmaEvangelizacao", query = "SELECT t FROM TurmaEvangelizacao t WHERE t.idturmaEvangelizacao = :idturmaEvangelizacao"),
    @NamedQuery(name = "TurmaEvangelizacao.findByFaixa", query = "SELECT t FROM TurmaEvangelizacao t WHERE t.faixa = :faixa"),
    @NamedQuery(name = "TurmaEvangelizacao.findByNome", query = "SELECT t FROM TurmaEvangelizacao t WHERE t.nome = :nome")})
public class TurmaEvangelizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturma_evangelizacao")
    private Integer idturmaEvangelizacao;
    @Size(max = 255)
    @Column(name = "faixa")
    private String faixa;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "turma")
    private List<TurmaAlunos> turmaAlunosList;

    public TurmaEvangelizacao() {
    }

    public TurmaEvangelizacao(Integer idturmaEvangelizacao) {
        this.idturmaEvangelizacao = idturmaEvangelizacao;
    }

    public Integer getIdturmaEvangelizacao() {
        return idturmaEvangelizacao;
    }

    public void setIdturmaEvangelizacao(Integer idturmaEvangelizacao) {
        this.idturmaEvangelizacao = idturmaEvangelizacao;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<TurmaAlunos> getTurmaAlunosList() {
        return turmaAlunosList;
    }

    public void setTurmaAlunosList(List<TurmaAlunos> turmaAlunosList) {
        this.turmaAlunosList = turmaAlunosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturmaEvangelizacao != null ? idturmaEvangelizacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmaEvangelizacao)) {
            return false;
        }
        TurmaEvangelizacao other = (TurmaEvangelizacao) object;
        if ((this.idturmaEvangelizacao == null && other.idturmaEvangelizacao != null) || (this.idturmaEvangelizacao != null && !this.idturmaEvangelizacao.equals(other.idturmaEvangelizacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.TurmaEvangelizacao[ idturmaEvangelizacao=" + idturmaEvangelizacao + " ]";
    }
    
}
