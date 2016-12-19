/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
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
    @NamedQuery(name = "Equipe.findAll", query = "SELECT e FROM Equipe e"),
    @NamedQuery(name = "Equipe.findByIdequipe", query = "SELECT e FROM Equipe e WHERE e.idequipe = :idequipe"),
    @NamedQuery(name = "Equipe.findByNome", query = "SELECT e FROM Equipe e WHERE e.nome = :nome")})
public class Equipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idequipe;
    @Size(max = 255)
    private String nome;
    @OneToMany(mappedBy = "idEquipe")
    private List<RelacaoEquipe> relacaoEquipeList;

    public Equipe() {
    }

    public Equipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public Integer getIdequipe() {
        return idequipe;
    }

    public void setIdequipe(Integer idequipe) {
        this.idequipe = idequipe;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public List<RelacaoEquipe> getRelacaoEquipeList() {
        return relacaoEquipeList;
    }

    public void setRelacaoEquipeList(List<RelacaoEquipe> relacaoEquipeList) {
        this.relacaoEquipeList = relacaoEquipeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idequipe != null ? idequipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipe)) {
            return false;
        }
        Equipe other = (Equipe) object;
        if ((this.idequipe == null && other.idequipe != null) || (this.idequipe != null && !this.idequipe.equals(other.idequipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Equipe{" + "nome=" + nome + '}';
    }

}
