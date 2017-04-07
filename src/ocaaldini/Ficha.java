package ocaaldini;
/**
 *
 * @author Bugisoft
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ficha extends JPanel implements Runnable {

    /**
     * @return the fichaIMG
     */
    public Image getFichaIMG() {
        return fichaIMG;
    }

    /**
     * @param fichaIMG the fichaIMG to set
     */
    public void setFichaIMG(Image fichaIMG) {
        this.fichaIMG = fichaIMG;
    }

    private int x, y, casilla;
    private Thread hilo;
    private Image fichaIMG;

    public Ficha(int numIMG, int casilla, ArrayList<Casilla> casillas) {
        fichaIMG = new ImageIcon("recursos/Imagenes/" + numIMG + ".png").getImage();
        this.setSize(30, 30);
        this.setOpaque(false);
        this.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(getFichaIMG(),0, 0,30,30,null);
        g.dispose();
    }

    public void run() {

    }

    public int getCasilla() {
        return casilla;
    }

    public void setCasilla(int casilla) {
        this.casilla = casilla;
    }
}
