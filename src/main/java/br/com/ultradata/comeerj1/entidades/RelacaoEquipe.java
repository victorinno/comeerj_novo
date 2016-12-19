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
@Table(name = "relacao_equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacaoEquipe.findAll", query = "SELECT r FROM RelacaoEquipe r"),
    @NamedQuery(name = "RelacaoEquipe.findByIdRelacaoEquipe", query = "SELECT r FROM RelacaoEquipe r WHERE r.idRelacaoEquipe = :idRelacaoEquipe"),
    @NamedQuery(name = "RelacaoEquipe.findByCoordenador", query = "SELECT r FROM RelacaoEquipe r WHERE r.coordenador = :coordenador")})
public class RelacaoEquipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idRelacaoEquipe;
    private Boolean coordenador;
    @JoinColumn(name = "idEquipe", referencedColumnName = "idequipe")
    @ManyToOne
    private Equipe idEquipe;
    @JoinColumn(name = "idRelacao", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Relacao idRelacao;

    public RelacaoEquipe() {
    }

    public RelacaoEquipe(Integer idRelacaoEquipe) {
        this.idRelacaoEquipe = idRelacaoEquipe;
    }

    public Integer getIdRelacaoEquipe() {
        return idRelacaoEquipe;
    }

    public void setIdRelacaoEquipe(Integer idRelacaoEquipe) {
        this.idRelacaoEquipe = idRelacaoEquipe;
    }

    public Boolean getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Boolean coordenador) {
        this.coordenador = coordenador;
    }

    public Equipe getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Equipe idEquipe) {
        this.idEquipe = idEquipe;
    }

    public Relacao getIdRelacao() {
        return idRelacao;
    }

    public void setIdRelacao(Relacao idRelacao) {
        this.idRelacao = idRelacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRelacaoEquipe != null ? idRelacaoEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacaoEquipe)) {
            return false;
        }
        RelacaoEquipe other = (RelacaoEquipe) object;
        if ((this.idRelacaoEquipe == null && other.idRelacaoEquipe != null) || (this.idRelacaoEquipe != null && !this.idRelacaoEquipe.equals(other.idRelacaoEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.ultradata.comeerj1.entidades.RelacaoEquipe[ idRelacaoEquipe=" + idRelacaoEquipe + " ]";
    }
    
}
