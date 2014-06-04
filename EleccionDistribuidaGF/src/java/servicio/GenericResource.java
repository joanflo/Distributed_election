/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servicio;

import gestor.Gestor;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import proceso.Proceso;

/**
 * REST Web Service
 *
 * @author Carlos
 */
@Path("generic")
public class GenericResource {

    private static int NUM_PROCESOS_MAQUINA = 6;
    private static Proceso[] procesos = new Proceso[NUM_PROCESOS_MAQUINA]; 

    @Context
    private UriInfo context;
    
    /**
     * Creates a new instance of Servicio
     */
    public GenericResource() {
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("arrancarProceso/{idp}")
    public String arrancarProceso(@PathParam("idp") int id) {
        Proceso p = new Proceso(id);
        procesos[(id - 1) % NUM_PROCESOS_MAQUINA] = p;
        procesos[(id - 1) % NUM_PROCESOS_MAQUINA].arrancar();
        procesos[(id - 1) % NUM_PROCESOS_MAQUINA].eleccion(id);
        return "Arrancado el proceso " + id;
    }

    @GET
    @Path("pararProceso/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pararProceso(@PathParam("idp") int id) {
        try {
            procesos[(id - 1) % NUM_PROCESOS_MAQUINA].parar();
            return "Parado el proceso " + id;
        } catch  (Exception e) {
            return "-1";
        }
    }

    /**
     * anuncia un proceso de elección
     * @param id
     * @param idRemitente
     * @return 
     */
    @GET
    @Path("eleccion/{idp}/{idr}")
    @Produces(MediaType.TEXT_PLAIN)
    public String eleccion(@PathParam("idp") int id, @PathParam("idr") int idRemitente) {
        try {
            procesos[(id - 1) % NUM_PROCESOS_MAQUINA].eleccion(idRemitente);
            return "eleccion";
        } catch  (Exception e) {
            return "-1";
        }
    }
    
    /**
     * respuesta a un mensaje de elección
     * @param id
     * @param idRemitente
     * @return 
     */
    @GET
    @Path("respuesta/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String respuesta(@PathParam("idp") int id) {
        try {
            procesos[(id - 1) % NUM_PROCESOS_MAQUINA].ok();
            return "respuesta" + id;
        } catch  (Exception e) {
            return "-1";
        }
    }

    /**
     * anuncia la identidad del proceso elegido
     * @param id
     * @param idCoordinador
     * @return 
     */
    @GET
    @Path("coordinador/{idp}/{idc}")
    @Produces(MediaType.TEXT_PLAIN)
    public String coordinador(@PathParam("idp") int id, @PathParam("idc") int idCoordinador) {
        try {
            procesos[(id - 1) % NUM_PROCESOS_MAQUINA].coordinador(idCoordinador);
            return "coordinador";
        } catch  (Exception e) {
            return "-1";
        }
    }
    
    /**
     * realiza un proceso ficticio de computación
     * @param id
     * @return 
     */
    @GET
    @Path("computar/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String computar(@PathParam("idp") int id) {
        try {
            return "" + procesos[(id - 1) % NUM_PROCESOS_MAQUINA].computar();
        } catch  (Exception e) {
            return "-1";
        }
    }
    
    /**
     * obtiene directamente si el proceso se encuentra activo o no
     * (sólo se usa en el primer paso de proceso de elección)
     * @param id
     * @return 
     */
    @GET
    @Path("estado/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String procesoActivo(@PathParam("idp") int id) {
        try {
            return "" + procesos[(id - 1) % NUM_PROCESOS_MAQUINA].getEstado();
        } catch (Exception e) {
            return "-1";
        }
    }
    
    /**
     * obtiene el coordinador del sistema
     * @param id
     * @return 
     */
    @GET
    @Path("getCoordinador/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCoordinador(@PathParam("idp") int id) {
        try {
            return "" + procesos[(id - 1) % NUM_PROCESOS_MAQUINA].getCoordinador();
        } catch (Exception e) {
            return "-1";
        }
    }
}
