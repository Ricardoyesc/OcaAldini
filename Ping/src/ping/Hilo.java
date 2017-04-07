package ping;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HOME
 */
public class Hilo extends Thread {

    Tablero lamina;

    public Hilo(Tablero lamina) {
        this.lamina = lamina;
    }

    @Override
    public void run() {//Hace que los movimientos sean posibles
        while (!Pelota.finJuego) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
            lamina.repaint();
        }
    }
}
