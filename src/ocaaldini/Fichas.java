package ocaaldini;
/**
 *
 * @author Aldo
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Fichas extends JPanel implements Runnable{
    public int xv, yv, xr, yr;
    private Thread hilo;
    private Image fichaVerde, fichaRoja, fichaAzul, fichaAmarilla;
    
    public Fichas(){
        xv=400;
        yv=150;
        xr=300;
        yr=300;
        hilo = new Thread(this);
        hilo.start();
    }
    
    void Verde(){
        fichaVerde= new ImageIcon(this.getClass().getResource("Imagenes/Verde.jpg")).getImage();
        fichaVerde.getScaledInstance(20, 20, 100);
    }
    void Rojo(){
        fichaRoja= new ImageIcon(this.getClass().getResource("Imagenes/Roja.png")).getImage();
        fichaRoja.getScaledInstance(20, 20, 100);
    }
    
    
    @Override
    public void paint(Graphics g){
        
        super.paint(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.drawImage(fichaVerde, xv, yv, null);
        g2.drawImage(fichaRoja, xr, yr, null);
        g.dispose();
    }
    
    
    public void run(){
        
        while(true){
            xv+=100;
            if(xv>800){
                xv=-200;
            }
            repaint();
            
            try{
                Thread.sleep(10000);
            }
            catch (Exception e){
                System.out.println("Error");
            }
        }
    }
}
