package Juegos.ClearShot;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

class EnviaGanador extends JFrame implements Runnable {

    Socket socket;
    int Jugador;
    Scanner entrada;

    EnviaGanador(Socket socket, int Jugador) {
        entrada = new Scanner(System.in);
        this.socket = socket;
        this.Jugador = Jugador;

        Thread hilo = new Thread(this);
        hilo.start();  //Inicia el Hilo, se llama automáticamente al método run()
    }

    public void run() {
        try {

            boolean terminar = false;
            String mensaje;
            while (!terminar) {      // Creamos bucle infinito para escritura
                OutputStream os = socket.getOutputStream();
                DataOutputStream flujoDOS = new DataOutputStream(os);
                mensaje = Jugador + "Gano";
                flujoDOS.writeUTF(mensaje);
                terminar = true;
            }
        } catch (IOException ex) {
            Logger.getLogger(EnviaGanador.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(EnviaGanador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

