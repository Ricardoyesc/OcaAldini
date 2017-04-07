package ocaaldini;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Casilla extends JPanel {

    public int corx;
    public int cory;
    public int numero;
    private Image casillaIMG;
    public JFrame tab;
    ArrayList<Ficha> fichas = new ArrayList<>();

    public Casilla(int numIMGCasilla, int numCasilla, int corx, int cory, JFrame tab) {
        this.corx = corx;
        this.cory = cory;
        this.tab = tab;
        String Ruta = "Imagenes/1.png";
        casillaIMG = new ImageIcon(Ruta).getImage();
        setLocation(corx, cory);
        setSize(100, 60);
        setVisible(true);
        this.tab.add(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(casillaIMG, 0, 0, 100, 60, null);
        if (fichas.size() > 0) {
            int x = 100 / (fichas.size() / 2) + 5;
            int y;
            if (fichas.size() % 2 == 0) {
                y = 30;
            } else {
                if (fichas.size() > 2) {
                    y = 30;
                } else {
                    y = 0;
                }
            }
            int x2 = 0;
            int y2 = 0;
            for (int i = 0; i < fichas.size(); i++) {
                g2.drawImage(fichas.get(i).getFichaIMG(), x2, y2, 30, 30, null);
                
                if(i%2 ==0){

                    y2+= y;
                    
                }else{
                    y2 =0;
                }
            }
        }
        g.dispose();
    }

    public void añadeFicha(Ficha fich) {
        fichas.add(fich);
        repaint();
    }

    public int getCorx() {
        return corx;
    }

    public void setCorx(int corx) {
        this.corx = corx;
    }

    public int getCory() {
        return cory;
    }

    public void setCory(int cory) {
        this.cory = cory;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
