/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ultradata.comeerj1.beans;

import br.com.ultradata.comeerj1.entidades.TurmaEvangelizadores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Victor
 */
@Stateless
public class TurmaEvangelizadoresFacade extends AbstractFacade<TurmaEvangelizadores> {
    @PersistenceContext(unitName = "br.com.ultradata_comeerj1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TurmaEvangelizadoresFacade() {
        super(TurmaEvangelizadores.class);
    }
    
}
