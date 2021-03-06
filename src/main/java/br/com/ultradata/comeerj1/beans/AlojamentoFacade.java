/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.beans;

import br.com.ultradata.comeerj1.entidades.Alojamento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor
 */
@Stateless
public class AlojamentoFacade extends AbstractFacade<Alojamento> {
    @PersistenceContext(unitName = "br.com.ultradata_comeerj1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlojamentoFacade() {
        super(Alojamento.class);
    }
    
}
