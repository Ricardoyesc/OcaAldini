package Juegos.ClearShot.graficos;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class HojaSprites {

    public final int[] pixeles;
    private final int ANCHO;
    private final int ALTO;
    
    public static HojaSprites cowBoyMovimientos = new HojaSprites("/ClearShot/Cowboy4.png", 256, 256);

    public HojaSprites(final String RUTA, final int ANCHO, final int ALTO) {
        this.ALTO = ALTO;
        this.ANCHO = ANCHO;

        this.pixeles = new int[this.ANCHO * this.ALTO];
        
        BufferedImage imagen;
        
        try{
            imagen = ImageIO.read(HojaSprites.class.getResource(RUTA));
            imagen.getRGB(0, 0, ANCHO, ALTO, pixeles, 0, ANCHO);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }

    public int getANCHO() {
        return ANCHO;
    }

}
