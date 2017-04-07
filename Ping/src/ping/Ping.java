package ping;

import javax.swing.JFrame;

public class Ping {

     public static void main(String[] args) { //Crea la pantalla y añade los elementos
        Ventana pantalla = new Ventana();
        pantalla.setVisible(true);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
    
}
