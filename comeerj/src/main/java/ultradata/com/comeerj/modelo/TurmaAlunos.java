/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author floriano.peixoto
 */
@Entity
@Table(name = "turma_alunos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaAlunos.findAll", query = "SELECT t FROM TurmaAlunos t"),
    @NamedQuery(name = "TurmaAlunos.findByIdturmaAlunos", query = "SELECT t FROM TurmaAlunos t WHERE t.idturmaAlunos = :idturmaAlunos")})
public class TurmaAlunos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idturma_alunos")
    private Integer idturmaAlunos;
    @JoinColumn(name = "turma", referencedColumnName = "idturma_evangelizacao")
    @ManyToOne
    private TurmaEvangelizacao turma;
    @JoinColumn(name = "aluno", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Comeerj aluno;

    public TurmaAlunos() {
    }

    public TurmaAlunos(Integer idturmaAlunos) {
        this.idturmaAlunos = idturmaAlunos;
    }

    public Integer getIdturmaAlunos() {
        return idturmaAlunos;
    }

    public void setIdturmaAlunos(Integer idturmaAlunos) {
        this.idturmaAlunos = idturmaAlunos;
    }

    public TurmaEvangelizacao getTurma() {
        return turma;
    }

    public void setTurma(TurmaEvangelizacao turma) {
        this.turma = turma;
    }

    public Comeerj getAluno() {
        return aluno;
    }

    public void setAluno(Comeerj aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idturmaAlunos != null ? idturmaAlunos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmaAlunos)) {
            return false;
        }
        TurmaAlunos other = (TurmaAlunos) object;
        if ((this.idturmaAlunos == null && other.idturmaAlunos != null) || (this.idturmaAlunos != null && !this.idturmaAlunos.equals(other.idturmaAlunos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.TurmaAlunos[ idturmaAlunos=" + idturmaAlunos + " ]";
    }
    
}
