package Juegos.ClearShot;

import java.net.*;
import java.io.*;

class LeeGanador extends Thread {

    Socket socket;
    Juego jueg;

    LeeGanador(Socket socket,Juego jueg) {
        this.socket = socket;
        this.jueg = jueg;
        start();   //Iniciar el proceso
    }

    public void run() {
        try {
            while (true) {     //bucle infinito para lectura
                InputStream aux = socket.getInputStream();
                DataInputStream flujo = new DataInputStream(aux);
                String msj = flujo.readUTF();
                System.out.println(msj);
                if(msj.equals("Conectados")){
                    jueg.conectados = true;
                }else if(msj.contains("1") || msj.contains("2") ){
                    jueg.ganador = true;
                    jueg.jugador2 = 100;
                }else if(msj.equals("inicia")){
                    jueg.inicio = true;
                    System.out.println("Inicia la matanza prros");
                }
                
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
    
    private int ganador(){
        return 0;
    }
    
}
