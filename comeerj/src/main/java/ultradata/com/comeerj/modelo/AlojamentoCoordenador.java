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
@Table(name = "alojamento_coordenador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlojamentoCoordenador.findAll", query = "SELECT a FROM AlojamentoCoordenador a"),
    @NamedQuery(name = "AlojamentoCoordenador.findByIdalojamentoCoordenador", query = "SELECT a FROM AlojamentoCoordenador a WHERE a.idalojamentoCoordenador = :idalojamentoCoordenador")})
public class AlojamentoCoordenador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalojamento_coordenador")
    private Integer idalojamentoCoordenador;
    @JoinColumn(name = "coordenador", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Comeerj coordenador;
    @JoinColumn(name = "alojamento", referencedColumnName = "idalojamento")
    @ManyToOne
    private Alojamento alojamento;

    public AlojamentoCoordenador() {
    }

    public AlojamentoCoordenador(Integer idalojamentoCoordenador) {
        this.idalojamentoCoordenador = idalojamentoCoordenador;
    }

    public Integer getIdalojamentoCoordenador() {
        return idalojamentoCoordenador;
    }

    public void setIdalojamentoCoordenador(Integer idalojamentoCoordenador) {
        this.idalojamentoCoordenador = idalojamentoCoordenador;
    }

    public Comeerj getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Comeerj coordenador) {
        this.coordenador = coordenador;
    }

    public Alojamento getAlojamento() {
        return alojamento;
    }

    public void setAlojamento(Alojamento alojamento) {
        this.alojamento = alojamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalojamentoCoordenador != null ? idalojamentoCoordenador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlojamentoCoordenador)) {
            return false;
        }
        AlojamentoCoordenador other = (AlojamentoCoordenador) object;
        if ((this.idalojamentoCoordenador == null && other.idalojamentoCoordenador != null) || (this.idalojamentoCoordenador != null && !this.idalojamentoCoordenador.equals(other.idalojamentoCoordenador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.AlojamentoCoordenador[ idalojamentoCoordenador=" + idalojamentoCoordenador + " ]";
    }
    
}
