/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.entidades;

import java.io.Serializable;
import java.util.Optional;
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
@Table(name = "relacao_alojamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelacaoAlojamento.findAll",
                query = "SELECT r FROM RelacaoAlojamento r"),
    @NamedQuery(name = "RelacaoAlojamento.findByIdRelacaoAlojamento",
                query = "SELECT r FROM RelacaoAlojamento r WHERE r.idRelacaoAlojamento = :idRelacaoAlojamento"),
    @NamedQuery(name = "RelacaoAlojamento.findByIndice",
                query = "SELECT r FROM RelacaoAlojamento r WHERE r.indice = :indice"),
@NamedQuery(name = "RelacaoAlojamento.findByUK",
                query = "SELECT r FROM RelacaoAlojamento r WHERE r.idRelacao.codFichaInscricaoComeerjId = :relacao and r.idAlojamento.idAlojamento = :alojamento")})
public class RelacaoAlojamento
        implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idRelacaoAlojamento;

    private Integer indice;

    @JoinColumn(name = "idAlojamento",
                referencedColumnName = "idAlojamento")
    @ManyToOne
    private Alojamento idAlojamento;

    @JoinColumn(name = "idRelacao",
                referencedColumnName = "COD_FICHA_INSCRICAO_COMEERJ_ID")
    @ManyToOne
    private Relacao idRelacao;

    public RelacaoAlojamento() {
    }

    public RelacaoAlojamento(Integer idRelacaoAlojamento) {
        this.idRelacaoAlojamento = idRelacaoAlojamento;
    }

    public Integer getIdRelacaoAlojamento() {
        return idRelacaoAlojamento;
    }

    public void setIdRelacaoAlojamento(Integer idRelacaoAlojamento) {
        this.idRelacaoAlojamento = idRelacaoAlojamento;
    }

    public Integer getIndice() {
        return indice;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public Alojamento getIdAlojamento() {
        return idAlojamento;
    }

    public void setIdAlojamento(Alojamento idAlojamento) {
        this.idAlojamento = idAlojamento;
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
        int c = 0;
        hash += Optional.ofNullable(idAlojamento).orElse(new Alojamento()).hashCode();
        hash += Optional.ofNullable(idRelacao).orElse(new Relacao()).hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelacaoAlojamento)) {
            return false;
        }
        RelacaoAlojamento other = (RelacaoAlojamento) object;
        final Optional<Alojamento> otherAloj = Optional.ofNullable(other.idAlojamento);
        final Optional<Relacao> otherRel = Optional.ofNullable(other.idRelacao);
        final Optional<Alojamento> aloj = Optional.ofNullable(this.idAlojamento);
        final Optional<Relacao> rel = Optional.ofNullable(this.idRelacao);
        return otherAloj.equals(aloj) && otherRel.equals(rel);
    }

    @Override
    public String toString() {
        return idRelacao + " | " + indice + " - " + idRelacao;
    }

}
