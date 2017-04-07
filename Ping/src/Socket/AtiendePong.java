package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import ping.*;

public class AtiendePong extends Thread {

    Socket socket;
    String mensaje;
    ArrayList<Socket> listaCliente;
    int cliente;
    Ventana ping;

    AtiendePong(ArrayList<Socket> lista, Socket socket) // Recibe el ArrayList de Sockets Cliente que actualmente se están atendiendo
    {
        this.listaCliente = lista;
        this.socket = socket;
        start();
    }

    public void run() {
        while (true) {   // Bucle infinito para lectura y escritura
            try {
                InputStream is = socket.getInputStream(); // Se abre flujo de lectura
                DataInputStream flujo = new DataInputStream(is);
                mensaje = flujo.readUTF();  // Permanece escuchando hasta que alguno de los clientes le envía un mensaje
                for (int cont = 0; cont < listaCliente.size(); cont++) //Cuando recibe un mensaje, lo replica a todos los Clientes recorriendo el ArrayList de Sockets y escribe al flujo de cada uno de ellos
                {
                    ping =  new Ventana();
                }
            } catch (Exception e) {
                System.out.println("Error de comunicacion" + e);
            }
        }
    }
}
