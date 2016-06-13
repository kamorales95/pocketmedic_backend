/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pocketmedic.rest.services;

import com.pocketmedic.jpa.entities.Consulta;
import com.pocketmedic.jpa.entities.Usuario;
import com.pocketmedic.jpa.sessions.ConsultaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1
 */
@Path("consultas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class ConsultasFacadeREST {
    @EJB
    
    ConsultaFacade consultaFacade;
    
    @GET
    public List<Consulta>findAll(){
        return consultaFacade.findAll();
    }
    
    @POST
    public void create(Consulta consulta){
        consultaFacade.create(consulta);
    }
    
    @GET
    @Path("{id}")
    public Consulta findById(@PathParam("id") Integer id) {
        return consultaFacade.find(id);
    }
    
    @PUT
    @Path("{id}")
    public void update(@PathParam("id") Integer id, Consulta consulta){
        consultaFacade.edit(consulta);
    }
    
    @DELETE
    @Path("{id}")
    public void delete (@PathParam("id") Integer id, Consulta consulta){
        consultaFacade.remove(consulta);
    
    }
    
    @GET
    @Path("usuario/{id}")
    public List<Consulta> findByUsuario(@PathParam("id") Integer id){
        return consultaFacade.findByUsuario(new Usuario(id));
    }
    
}
