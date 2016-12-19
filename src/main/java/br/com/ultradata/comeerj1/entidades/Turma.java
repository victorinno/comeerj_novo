/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Victor
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll",
                query = "SELECT t FROM Turma t"),
    @NamedQuery(name = "Turma.findByIdTurma",
                query = "SELECT t FROM Turma t WHERE t.idTurma = :idTurma"),
    @NamedQuery(name = "Turma.findByNome",
                query = "SELECT t FROM Turma t WHERE t.nome = :nome"),
    @NamedQuery(name = "Turma.findByFaixa",
                query = "SELECT t FROM Turma t WHERE t.faixa = :faixa")})
public class Turma
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idTurma;

    @Size(max = 255)
    private String nome;

    @Size(max = 255)
    private String faixa;

    @OneToMany(mappedBy = "idTurma",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private List<TurmaEvangelizadores> turmaEvangelizadoresList;

    @OneToMany(mappedBy = "idTurma",
               cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private List<TurmaEvangelizandos> turmaEvangelizandosList;

    public Turma() {
    }

    public Turma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public Integer getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(Integer idTurma) {
        this.idTurma = idTurma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    @XmlTransient
    public List<TurmaEvangelizadores> getTurmaEvangelizadoresList() {
        return turmaEvangelizadoresList;
    }

    public void setTurmaEvangelizadoresList(List<TurmaEvangelizadores> turmaEvangelizadoresList) {
        this.turmaEvangelizadoresList = turmaEvangelizadoresList;
    }

    @XmlTransient
    public List<TurmaEvangelizandos> getTurmaEvangelizandosList() {
        return turmaEvangelizandosList;
    }

    public void setTurmaEvangelizandosList(List<TurmaEvangelizandos> turmaEvangelizandosList) {
        this.turmaEvangelizandosList = turmaEvangelizandosList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 37 * hash + Objects.hashCode(this.nome);
        hash += 37 * hash + Objects.hashCode(this.faixa);
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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.faixa, other.faixa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }

}
