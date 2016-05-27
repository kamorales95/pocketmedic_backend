/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.sessions;

import com.pocketmedic.jpa.entities.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Luis
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    public Usuario findByEmail(String email) {
        try {
            return (Usuario) em.createNamedQuery("Usuario.findByEmail")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }

    public List<Usuario> findUsuarioByIdRol(String idRol) {
        try {
            return getEntityManager().createNamedQuery("Usuario.findByIdRol")
                    .setParameter("idRol", idRol)
                    .getResultList();
        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }
    
    
    public Usuario findByRecuperarContraseña(int idUsuario, String codigoRecuperacionPass){
    return (Usuario) getEntityManager().createNamedQuery("Usuario.findByRecuperarContraseña ")
            .setParameter("idUsuario",idUsuario )
            .setParameter("codigoRecuperacionPass", codigoRecuperacionPass )
            .getSingleResult();
    
    }

    public List<Usuario> findUsuarioByTitulos(String idRol, String titulo) {
        try {
            Query query = em.createNativeQuery("SELECT * FROM USUARIOS u JOIN PROFESIONES_USUARIOS pu JOIN TITULOS_Y_CERTIFICADOS tc where u.id_usuario = pu.id_usuario and tc.id_profesiones=pu.id_profesiones and u.id_rol=?id_rol and tc.titulos =?titulos", Usuario.class);
            query.setParameter("id_rol", idRol);
            query.setParameter("titulos", titulo);
            List<Usuario> results = (List<Usuario>) query.getResultList();
            return results;

        } catch (NonUniqueResultException ex) {
            throw ex;
        } catch (NoResultException ex) {
            return null;
        }

    }
}
