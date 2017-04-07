package Juegos.ClearShot.graficos;


public class Sprite {

    public int getLado() {
        return lado;
    }
    private final int lado;
    private int x;
    private int y;
    
    public int[] pixeles;
    private final HojaSprites hoja;
    
    public Sprite(final int lado, final int columna, final int fila, final HojaSprites hoja){
        this.lado = lado;
        
        pixeles = new int[lado*lado];
        
        this.hoja = hoja;
        this.x = columna*lado;
        this.y = fila*lado;
        
        for (int y = 0; y < lado; y++) {
            for (int x = 0; x < lado; x++) {
                pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getANCHO()];
            }
        }
    }
}
