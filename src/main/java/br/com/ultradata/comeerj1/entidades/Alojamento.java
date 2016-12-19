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
    @NamedQuery(name = "Alojamento.findAll", query = "SELECT a FROM Alojamento a"),
    @NamedQuery(name = "Alojamento.findByIdAlojamento", query = "SELECT a FROM Alojamento a WHERE a.idAlojamento = :idAlojamento"),
    @NamedQuery(name = "Alojamento.findByNomeAlojamento", query = "SELECT a FROM Alojamento a WHERE a.nomeAlojamento = :nomeAlojamento"),
    @NamedQuery(name = "Alojamento.findBySala", query = "SELECT a FROM Alojamento a WHERE a.sala = :sala")})
public class Alojamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idAlojamento;
    @Size(max = 100)
    private String nomeAlojamento;
    @Size(max = 45)
    private String sala;
    @OneToMany(mappedBy = "idAlojamento", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<RelacaoAlojamento> relacaoAlojamentoList;

    public Alojamento() {
    }

    public Alojamento(Integer idAlojamento) {
        this.idAlojamento = idAlojamento;
    }

    public Integer getIdAlojamento() {
        return idAlojamento;
    }

    public void setIdAlojamento(Integer idAlojamento) {
        this.idAlojamento = idAlojamento;
    }

    public String getNomeAlojamento() {
        return nomeAlojamento;
    }

    public void setNomeAlojamento(String nomeAlojamento) {
        this.nomeAlojamento = nomeAlojamento;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @XmlTransient
    public List<RelacaoAlojamento> getRelacaoAlojamentoList() {
        return relacaoAlojamentoList;
    }

    public void setRelacaoAlojamentoList(List<RelacaoAlojamento> relacaoAlojamentoList) {
        this.relacaoAlojamentoList = relacaoAlojamentoList;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash += 67 * hash + Objects.hashCode(this.nomeAlojamento);
        hash += 67 * hash + Objects.hashCode(this.sala);
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
        final Alojamento other = (Alojamento) obj;
        if (!Objects.equals(this.nomeAlojamento, other.nomeAlojamento)) {
            return false;
        }
        if (!Objects.equals(this.sala, other.sala)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return nomeAlojamento;
    }

}
