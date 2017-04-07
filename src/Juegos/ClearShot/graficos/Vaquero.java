package Juegos.ClearShot.graficos;

import Juegos.ClearShot.Juego;



public class Vaquero {


    public void setActivo(Sprite activo) {
        this.activo = activo;
    }
    
    private Sprite activo;
    
    public Vaquero() {
        this.activo = Juego.cowBoy1;
    }
    
    public Vaquero(Sprite activo) {
        this.activo = activo;
    }

    
    
    public Sprite getActivo(){
        return activo;
    }

}
