/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.Nomina;

/**
 *
 * @author HP
 */
@Stateless
public class NominaFacade extends AbstractFacade<Nomina> {

    @PersistenceContext(unitName = "constructora1.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NominaFacade() {
        super(Nomina.class);
    }
    
}
