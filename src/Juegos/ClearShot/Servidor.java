package Juegos.ClearShot;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.*;

public class Servidor {

    AtiendeClientes cte;
    ArrayList<Socket> listaCliente = new ArrayList();

    public Servidor() {
        try {
            ServerSocket ss = new ServerSocket(5000);
            Socket cliente;
            while (true) {
                cliente = ss.accept();
                System.out.println("Conexión exitosa");
                listaCliente.add(cliente);
                if (listaCliente.size() >= 2) {
                    cte = new AtiendeClientes(listaCliente, cliente);
                    for (int i = 0; i < listaCliente.size();i++ ) {
                        OutputStream os = listaCliente.get(i).getOutputStream();
                        DataOutputStream flujoDOS = new DataOutputStream(os);   
                        flujoDOS.writeUTF("Conectados");
                    }
                }
            }       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Servidor();
    }
}
