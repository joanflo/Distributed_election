
package servicio;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import proceso.Proceso;
//import com.sun.jersey.spi.resource.Singleton;

/**
 * REST Web Service
 */
@Path("servicio")
public class Servicio {
    
    private static Proceso[] procesos = new Proceso[2]; 
    private int maquina;

    @Context
    private UriInfo context;

    
    
    /**
     * Creates a new instance of Servicio
     */
    public Servicio() {
        procesos = new Proceso[2];
        maquina = 1; // máquina actual [1..3]
    }
    
    
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("arrancarProceso/{idp}")
    public String arrancarProceso(@PathParam("idp") int id) {
        if (procesos[id % 2] == null) {
            Proceso p = new Proceso(id);
            procesos[id % 2] = p;
        }
        procesos[id % 2].arrancar();
        return "Arrancado el proceso " + id;
    }
    
    
    
    @GET
    @Path("pararProceso/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pararProceso(@PathParam("idp") int id) {
        procesos[id % 2].parar();
        return "Parado el proceso " + id;
    }
    
    
    
    /**
     * anuncia un proceso de elección
     * @param id
     * @param idRemitente
     * @param idCandidato
     * @return 
     */
    @GET
    @Path("eleccion/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String eleccion(@PathParam("idp") int id, @QueryParam("idr") int idRemitente, @QueryParam("idc") int idCandidato) {
        procesos[id % 2].eleccion(idRemitente, idCandidato);
        return "eleccion";
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
    public String respuesta(@PathParam("idp") int id, @QueryParam("idr") int idRemitente) {
        procesos[id % 2].ok(idRemitente);
        return "respuesta" + id + "-" + idRemitente;
    }
    
    
    
    /**
     * anuncia la identidad del proceso elegido
     * @param id
     * @param idCoordinador
     * @return 
     */
    @GET
    @Path("coordinador/{idp}")
    @Produces(MediaType.TEXT_PLAIN)
    public String coordinador(@PathParam("idp") int id, @QueryParam("idc") int idCoordinador) {
        procesos[id % 2].coordinador(idCoordinador);
        return "coordinador";
    }
    
    
    
}
