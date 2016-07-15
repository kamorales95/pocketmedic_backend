/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;

import com.nimbusds.jose.JOSEException;
import com.pocketmedic.jpa.entities.Respuesta;
import com.pocketmedic.jpa.entities.Usuario;
import com.pocketmedic.jpa.sessions.RespuestaFacade;
import com.pocketmedic.rest.auth.AuthUtils;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

/**
 *
 * @author Luis
 */
@Stateless
@Path("respuestas")
public class RespuestaFacadeREST extends AbstractFacade<Respuesta> {

    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    @Context
    private HttpServletRequest request;

    @EJB
    private RespuestaFacade ejbRespuestaFacade;

    public RespuestaFacadeREST() {
        super(Respuesta.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Respuesta entity) {

        try {
            entity.setIdUsuario(new Usuario(
                    Integer.parseInt(
                            AuthUtils.getSubject(
                                    request.getHeader(AuthUtils.AUTH_HEADER_KEY)))));
            super.create(entity);

        } catch (ParseException | JOSEException ex) {
            Logger.getLogger(RespuestaFacadeREST.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Respuesta entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Respuesta find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("usuario/{id}")
    @Produces({"application/json"})
    public List<Respuesta> findbyIdUsuario(@PathParam("id") Integer id) {
        return ejbRespuestaFacade.findByIdUsuario(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Respuesta> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Respuesta> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
