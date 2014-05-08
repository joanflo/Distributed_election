/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Carlos-p
 */
@Path("ServidorREST")
public class ServidorRESTResource {
    private static Proceso [] procesos = new Proceso[2]; 

    @GET
    @Path("arrancaProceso/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String arrancaProceso(@PathParam("idp") int idProceso) {
        if (procesos[idProceso % 2] == null) {
            Proceso p = new Proceso(idProceso);
            procesos[idProceso % 2] = p;
        }
        procesos[idProceso % 2].arrancar();
        return "Arrancado el proceso " + idProceso;
    }
    
    @GET
    @Path("pararProceso/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pararProceso(@PathParam("idp") int idProceso) {
        procesos[idProceso % 2].parar();
        return "Parado el proceso " + idProceso;
    }
    
    @GET
    @Path("computar/{idp}")
    @Produces(MediaType.TEXT_PLAIN)    
    public String computar(@PathParam("idp") int idProceso) {
        procesos[idProceso % 2].computar();
        return "Proceso " + idProceso + " ha computado";
    }
    
    @GET
    @Path("eleccion/{idp}/{idc}")
    @Produces(MediaType.TEXT_PLAIN)
    public String eleccion(@PathParam("idp") int idProceso,
                           @PathParam("idc") int idCandidato) {
        procesos[idProceso % 2].eleccion();
        return "Hello";
    }
}
