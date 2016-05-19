/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;

import com.pocketmedic.jpa.entities.EmpresaPago;
import com.pocketmedic.jpa.entities.EmpresaPagoPK;
import java.util.List;
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
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author Luis
 */
@Stateless
@Path("empresaspagos")
public class EmpresaPagoFacadeREST extends AbstractFacade<EmpresaPago> {
    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    private EmpresaPagoPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;idEmpresaPago=idEmpresaPagoValue;idEmpresa=idEmpresaValue;idPagos=idPagosValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        com.pocketmedic.jpa.entities.EmpresaPagoPK key = new com.pocketmedic.jpa.entities.EmpresaPagoPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> idEmpresaPago = map.get("idEmpresaPago");
        if (idEmpresaPago != null && !idEmpresaPago.isEmpty()) {
            key.setIdEmpresaPago(new java.lang.Integer(idEmpresaPago.get(0)));
        }
        java.util.List<String> idEmpresa = map.get("idEmpresa");
        if (idEmpresa != null && !idEmpresa.isEmpty()) {
            key.setIdEmpresa(new java.lang.Integer(idEmpresa.get(0)));
        }
        java.util.List<String> idPagos = map.get("idPagos");
        if (idPagos != null && !idPagos.isEmpty()) {
            key.setIdPagos(new java.lang.Integer(idPagos.get(0)));
        }
        return key;
    }

    public EmpresaPagoFacadeREST() {
        super(EmpresaPago.class);
    }

    @POST
    @Override
    @Consumes({"application/json"})
    public void create(EmpresaPago entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") PathSegment id, EmpresaPago entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        com.pocketmedic.jpa.entities.EmpresaPagoPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/json"})
    public EmpresaPago find(@PathParam("id") PathSegment id) {
        com.pocketmedic.jpa.entities.EmpresaPagoPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<EmpresaPago> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<EmpresaPago> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
