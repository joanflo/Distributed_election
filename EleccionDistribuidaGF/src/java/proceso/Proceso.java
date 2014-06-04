
package proceso;

import gestor.Gestor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import static java.net.Proxy.Type.HTTP;
import java.net.SocketException;
import java.net.URL;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Proceso extends Thread {
    
    public static final int MAX_ESPERA_MENSAJES = 1000; // En milisegundos
    public static final int NUM_PROCESOS = 6;

    private int id;
    private int coordinador;
    private Estado estado;
    
    // Variables auxiliares para el proceso de elección
    private boolean meHanRespondidoOk, meHanRespondidoCoordinador, enEleccion;
    
    public Proceso (int id) {
        this.id = id;
        estado = Estado.Parado;
    }
    
    public int getIdProceso() {
        return id;
    }
    
    public void run() {
        while (estado == Estado.Corriendo) {
            try {
                mensajeDebug("Run proceso " + id + " con coordinador " + coordinador);
                double u = Math.random(); // U(0,1) 
                double espera = (u * 500) + 500; // U(500,1000) 
                Thread.sleep((long) espera);
                try {
                    URL url;
                    url = new URL(Gestor.getUrlBase(coordinador) + "computar/" + coordinador);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode() == 200 && estado == Estado.Corriendo) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        int valor = Integer.parseInt(br.readLine());
                        if (valor < 0) {
                            this.eleccion(id);
                        }
                        br.close();
                    } else if (estado == Estado.Corriendo) { // Caso de error
                        
                        this.eleccion(id);
                        // Comunicar algún mensaje al WebService de la máquina donde se encuentra el gestor
                        // y así poder mostar un mensaje de error de comunicación.
                    }
                    conn.disconnect();
                } catch (IOException ex) {
                    this.eleccion(id);
                    //Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }       
    
    public void ok() {
        meHanRespondidoOk = true;
    }
    
    public void eleccion(int idRemitente){
        this.enEleccion = true;
        mensajeDebug("Inicio elección de " + id + " remitente " + idRemitente);
        if (estado == Estado.Corriendo) {
            if (idRemitente != id) {
                enviarMensajeOk(idRemitente);
            }
            boolean acabado = false;
            while (!acabado && estado == Estado.Corriendo) {
                // miramos si tenemos la mayor Id de entre los procesos activos           
                if (tengoLaMayorId()) {
                    mensajeDebug("Proceso " + id + " tiene la id mayor y se proclama coordinador");
                    // el proceso actual es el nuevo coordinador
                    coordinador = id;
                    enviarMensajesCoordinador();
                    acabado = true;
                } else {
                    meHanRespondidoOk = false;
                    meHanRespondidoCoordinador = false;
                    // pj.eleccion() para todo pj > id
                    for (int i= id + 1; i <= NUM_PROCESOS; i++) {
                        mensajeDebug("Proceso " + id + " envia elección a " + i);
                        enviarEleccion(i);
                    }
                    // esperar mensaje respuesta (máximo 1 segundo)
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (meHanRespondidoOk) { // si recibe mensaje respuesta
                        mensajeDebug("Proceso " + id + " le han respondido ok");
                        // esperar mensaje coordinador (máximo 1 segundo)
                        try {
                            sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (meHanRespondidoCoordinador) { // si recibe mensaje coordinador (x)
                            // ya me han asignado el nuevo coordinador
                            mensajeDebug("Proceso " + id + " le han respondido coordinador");
                            acabado = true;
                        }
                    } 
                }
            }
        }
        this.enEleccion = false;
    }
    
    public void coordinador(int idCoordinador) {
        if (estado == Estado.Corriendo) {
            mensajeDebug("coordinador (" + id + "):" + idCoordinador);
            meHanRespondidoCoordinador = true;
            coordinador = idCoordinador;
        }
    }
    
    public void arrancar() {
        estado = Estado.Corriendo;
        coordinador = id;
        this.start();
    }
    
    public void parar() {
        estado = Estado.Parado;
    }
    
    public int computar() {
        if (estado == Estado.Parado) {
            return -1;
        }
        return 0;
    }
    
    public int getEstado() {
        if (this.estado == Estado.Corriendo) {
            if (this.enEleccion) {
                return 2;
            }
            return 1;
        }
        return 0;
    }
    
    public int getCoordinador() {
        if (this.estado == Estado.Corriendo) {
            return this.coordinador;
        }
        return -1;
    }
    
    private boolean tengoLaMayorId() {
        mensajeDebug("Proceso " + id + " comprueba procesos activos mayores");
        for (int i = id + 1; i <= NUM_PROCESOS; i++) {
            try {
                URL url;
                mensajeDebug("Proceso " + id + " consulta estado/" + i);
                url = new URL(Gestor.getUrlBase(i) + "estado/" + i);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                if (conn.getResponseCode() == 200) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    int activo = Integer.parseInt(br.readLine());
                    br.close();
                    if (activo > 0) {
                        return false;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }
    
    private void enviarEleccion(int idDestino) {
        try {
            URL url = new URL(Gestor.getUrlBase(idDestino) + "eleccion/" + idDestino + "/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.getResponseCode();
            conn.disconnect();
        } catch (IOException ex) {
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void enviarMensajeOk(int idDestino) {
        try {
            URL url = new URL(Gestor.getUrlBase(idDestino) + "respuesta/" + idDestino);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                // ok
            }
            conn.disconnect();
        } catch (IOException ex) {
            mensajeDebug("enviarMensajeOk: soy " + id + " y peto al responder a " + idDestino);
            Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void enviarMensajesCoordinador() {
        // mandamos mensaje 'coordinador' a todos los procesos con id diferente a la actual
        // pj.coordinador(id) para todo pj en (procesos activos)
        for (int i= 1; i <= NUM_PROCESOS; i++) {
            if (i != id) {
                try {
                    URL url = new URL(Gestor.getUrlBase(i) + "coordinador/" + i + "/" + id);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");
                    if (conn.getResponseCode() == 200) {
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    private void mensajeDebug(String mensaje) {
        // Con varios PCs no funcionará!!!!!
        System.out.println(mensaje);
        //Gestor.mostrarNotificacion(mensaje);
    }
}
