package ping;

import java.awt.RenderingHints.Key;
import java.awt.event.*;

public class Controles extends KeyAdapter {
     static boolean w ,s ,Arriba ,Abajo ;

   @Override
    public void keyPressed(KeyEvent e) {

        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            w = true;
        }
        if (id == KeyEvent.VK_S) {
            s = true;
        }
        if (id == KeyEvent.VK_UP) {
            Arriba = true;
        }
        if (id == KeyEvent.VK_DOWN) {
            Abajo = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int id = e.getKeyCode();
        
        if (id == KeyEvent.VK_W) {
            w = false;
        }
        if (id == KeyEvent.VK_S) {
            s = false;
        }
        if (id == KeyEvent.VK_UP) {
            Arriba = false;
        }
        if (id == KeyEvent.VK_DOWN) {
            Abajo = false;
        }
    }

}
