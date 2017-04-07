
package ping;

import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public class Raqueta {
    int x = 0;
    int y = 0;
    int Ancho=10;
    int Alto=70;
    int dx=1;
    int dy=1;

    public Raqueta(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Rectangle2D getRaqueta() {
        return new Rectangle2D.Double(x, y, Ancho, Alto);
    }
    
    public void moverP1(Rectangle limites){
        if(Controles.w && y> limites.getMinY()){
            y--;
        }
        if(Controles.s && y< limites.getMaxY()-Alto){
            y++;
        }
        
    }
    
    public void moverP2(Rectangle limites){
        if(Controles.Arriba && y> limites.getMinY()){
            y--;
        }
        if(Controles.Abajo && y< limites.getMaxY()-Alto){
            y++;
        }
        
    }

}
