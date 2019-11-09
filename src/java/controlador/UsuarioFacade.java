/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.Usuario;

/**
 *
 * @author HP
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "constructora1.1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
     public Usuario encotrarUsuarioLogin(String nombreUsuario){
        Query q=em.createNamedQuery("Usuario.findByUsuario", Usuario.class).setParameter("usuario", nombreUsuario);
        List<Usuario> listado=q.getResultList();
        if (!listado.isEmpty()) {
            return listado.get(0);
        }
        return null;
    }
    
}
