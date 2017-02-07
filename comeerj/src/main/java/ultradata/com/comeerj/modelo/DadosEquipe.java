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
@Table(name = "dados_equipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DadosEquipe.findAll", query = "SELECT d FROM DadosEquipe d"),
    @NamedQuery(name = "DadosEquipe.findByIddadosEquipe", query = "SELECT d FROM DadosEquipe d WHERE d.iddadosEquipe = :iddadosEquipe")})
public class DadosEquipe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddados_equipe")
    private Integer iddadosEquipe;
    @JoinColumn(name = "equipe", referencedColumnName = "idequipe")
    @ManyToOne
    private Equipe equipe;
    @JoinColumn(name = "dados", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Comeerj dados;

    public DadosEquipe() {
    }

    public DadosEquipe(Integer iddadosEquipe) {
        this.iddadosEquipe = iddadosEquipe;
    }

    public Integer getIddadosEquipe() {
        return iddadosEquipe;
    }

    public void setIddadosEquipe(Integer iddadosEquipe) {
        this.iddadosEquipe = iddadosEquipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Comeerj getDados() {
        return dados;
    }

    public void setDados(Comeerj dados) {
        this.dados = dados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddadosEquipe != null ? iddadosEquipe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DadosEquipe)) {
            return false;
        }
        DadosEquipe other = (DadosEquipe) object;
        if ((this.iddadosEquipe == null && other.iddadosEquipe != null) || (this.iddadosEquipe != null && !this.iddadosEquipe.equals(other.iddadosEquipe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.DadosEquipe[ iddadosEquipe=" + iddadosEquipe + " ]";
    }
    
}
