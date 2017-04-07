package ocaaldini;

/**
 *
 * @author Bugisoft
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TableroGUI extends JFrame implements ActionListener, Runnable {

    private JFrame table;
    private JButton dados;
    int dado, numJugadores, turno;
    public int xv, yv, xr, yr;
    private ArrayList<Ficha> fichas= new ArrayList<>();
    private ArrayList<Casilla> casillas;
    private Thread hilo;

    private boolean terminaTurno;

    private int casx, casy;

    public TableroGUI() {
        xv = 150;
        yv = 430;
    }

    public void crearTablero(int numJugadores) {
        table = new JFrame("Oca chidisima");
        this.numJugadores = numJugadores;

        table.setSize(1280, 720);
        table.setContentPane(new JLabel(new ImageIcon("Imagenes/Tablero.png")));
        table.setLocationRelativeTo(null);
        table.setLayout(null);
        table.setResizable(false);
        table.setDefaultCloseOperation(table.EXIT_ON_CLOSE);

        dados = new JButton();
        ImageIcon icon = new ImageIcon("Imagenes/Dados.png");
        dados.setIcon(icon);
        dados.addActionListener(this);
        dados.setSize(180, 75);
        dados.setLocation(250, 320);
        dados.setVisible(true);

        hilo = new Thread(this);

        table.add(dados);
        CrearCasillas();
        CrearJugadores();
        iniciaJuego();
        table.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dados) {
            terminaTurno = true;
            dado = (int) Math.floor(Math.random() * (7 - 1) + 1);
            System.out.println(dado);

        }
    }

    @Override
    public void run() {
        boolean end = false;
        int turno = 0;
        while (!end) {
            turno++;
            this.turno = turno;
            while (!terminaTurno) {
                System.out.println("Es el turno del jugador: " + this.turno);
                try {
                    hilo.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TableroGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            terminaTurno = false;
            if (turno == numJugadores) {
                turno = 0;
            }
        }
    }

    private void CrearCasillas() {
        casillas = new ArrayList<>();
        casx = 88;
        casy = 581;
        int casillavar = 1;
        for (int i = 0; i <= 6; i++) {
            if(i == 32){
                casillavar = 6;
            }
            if(i == 31){
                casillavar = 5;
            }
            Casilla casillita = new Casilla(casillavar, i, casx, casy, table);
            casx = casx + 105; 
            casillas.add(casillita);
            casillavar ++;
            if(casillavar == 5){
                casillavar = 2;
            }
        }
    }
    
    private void CrearJugadores(){
        for(int i = 1; i <= numJugadores; i++){
            Ficha jugador = new Ficha(i,0,casillas);
            casillas.get(0).añadeFicha(jugador);
            fichas.add(jugador);
        }
    }

    public void iniciaJuego() {
        hilo.start();
    }

}
