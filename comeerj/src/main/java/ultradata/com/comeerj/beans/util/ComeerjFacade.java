/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ultradata.com.comeerj.beans.util;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ultradata.com.comeerj.modelo.Comeerj;

/**
 *
 * @author floriano.peixoto
 */
@Stateless
public class ComeerjFacade extends AbstractFacade<Comeerj> {
    @PersistenceContext(unitName = "comeerj")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComeerjFacade() {
        super(Comeerj.class);
    }

    
    public List<Comeerj> findAllOrdered() {  
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(Comeerj.class));
        cq.orderBy(getEntityManager().getCriteriaBuilder().asc(cq.from(Comeerj.class).get("nomCompleto")));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    
    
}
