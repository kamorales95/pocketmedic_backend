/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;

import com.pocketmedic.jpa.entities.Ciudad;
import com.pocketmedic.jpa.entities.CiudadPK;
import com.pocketmedic.jpa.sessions.CiudadFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Luis
 */
@Stateless
@Path("ciudades")
public class CiudadFacadeREST extends AbstractFacade<Ciudad> {

    @EJB
    private CiudadFacade ejbCiudadFacade;
    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    private CiudadPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idCiudad=idCiudadValue;idDepartamento=idDepartamentoValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.pocketmedic.jpa.entities.CiudadPK key = new com.pocketmedic.jpa.entities.CiudadPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idCiudad = map.get("idCiudad");
        if (idCiudad != null && !idCiudad.isEmpty()) {
            key.setIdCiudad(new java.lang.Integer(idCiudad.get(0)));
        }
        java.util.List<String> idDepartamento = map.get("idDepartamento");
        if (idDepartamento != null && !idDepartamento.isEmpty()) {
            key.setIdDepartamento(new java.lang.Integer(idDepartamento.get(0)));
        }
        return key;
    }

    public CiudadFacadeREST() {
        super(Ciudad.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(Ciudad entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, Ciudad entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.pocketmedic.jpa.entities.CiudadPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public Ciudad find(@PathParam("id") PathSegment id) {
        com.pocketmedic.jpa.entities.CiudadPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Ciudad> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Ciudad> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @GET
    @Path("nombre/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> findByNombre(@PathParam("nombre") String nombre) {
        return ejbCiudadFacade.findByNombre(nombre);
    }

}
