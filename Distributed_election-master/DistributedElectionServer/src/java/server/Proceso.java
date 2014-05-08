/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos-p
 */
public class Proceso extends Thread {
    
    private final int NUM_PROCESOS = 6;
            
    private int id;
    private Estado estado;
    private int coordinador;
    
    // Primera IP -> procesos 1 y 2; Segunda IP -> procesos 3 y 4;...
    private final static String [] IPS = {"127.0.0.1", "127.0.0.1", "127.0.0.1"};
    
    public Proceso (int id) {
        this.id = id;
        estado = Estado.Corriendo;
    }
    
    @Override
    public void run() {
        while (estado == Estado.Corriendo) {
            try {
                Thread.sleep((long)(Math.random() * 500 + 500));
                // int respuesta = IPS[coordinador] -> computar
                //if (respuesta < 0) {
                    this.eleccion();
                //}
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void coordinador(int idCoordinador) {
        coordinador = idCoordinador;
    }
    
    public void arrancar() {
        estado = Estado.Corriendo;
        this.start();
    }
    
    public void parar() {
        estado = Estado.Parado;
    }
    
    public void ok() {
        
    }
    
    public void eleccion() {
        boolean tengoLaMayorId = true;
        for (int j = id; j < NUM_PROCESOS; j++) {
            // respuesta -> ok o computar al proceso j
            //if (respuesta >= 0) {
            //  tengoLaMayor = false;
            //  exit;
            //}
        }
        if (tengoLaMayorId) {
            coordinador = id;
            // pj.coordinador(id) para todo pj en (procesos activos)
        } else {
            // pj.eleccion() para todo pj > id
            // esperar mensaje respuesta
            //      si recible mensaje respuesta
            //          esperar mensaje coordinador
            //          si recibe mensaje coordinador(x)
            //              pi.coordinador <- x
            //          si no 
            //              this.eleccion();
            //      si no 
            //          this.eleccion();
        }
        
    }
    
    public int computar() {
        if (estado == Estado.Parado) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
