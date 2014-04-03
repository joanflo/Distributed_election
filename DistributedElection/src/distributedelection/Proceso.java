/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedelection;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos-p
 */
public class Proceso implements Runnable {
    
    private Estado estado;
    private Proceso coordinador;
    
    public enum Estado {
        Corriendo, Parado
    }
    
    @Override
    public void run() {
        while (estado == Estado.Corriendo) {
            try {
                Thread.sleep((long)(Math.random()*500 + 500));
                if (coordinador.computar() < 0) {
                    
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        return 0;
    }
    
}
