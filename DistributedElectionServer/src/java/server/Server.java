/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server;

import java.util.ArrayList;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Carlos-p
 */
@WebService(serviceName = "Server")
public class Server {
    
    private static Proceso [] procesos = new Proceso[2]; 
    
    @WebMethod(operationName = "arrancaProceso")
    public String arrancaProceso(@WebParam(name = "idProceso") int idProceso) {
        if (procesos[idProceso % 2] == null) {
            Proceso p;
            Thread t = new Thread(p = new Proceso(idProceso));
            procesos[idProceso % 2] = p;
        } else {
            procesos[idProceso % 2].arrancar();
        } 
        return "Arrancado el proceso " + idProceso;
    }
    
    @WebMethod(operationName = "pararProceso")
    public String pararProceso(@WebParam(name = "idProceso") int idProceso) {
        procesos[idProceso % 2].parar();
        return "Parado el proceso " + idProceso;
    }
    
    @WebMethod(operationName = "computar")
    public String computar(@WebParam(name = "idProceso") int idProceso) {
        return "Hello";
    }
    
    @WebMethod(operationName = "eleccion")
    public String eleccion(@WebParam(name = "idProceso") int idProceso,
                           @WebParam(name = "idCandidato") int idCandidato) {
        return "Hello";
    }
    
    
}
