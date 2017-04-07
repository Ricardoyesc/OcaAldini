package Socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    
    AtiendePong cte;// Objeto para hacer uso del proceso de lectura y escritura
   ArrayList<Socket> listaCliente=new ArrayList();	    
   public Servidor()    
      {        
       try        
            {            
            ServerSocket ss = new ServerSocket (5000);			
            Socket cliente;            
            while(true){				
                  cliente = ss.accept();
                  System.out.println("Conexión exitosa");
                  listaCliente.add(cliente);				
                  cte = new AtiendePong(listaCliente,cliente); //Creación de un proceso para intercambio de info con cada Cliente que se conecte
                  }	     
            //ss.close();        
            }        
           catch (Exception e){    
               e.printStackTrace();       
           }    
     }    
     public static void main (String [] args)    
            {        new Servidor(); 
            }
     }
