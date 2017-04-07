package Juegos.ClearShot;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class AtiendeClientes extends Thread {

    Socket socket;
    String mensaje;
    ArrayList<Socket> listaCliente;
    int cliente;

    AtiendeClientes(ArrayList<Socket> lista, Socket socket) {
        this.listaCliente = lista;
        this.socket = socket;
        start();
    }

    public void run() {
        try {
            int i = 0;
            while (true) {

                if (i == 0) {
                    sleep(3000);
                    mensaje = "inicia";
                    i++;
                } else if (i != -1){
                    InputStream is = socket.getInputStream();
                    DataInputStream flujo = new DataInputStream(is);
                    mensaje = flujo.readUTF();
                    i = -1;
                }
                for (int cont = 0; cont < listaCliente.size(); cont++) {
                    OutputStream os = listaCliente.get(cont).getOutputStream();
                    DataOutputStream flujoDOS = new DataOutputStream(os);
                    flujoDOS.writeUTF(mensaje);
                }
            }
        } catch (Exception e) {
            System.out.println("Error de comunicacion" + e);
        }
    }

}
