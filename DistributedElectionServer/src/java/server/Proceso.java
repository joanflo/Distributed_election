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
public class Proceso implements Runnable {
    
    private final int NUM_PROCESOS = 6;
            
    private int id;
    private Estado estado;
    private int coordinador;
    
    public Proceso (int id) {
        this.id = id;
        estado = Estado.Corriendo;
    }
    
    @Override
    public void run() {
        while (estado == Estado.Corriendo) {
            try {
                Thread.sleep((long)(Math.random()*500 + 500));
                
                //if (coordinador.computar() < 0) {
                    eleccion();
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
        this.run();
    }
    
    public void parar() {
        estado = Estado.Parado;
    }
    
    public void ok() {
        
    }
    
    public void eleccion() {
        
    }
    
    public int computar() {
        if (estado == Estado.Parado) {
            return -1;
        } else {
            return 0;
        }
    }
    
}
