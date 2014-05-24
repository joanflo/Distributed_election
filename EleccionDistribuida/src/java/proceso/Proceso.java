
package proceso;

import gestor.Gestor;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proceso implements Runnable {
    
    public static final int NUM_PROCESOS = 6;

    private int id;
    private int coordinador;
    private Estado estado;
    
    
    public Proceso (int id) {
        this.id = id;
    }
    
    
    
    public void ok(int idProceso) {
        
    }
    
    
    
    public void eleccion(int idRemitente, int idCandidato) {
        // miramos si tenemos la mayor IP de entre los procesos activos
        boolean tengoLaMayorId = true;
        for (int i = id + 1; i <= NUM_PROCESOS; i++) {
            // respuesta -> ok o computar al proceso j
            //if (respuesta >= 0) {
            //  tengoLaMayor = false;
            //  exit;
            //}
        }
        
        if (tengoLaMayorId) {
            // actual proceso es el nuevo coordinador
            coordinador = id;
            notificarCoordinador();
        } else {
            // pj.eleccion() para todo pj > id
            notificarElecciones();
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
    
    
    
    public void coordinador(int idCoordinador) {
        coordinador = idCoordinador;
    }
    
    
    
    public void arrancar() {
        estado = Estado.Corriendo;
        //this.start();
    }
    
    public void parar() {
        estado = Estado.Parado;
    }
    
    
    
    public int computar() {
        if (estado == Estado.Parado) {
            return -1;
        } else {
            return 0;
        }
    }
    
    
    public void run() {
        while (estado == Estado.Corriendo) {
            try {
                double u = Math.random(); // U(0,1) 
                double espera = (u * 500) + 500; // U(500,1000) 
                Thread.sleep((long) espera);
                
                int valor = computar(); // coordinador.computar(); ???
                
                if (valor < 0) {
                    notificarElecciones();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private void notificarElecciones() {
        // mandamos mensaje 'elección' a todos los procesos con id mayor
        for (int i= id + 1; i <= NUM_PROCESOS; i++) {
            enviarEleccion(i);
        }
    }
    
    
    private void enviarEleccion(int idDestino) {
        try {
            URL url = new URL(Gestor.getUrlBase(idDestino) + "eleccion/" + idDestino + "?idr=" + id + "&idc=" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                // ok
            }
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void enviarOk(int idDestino) {
        try {
            URL url = new URL(Gestor.getUrlBase(idDestino) + "respuesta/" + idDestino + "?idr=" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                // ok
            }
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    private void notificarCoordinador() {
        // mandamos mensaje 'coordinador' a todos los procesos con id diferente a la actual
        // pj.coordinador(id) para todo pj en (procesos activos)
        for (int i= 1; i <= NUM_PROCESOS; i++) {
            if (i != id) {
                enviarCoordinador(i);
            }
        }
    }
    
    
    private void enviarCoordinador(int idDestino) {
        try {
            URL url = new URL(Gestor.getUrlBase(idDestino) + "coordinador/" + idDestino + "?idc=" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                // ok
            }
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
