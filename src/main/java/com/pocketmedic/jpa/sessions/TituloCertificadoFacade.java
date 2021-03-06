/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.jpa.sessions;

import com.pocketmedic.jpa.entities.TituloCertificado;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Luis
 */
@Stateless
public class TituloCertificadoFacade extends AbstractFacade<TituloCertificado> {
    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TituloCertificadoFacade() {
        super(TituloCertificado.class);
    }
 
        public List<TituloCertificado> findByTitulos(String titulos) {
        return getEntityManager().createNamedQuery("TituloCertificado.findByTitulos")
                .setParameter("titulos", titulos + "%")
                .getResultList();
    }
}
