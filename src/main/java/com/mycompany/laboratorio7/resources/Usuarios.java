
package com.mycompany.laboratorio7.resources;

import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

import com.mycompany.laboratorio7.logic.Usuario;
import com.mycompany.laboratorio7.logic.Service;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/usuarios")
@PermitAll
public class Usuarios {
    
    @GET
    @Produces((MediaType.APPLICATION_JSON))
    public List<Usuario> find(@DefaultValue("") @QueryParam("name") String user){
        return Service.instance().find(user);
    }
    
    @GET
    @Path("{user}")
    @Produces({MediaType.APPLICATION_JSON})
    public Usuario read(@PathParam("user") String user) {
        try {
            return Service.instance().read(user);
        } catch (Exception ex) {
            throw new NotFoundException(); 
        }
    }
    
    @DELETE
    @Path("{user}")
    public void delete(@PathParam("user") String user) {
        Service.instance().delete(user);
    }
    
}

