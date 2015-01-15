/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.beans.util;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ultradata.com.comeerj.modelo.DadosEquipe;

/**
 *
 * @author floriano.peixoto
 */
@Stateless
public class DadosEquipeFacade extends AbstractFacade<DadosEquipe> {
    @PersistenceContext(unitName = "comeerj")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DadosEquipeFacade() {
        super(DadosEquipe.class);
    }
    
}
