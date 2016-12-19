/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
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
 * @author Victor
 */
@Entity
@Table(name = "turma_evangelizandos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaEvangelizandos.findAll",
                query = "SELECT t FROM TurmaEvangelizandos t"),
    @NamedQuery(name = "TurmaEvangelizandos.findByIdTurmaEvangelizandos",
                query = "SELECT t FROM TurmaEvangelizandos t WHERE t.idTurmaEvangelizandos = :idTurmaEvangelizandos")})
public class TurmaEvangelizandos
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTurmaEvangelizandos;

    @JoinColumn(name = "idRelacao",
                referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Relacao idRelacao;

    @JoinColumn(name = "idTurma",
                referencedColumnName = "idTurma")
    @ManyToOne
    private Turma idTurma;

    public TurmaEvangelizandos() {
    }

    public TurmaEvangelizandos(Integer idTurmaEvangelizandos) {
        this.idTurmaEvangelizandos = idTurmaEvangelizandos;
    }

    public Integer getIdTurmaEvangelizandos() {
        return idTurmaEvangelizandos;
    }

    public void setIdTurmaEvangelizandos(Integer idTurmaEvangelizandos) {
        this.idTurmaEvangelizandos = idTurmaEvangelizandos;
    }

    public Relacao getIdRelacao() {
        return idRelacao;
    }

    public void setIdRelacao(Relacao idRelacao) {
        this.idRelacao = idRelacao;
    }

    public Turma getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Turma idTurma) {
        this.idTurma = idTurma;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 83 * hash + Objects.hashCode(this.idRelacao);
        hash += 83 * hash + Objects.hashCode(this.idTurma);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TurmaEvangelizandos other = (TurmaEvangelizandos) obj;
        if (!Objects.equals(this.idRelacao, other.idRelacao)) {
            return false;
        }
        if (!Objects.equals(this.idTurma, other.idTurma)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ultradata.comeerj1.entidades.TurmaEvangelizandos[ idTurmaEvangelizandos=" + idTurmaEvangelizandos + " ]";
    }

}
