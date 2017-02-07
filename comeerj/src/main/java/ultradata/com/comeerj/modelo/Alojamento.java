/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author floriano.peixoto
 */
@Entity
@Table(name = "alojamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alojamento.findAll", query = "SELECT a FROM Alojamento a"),
    @NamedQuery(name = "Alojamento.findByIdalojamento", query = "SELECT a FROM Alojamento a WHERE a.idalojamento = :idalojamento"),
    @NamedQuery(name = "Alojamento.findByNome", query = "SELECT a FROM Alojamento a WHERE a.nome = :nome"),
    @NamedQuery(name = "Alojamento.findBySala", query = "SELECT a FROM Alojamento a WHERE a.sala = :sala")})
public class Alojamento implements Serializable {
    @OneToMany(mappedBy = "alojamento")
    private List<AlojamentoCoordenador> alojamentoCoordenadorList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalojamento")
    private Integer idalojamento;
    @Size(max = 255)
    @Column(name = "nome")
    private String nome;
    @Size(max = 45)
    @Column(name = "sala")
    private String sala;
    @OneToMany(mappedBy = "alojamento")
    private List<AlojamentoMembros> alojamentoMembrosList;

    public Alojamento() {
    }

    public Alojamento(Integer idalojamento) {
        this.idalojamento = idalojamento;
    }

    public Integer getIdalojamento() {
        return idalojamento;
    }

    public void setIdalojamento(Integer idalojamento) {
        this.idalojamento = idalojamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @XmlTransient
    public List<AlojamentoMembros> getAlojamentoMembrosList() {
        return alojamentoMembrosList;
    }

    public void setAlojamentoMembrosList(List<AlojamentoMembros> alojamentoMembrosList) {
        this.alojamentoMembrosList = alojamentoMembrosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalojamento != null ? idalojamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alojamento)) {
            return false;
        }
        Alojamento other = (Alojamento) object;
        if ((this.idalojamento == null && other.idalojamento != null) || (this.idalojamento != null && !this.idalojamento.equals(other.idalojamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ultradata.com.comeerj.modelo.Alojamento[ idalojamento=" + idalojamento + " ]";
    }

    @XmlTransient
    public List<AlojamentoCoordenador> getAlojamentoCoordenadorList() {
        return alojamentoCoordenadorList;
    }

    public void setAlojamentoCoordenadorList(List<AlojamentoCoordenador> alojamentoCoordenadorList) {
        this.alojamentoCoordenadorList = alojamentoCoordenadorList;
    }
    
}
