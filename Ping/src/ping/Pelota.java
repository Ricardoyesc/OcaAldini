package ping;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Pelota {

    int x = 0, y = 0;
    private static final int TAMX = 15;
    private static final int TAMY = 15;
    private final int  ANCHO=20;
    private final int ALTO=20;
    private Integer score1 = 0, score2 = 0;
    public static boolean finJuego = false;
    int dx=1;
    int dy=1;
    public Pelota(int x, int y) {
        this.x = 400;
        this.y = 400;

    }
    public Rectangle2D getPelota() {
        return new Rectangle2D.Double(x,y,ANCHO,ALTO);
    }
        
    public void mover(Rectangle limites, boolean colisionP1,boolean colisionP2) {
        x += dx;
        y += dy;
        if(colisionP1){
            dx=-dx;
            x=25;
        }
        if(colisionP2){
            dx=-dx;
            x=754;
        }        
        if (x < limites.getMinX()) {
            score2++; //el puntaje del jugador2 aumenta en uno
           
            x = (int) limites.getCenterX();
            y = (int) limites.getCenterY();
            dx = -dx;
        }

        if (x + TAMX >= limites.getMaxX()) {
            score1++; //el puntaje del jugador1 aumenta en uno
            
            x = (int) limites.getCenterX();
            y = (int) limites.getCenterY();
            dx = -dx;
        }

        if (y < limites.getMinY()) {

            y = (int) limites.getMinY();

            dy = -dy;
        }

        if (y + TAMY >= limites.getMaxY()) {

            y = (int) (limites.getMaxY() - TAMY);

            dy = -dy;
        }
    }
    
        public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }
}

