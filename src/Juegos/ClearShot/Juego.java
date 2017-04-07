package Juegos.ClearShot;

import Juegos.ClearShot.controles.Teclado;
import Juegos.ClearShot.graficos.HojaSprites;
import Juegos.ClearShot.graficos.Pantalla;
import Juegos.ClearShot.graficos.Sprite;
import Juegos.ClearShot.graficos.Vaquero;
import herramientas.Sonido;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class Juego extends Canvas implements Runnable {

    private static final int ANCHO = 720;
    private static final int ALTO = 480;
    private static final String NOMBRE = "CLEAR SHOT";

    private static int aps = 0;
    private static int fps = 0;

    private static int x = 0;
    private static int y = 0;
    private static Pantalla pantalla;
    private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
    private static Image background;
    private static Image jugaorGanador;
    private static int[] pixeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
    Vaquero vaquero = new Vaquero();
    boolean ganador = false;
    boolean end = false;
    private static JFrame ventana;
    private static Clip clip;
    private static Thread thread;
    private static volatile boolean corriendo = false;
    private static Teclado teclado;

    public static Sprite cowBoy1 = new Sprite(64, 0, 0, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy2 = new Sprite(64, 1, 0, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy3 = new Sprite(64, 2, 0, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy4 = new Sprite(64, 3, 0, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy5 = new Sprite(64, 0, 1, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy6 = new Sprite(64, 1, 1, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoy7 = new Sprite(64, 2, 1, HojaSprites.cowBoyMovimientos);
    public static Sprite cowBoyMurido = new Sprite(64, 2, 3, HojaSprites.cowBoyMovimientos);
    int animacion = 0;

    private Juego() {
        try {
            setPreferredSize(new Dimension(ANCHO, ALTO));
            
            clip  = Sonido.cargaSonido("/ClearShot/Audio/YesLoop.wav");
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            
            pantalla = new Pantalla(ANCHO, ALTO);

            teclado = new Teclado();
            addKeyListener(teclado);

            ventana = new JFrame(NOMBRE);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setResizable(false);
            ventana.setLayout(new BorderLayout());
            ventana.add(this, BorderLayout.CENTER);
            ventana.pack();
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Juego juego = new Juego();
        juego.iniciar();
    }

    private void iniciar() {
        corriendo = true;
        thread = new Thread(this, "Graficos");
        thread.start();
    }

    private void detener() {
        corriendo = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    private void finalizar() {
        if(teclado.fin){
            clip.close();
            ventana.dispose();
            teclado.Song.close();
            System.exit(0); 
            detener();
        }
    }

    private void actualizar() {
        teclado.actualizar();
        aps++;
    }

    private void mostrar() {
        BufferStrategy estrategia = getBufferStrategy();
        int jugador = -10;
        if (animacion < 32767) {
            animacion++;
        } else {
            animacion = 0;
        }
        if (estrategia == null) {
            createBufferStrategy(3);
            return;
        }
        if (teclado.disparo1) {
            ganador = true;
            jugador = 1;
        }
        if (teclado.disparo2) {
            ganador = true;
            jugador = 2;
        }
        pantalla.limpiar();
        Graphics g = estrategia.getDrawGraphics();
        pantalla.mostrarfondo(ANCHO, ALTO);
        if (!ganador) {
            int residuo = animacion % 25;
            if (residuo > 5 && residuo <= 10) {
                pantalla.mostrarVaquero(50, 400, (cowBoy1));
                pantalla.mostrarVaquero2(400, 50, (cowBoy1));
            } else if (residuo > 10 && residuo <= 15) {
                pantalla.mostrarVaquero(50, 400, (cowBoy2));
                pantalla.mostrarVaquero2(400, 50, (cowBoy2));
            } else if (residuo > 15 && residuo <= 20) {
                pantalla.mostrarVaquero(50, 400, cowBoy3);
                pantalla.mostrarVaquero2(400, 50, (cowBoy3));
            } else if (residuo > 20 && residuo <= 25) {
                pantalla.mostrarVaquero(50, 400, (cowBoy4));
                pantalla.mostrarVaquero2(400, 50, (cowBoy4));
            } else {
                pantalla.mostrarVaquero(50, 400, (cowBoy5));
                pantalla.mostrarVaquero2(400, 50, (cowBoy5));
            }

        } else {
            clip.close();
            if (jugador == 1) {
                int residuo = animacion % 9;
                if (residuo > 3 && residuo <= 6) {
                    pantalla.mostrarVaquero(50, 400, (cowBoy5));
                    pantalla.mostrarVaquero2(400, 50, (cowBoyMurido));
                } else if (residuo > 6 && residuo <= 9) {
                    pantalla.mostrarVaquero(50, 400, (cowBoy6));
                    pantalla.mostrarVaquero2(400, 50, (cowBoyMurido));
                } else {
                    pantalla.mostrarVaquero(50, 400, (cowBoy7));
                    pantalla.mostrarVaquero2(400, 50, (cowBoyMurido));
                    end = true;
                }
            } else if (jugador == 2) {
                int residuo = animacion % 9;
                if (residuo > 3 && residuo <= 6) {
                    pantalla.mostrarVaquero2(400, 50, (cowBoy5));
                    pantalla.mostrarVaquero(50, 400, (cowBoyMurido));
                } else if (residuo > 6 && residuo <= 9) {
                    pantalla.mostrarVaquero2(400, 50, (cowBoy6));
                    pantalla.mostrarVaquero(50, 400, (cowBoyMurido));
                } else {
                    pantalla.mostrarVaquero2(400, 50, (cowBoy7));
                    pantalla.mostrarVaquero(50, 400, (cowBoyMurido));
                    end = true;
                }
            }
        }

        System.arraycopy(pantalla.pixeles, 0, pixeles, 0, pixeles.length);
        g.drawImage(background, -250, 0, this);

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);

        g.dispose();
        estrategia.show();
        fps++;

        if (end) {
            pantalla.ganar(ANCHO, ALTO);
            finalizar();
        }
    }

    @Override
    public void run() {
        final int NS_POR_SEGUNDO = 1000000000;
        final byte APS_OBJETIVO = 60;
        final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

        long referenciaActualizacion = System.nanoTime();
        long referenciaContador = System.nanoTime();

        double tiempoTranscurrido = 0;
        double delta = 0;

        requestFocus();

        while (corriendo) {
            final long inicioBucle = System.nanoTime();

            tiempoTranscurrido = inicioBucle - referenciaActualizacion;
            referenciaActualizacion = inicioBucle;

            delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;
            while (delta >= 1) {
                actualizar();
                mostrar();
                delta--;
            }

            if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDO) {
                ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS: " + fps);
                aps = 0;
                fps = 0;
                referenciaContador = System.nanoTime();
            }
        }
    }

}
