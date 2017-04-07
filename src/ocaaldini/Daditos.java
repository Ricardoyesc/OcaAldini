package ocaaldini;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Bufisoft
 */
public class Daditos extends JPanel implements Runnable{
    private int x, y;
    private Image dadosIMG;
    JFrame tab1;
    
    public Daditos(int numDado, JFrame tab1, int x, int y) {
        x=0;
        y=0;
        dadosIMG = new ImageIcon(this.getClass().getResource("/Imagenes/" + numDado + ".png")).getImage();
        this.setBounds(x, y, 35, 35);
        this.setOpaque(false);
        this.setVisible(true);
        this.tab1 = tab1;
        this.tab1.add(this);
        this.tab1.repaint();
    }
    
    @Override
    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(dadosIMG,0, 0,35,35,null);
        g.dispose();
    }

    public void run() {

    }
}
