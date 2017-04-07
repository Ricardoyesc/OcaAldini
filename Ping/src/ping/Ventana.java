package ping;

import javax.swing.JFrame;

public class Ventana extends JFrame {

    private Tablero lamina;
    private Hilo hilo;
    public Ventana() { //Elementos ornamentales de la pantalla
        setTitle("Juego Pong");
        setSize(800, 600);
        setResizable(false);
        lamina = new Tablero();
        add(lamina);
        addKeyListener(new Controles());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        hilo = new Hilo(lamina);
        hilo.start();
    }
}
