package Juegos.ClearShot.graficos;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pantalla {

    private final int ancho;
    private final int alto;
    private final BufferedImage imagen;
    private final BufferedImage imagenGanadora;

    public final int[] pixeles;

    private int diferenciaX;
    private int diferenciaY;

    public Pantalla(final int ancho, final int alto) throws IOException {
        this.ancho = ancho;
        this.alto = alto;

        BufferedImage imagen = ImageIO.read(HojaSprites.class.getResource("/ClearShot/westeradowallpaper.png"));
        BufferedImage imagenGanadora = ImageIO.read(HojaSprites.class.getResource("/ClearShot/YouWin.png"));
        this.imagen = imagen;
        this.imagenGanadora = imagenGanadora;

        pixeles = new int[ancho * alto];
    }

    public void limpiar() {
        for (int i = 0; i < pixeles.length; i++) {
            pixeles[1] = 0;
        }
    }

    public void mostrarVaquero(int compensacionX, int compensacionY, Sprite cuadro) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for (int y = 0; y < cuadro.getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.getLado(); x++) {
                int posicionX = x + compensacionX;
                if (posicionX < -cuadro.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                int colorPixelVaquero = cuadro.pixeles[x + y * cuadro.getLado()];
                if (colorPixelVaquero != 0xffff00ff) {
                    pixeles[posicionX + posicionY * ancho] = colorPixelVaquero;
                }
                //pixeles[posicionX + posicionY * ancho] = cuadro.pixeles[x + y * cuadro.getLado()];
            }
        }
    }

    public void mostrarVaquero2(int compensacionX, int compensacionY, Sprite cuadro) {
        compensacionX -= diferenciaX;
        compensacionY -= diferenciaY;

        for (int y = 0; y < cuadro.getLado(); y++) {
            int posicionY = y + compensacionY;
            for (int x = 0; x < cuadro.getLado(); x++) {
                int posicionX = x + compensacionX;
               if (posicionX < -cuadro.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                int colorPixelVaquero = cuadro.pixeles[y + x * cuadro.getLado()];
                if (colorPixelVaquero != 0xffff00ff) {
                    if (colorPixelVaquero == 0xffFFDCAF || colorPixelVaquero == 0xffE9B37A || colorPixelVaquero == 0xffE9B37A || colorPixelVaquero == 0xff231404 || colorPixelVaquero == 0xffC1965F ) {
                        pixeles[ - posicionY  + posicionX * ancho] = colorPixelVaquero;
                    } else {
                        pixeles[ - posicionY + posicionX * ancho] = colorPixelVaquero ;
                    }
                }
                //pixeles[posicionX + posicionY * ancho] = cuadro.pixeles[x + y * cuadro.getLado()];
            }
        }
    }

    public void mostrarfondo(int ANCHO, int ALTO) {
        imagen.getRGB(260, 0, ANCHO, ALTO, pixeles, 0, ANCHO);
    }

    public void ganar(int ANCHO, int ALTO) {
        int[] colores = new int[ALTO*ANCHO];
        
        imagen.getRGB(0, 0, ANCHO, ALTO, pixeles, 0, ANCHO);
        /* for (int y = 0; y < ALTO; y++) {
            int posicionY = y ;
            for (int x = 0; x < ANCHO; x++) {
                int posicionX = x;
                if (posicionX < ancho || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
                    break;
                }
                if (posicionX < 0) {
                    posicionX = 0;
                }
                int colorPixelLetrero = colores[x + y * ANCHO];
                if (colorPixelLetrero != 0xffffffff) {
                    pixeles[posicionX + posicionY * ancho] = colorPixelLetrero;
                }
            }
        }*/
    }
}
