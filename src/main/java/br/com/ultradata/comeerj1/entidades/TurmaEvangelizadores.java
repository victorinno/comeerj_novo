/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
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
@Table(name = "turma_evangelizadores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TurmaEvangelizadores.findAll", query = "SELECT t FROM TurmaEvangelizadores t"),
    @NamedQuery(name = "TurmaEvangelizadores.findByIdTurmaEvangelizadores", query = "SELECT t FROM TurmaEvangelizadores t WHERE t.idTurmaEvangelizadores = :idTurmaEvangelizadores")})
public class TurmaEvangelizadores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTurmaEvangelizadores;
    @JoinColumn(name = "idRelacao", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Relacao idRelacao;
    @JoinColumn(name = "idTurma", referencedColumnName = "idTurma")
    @ManyToOne
    private Turma idTurma;

    public TurmaEvangelizadores() {
    }

    public TurmaEvangelizadores(Integer idTurmaEvangelizadores) {
        this.idTurmaEvangelizadores = idTurmaEvangelizadores;
    }

    public Integer getIdTurmaEvangelizadores() {
        return idTurmaEvangelizadores;
    }

    public void setIdTurmaEvangelizadores(Integer idTurmaEvangelizadores) {
        this.idTurmaEvangelizadores = idTurmaEvangelizadores;
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
        int hash = 0;
        hash += (idTurmaEvangelizadores != null ? idTurmaEvangelizadores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TurmaEvangelizadores)) {
            return false;
        }
        TurmaEvangelizadores other = (TurmaEvangelizadores) object;
        if ((this.idTurmaEvangelizadores == null && other.idTurmaEvangelizadores != null) || (this.idTurmaEvangelizadores != null && !this.idTurmaEvangelizadores.equals(other.idTurmaEvangelizadores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ultradata.comeerj1.entidades.TurmaEvangelizadores[ idTurmaEvangelizadores=" + idTurmaEvangelizadores + " ]";
    }
    
}
