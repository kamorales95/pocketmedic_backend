/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.sessions;

import com.pocketmedic.jpa.entities.Consulta;
import com.pocketmedic.jpa.entities.Respuesta;
import com.pocketmedic.jpa.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luis
 */
@Stateless
public class ConsultaFacade extends AbstractFacade<Consulta> {
    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultaFacade() {
        super(Consulta.class);
    }
    
       public List<Consulta> findByUsuario(Usuario usuario) {
        return getEntityManager().createNamedQuery("Consulta.findByIdUsuario")
                .setParameter("usuario", usuario)
                .getResultList();
    }
    
     public List<Consulta> findByIdUsuario(int idUsuario) {
        try {
            return (List<Consulta>) em.createNamedQuery("Respuesta.findByIdUsuario")
                    .setParameter("idUsuario", idUsuario)
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }
       
}
