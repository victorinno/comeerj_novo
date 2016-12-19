/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.beans;

import br.com.ultradata.comeerj1.entidades.RelacaoAlojamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Victor
 */
@Stateless
public class RelacaoAlojamentoFacade
        extends AbstractFacade<RelacaoAlojamento> {

    @PersistenceContext(
            unitName = "br.com.ultradata_comeerj1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RelacaoAlojamentoFacade() {
        super(RelacaoAlojamento.class);
    }

    public RelacaoAlojamento findByUK(Long idRelacao, Integer idAlojamento) {
        Query q = getEntityManager().createNamedQuery("RelacaoAlojamento.findByUK", RelacaoAlojamento.class);
        q.setParameter("relacao", idRelacao);
        q.setParameter("alojamento", idAlojamento);
        try {
            return (RelacaoAlojamento) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
