/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pocketmedic.jpa.entities.Usuario;
import com.pocketmedic.jpa.sessions.UsuarioFacade;
import com.pocketmedic.rest.auth.DigestUtil;
import java.util.List;
import javax.ejb.Asynchronous;
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
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

/**
 *
 * @author Luis
 */
@Stateless
@Path("usuarios")
public class UsuarioFacadeREST extends AbstractFacade<Usuario> {

    @EJB
    UsuarioFacade ejbUsuarioFacade;

    @PersistenceContext(unitName = "PM-BackendPU")
    private EntityManager em;

    public UsuarioFacadeREST() {
        super(Usuario.class);
    }


    @PUT
    @Path("{id}")
    @Consumes({"application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
        System.out.println("PASSWORD");
        System.out.println(entity.getPassword());
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
    public Usuario find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("rol/{id}")
    @Produces({"application/json"})
    public List<Usuario> findUsuarioByIdRol(@PathParam("id") String id) {
        System.out.println(id);
        return ejbUsuarioFacade.findUsuarioByIdRol(id);
    }

    @GET
    @Override
    @Produces({"application/json"})
    public List<Usuario> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/json"})
    public List<Usuario> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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

    @POST
    @Consumes(value = {"application/json"})
    @Asynchronous
    public void create(@Suspended final AsyncResponse asyncResponse, final Usuario usuarios) {
        asyncResponse.resume(doCreate(usuarios));
    }

    private Response doCreate(Usuario usuarios) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        
        if (ejbUsuarioFacade.findByEmail(usuarios.getEmail())== null){
            
            usuarios.setPassword(DigestUtil.cifrarPassword(usuarios.getPassword()));
            System.out.println("PASSWORD CIFRADA");
            System.out.println(usuarios.getPassword());
            super.create(usuarios);
            
            return Response.ok()
                    .entity(gson.toJson("el usuario fue creado exitosamente"))
                    .build();
        }else{
            return Response
                    .status(Response.Status.CONFLICT)
                    .entity(gson.toJson("el email ya esta registrado"))
                    .build();
        }   }

}
