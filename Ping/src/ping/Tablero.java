package ping;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

class Tablero extends JPanel{
    Pelota Pelota = new Pelota(0,0);
    Raqueta P1 = new Raqueta(10,200);
    Raqueta P2 = new Raqueta(774,200);
    Medio m = new Medio();
    Medio d = new Medio();
    Medio i = new Medio();
     public Tablero(){
         setBackground(Color.BLACK); 
     }     
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.WHITE);
        dibujar(g2);
        try {
            dibujarPuntaje(g2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tablero.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizar();
    }

    public void dibujar(Graphics2D g) {
        g.fill(Pelota.getPelota());
        g.fill(P1.getRaqueta());
        g.fill(P2.getRaqueta());
        g.fill(m.getMedio());
        g.fill(d.getDercha());
        g.fill(i.getIzquierda());
    }

    public void actualizar() {
        Pelota.mover(getBounds(),colision(P1.getRaqueta()),colision(P2.getRaqueta()));
        P1.moverP1(getBounds());
        P2.moverP2(getBounds());
    }
    
    private boolean colision(Rectangle2D r){
        return Pelota.getPelota().intersects(r);
    }
    
     private void dibujarPuntaje(Graphics2D g) throws InterruptedException {
        Graphics2D g1 = g, g2 = g, g3=g, g4=g;
        Font score = new Font("Arial", Font.BOLD, 30);
        g.setFont(score);
        g1.drawString(Integer.toString(Pelota.getScore1()), (float) getBounds().getCenterX() - 50, 30);
        g2.drawString(Integer.toString(Pelota.getScore2()), (float) getBounds().getCenterX() + 50, 30);       
        if(Pelota.getScore1()==2){
            g3.drawString("Gano jugador 1", (float) getBounds().getCenterX()-230, (float) getBounds().getCenterY());   
            Pelota.finJuego = true;
        }
        if(Pelota.getScore2()==2){ 
            g4.drawString("Gano jugador 2", (float) getBounds().getCenterX() +35, (float) getBounds().getCenterY());
            Pelota.finJuego = true;
        } 
    }
}