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
@Table(name = "alojamento_membros")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlojamentoMembros.findAll", query = "SELECT a FROM AlojamentoMembros a"),
    @NamedQuery(name = "AlojamentoMembros.findByIdalojamentoMembros", query = "SELECT a FROM AlojamentoMembros a WHERE a.idalojamentoMembros = :idalojamentoMembros")})
public class AlojamentoMembros implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalojamento_membros")
    private Integer idalojamentoMembros;
    @JoinColumn(name = "membro", referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Comeerj membro;
    @JoinColumn(name = "alojamento", referencedColumnName = "idalojamento")
    @ManyToOne
    private Alojamento alojamento;

    public AlojamentoMembros() {
    }

    public AlojamentoMembros(Integer idalojamentoMembros) {
        this.idalojamentoMembros = idalojamentoMembros;
    }

    public Integer getIdalojamentoMembros() {
        return idalojamentoMembros;
    }

    public void setIdalojamentoMembros(Integer idalojamentoMembros) {
        this.idalojamentoMembros = idalojamentoMembros;
    }

    public Comeerj getMembro() {
        return membro;
    }

    public void setMembro(Comeerj membro) {
        this.membro = membro;
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
        hash += (idalojamentoMembros != null ? idalojamentoMembros.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlojamentoMembros)) {
            return false;
        }
        AlojamentoMembros other = (AlojamentoMembros) object;
        if ((this.idalojamentoMembros == null && other.idalojamentoMembros != null) || (this.idalojamentoMembros != null && !this.idalojamentoMembros.equals(other.idalojamentoMembros))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.AlojamentoMembros[ idalojamentoMembros=" + idalojamentoMembros + " ]";
    }
    
}
