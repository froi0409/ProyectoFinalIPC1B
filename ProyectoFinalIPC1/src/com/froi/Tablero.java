package com.froi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Tablero extends JFrame {

    protected Juego j1;
    protected Posicion[][] posicion;
    protected int [][] objeto, mov;
    protected int rangox, rangoy, modoDeJuego, vehiculoActivo1 = 0, jugador = 0, detx, dety;
    private JPanel panelBatalla = new JPanel();
    private JButton prueba, prueba2;
    protected JButton[] vehiculos = new JButton[3];
    private Dado dado;
    private ImageIcon normal = new ImageIcon("fondos/normal.jpg");
    private ImageIcon montaña = new ImageIcon("iconos/montañas.png");
    private ImageIcon fondoMontaña = new ImageIcon("fondos/fondomontaña.jpg");
    private ImageIcon fondoAgua = new ImageIcon("fondos/fondoagua.jpg");
    private ImageIcon enemigo = new ImageIcon("iconos/enemigo.png");
    private ImageIcon tanque = new ImageIcon("iconos/tanque.png");
    private ImageIcon avion = new ImageIcon("iconos/avion.png");
    private ImageIcon boot = new ImageIcon("iconos/boot.png");
    private ImageIcon comodin = new ImageIcon("iconos/comodin.png");
    protected Enemigo[] enemigos = new Enemigo[3];


    /**
     * Constructor de Tablero
     * @param rangox -Asigna la cantidad de cuadros que tendrá en X
     * @param rangoy -Asigna la cantidad de cuadros que tendrá en Y
     * @param modoDeJuego -Establece el modo de juego
     * @param j1 -Instancia a clase mayor
     */
    public Tablero(int rangox, int rangoy, int modoDeJuego, Juego j1){

        this.j1 = j1;
        this.rangox = rangox;
        this.rangoy = rangoy;
        this.modoDeJuego = modoDeJuego;
        objeto = new int[rangox][rangoy];
        mov = new int[rangox][rangoy];

        this.setSize(675,475);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        inicializacionDeObjetos();
        agregarPanelBatalla();
        pintarEscenario();
        oyenteDeAccion();

    }

    private void preparaPaneles() {

        this.add(panelBatalla);
        panelBatalla.setVisible(false);
        this.panelBatalla.setLayout(null);


    }

    private void agregarPanelBatalla(){

        preparaPaneles();

        panelBatalla.setVisible(true);
        this.add(this.panelBatalla);
        this.panelBatalla.setLayout(null);
        agregarBotonesBatalla();

    }

    /**
     * Agrega botones de interacción
     * En especial el tablero
     */
    private void agregarBotonesBatalla() {

        int x = 25, y = 25;
        prueba = new JButton("TABLERO");
        prueba.setBounds(25, 25, 400, 400);
        //panelBatalla.add(prueba);

        prueba2 = new JButton("ESPACIO PARA BOTONES");
        prueba2.setBounds(450, 25, 200, 400);
        panelBatalla.add(prueba2);

        prueba2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j1.jugar();
                j1.cerrarTablero();

            }
        });






        for (int j = 0; j < rangoy; j++){
            for (int i = 0; i < rangox; i++){


                posicion[i][j].setBounds(x, y, 375/rangox, 375/rangoy);

                panelBatalla.add(posicion[i][j]);
                x += (375/rangox);
            }

            y += (375/rangoy);
            x = 25;
        }


    }

    /**
     * Asigna aspecto visual a los botones del tablero
     */
    private void pintarEscenario(){

        for (int j = 0; j < rangoy; j++){
            for (int i = 0; i < rangox; i++){

                posicion[i][j].setEnabled(true);

                if (posicion[i][j].getObjeto() == 3) {
                    posicion[i][j].setBackground(Color.lightGray);
                    posicion[i][j].setIcon(new ImageIcon(enemigo.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (objeto[i][j] == 4) {
                    posicion[i][j].setBackground(Color.WHITE);
                    posicion[i][j].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (objeto[i][j] == 5) {
                    posicion[i][j].setBackground(Color.WHITE);
                    System.out.println();
                    posicion[i][j].setIcon(new ImageIcon(avion.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (objeto[i][j] == 6) {
                    posicion[i][j].setBackground(Color.PINK);
                    posicion[i][j].setIcon(new ImageIcon(boot.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (objeto[i][j] == 7) {
                    posicion[i][j].setBackground(Color.orange);
                    posicion[i][j].setIcon(new ImageIcon(comodin.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 8) {
                    posicion[i][j].setBackground(Color.WHITE);
                }
                else if (posicion[i][j].getObjeto() == 0) {
                    posicion[i][j].setIcon(new ImageIcon(normal.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 1) {
                    posicion[i][j].setIcon(new ImageIcon(fondoMontaña.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                    //posicion[i][j].setIcon(new ImageIcon(montaña.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 2) {
                    posicion[i][j].setIcon(new ImageIcon(fondoAgua.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }

            }
        }

    }

    /**
     * Inicializa y determina el tipo de terreno que tendrá cada cuadro del tablero.
     * Inicializa y determina la posición de los enemigos
     */
    private void inicializacionDeObjetos(){

        posicion = new Posicion[rangox][rangoy];

        Random rand = new Random();

        for (int j = 0; j < rangoy; j++){
            for (int i = 0; i < rangox; i++){
                posicion[i][j] = new Posicion();
            }
        }

        for (int j = 0; j < rangoy; j++){
            for (int i = 0; i < rangox; i++){

                int n = rand.nextInt(150);

                if (n < 25)
                    posicion[i][j].setObjeto(1);
                else if (n > 25 && n < 50)
                    posicion[i][j].setObjeto(2);
                else
                    posicion[i][j].setObjeto(0);

            }
        }

        for (int i = 0; i < 3; i++){

                int a = rand.nextInt(rangox - 2), b = rand.nextInt(rangoy - 2);

                    posicion[a + 1][b + 1].setObjeto(3);
                    enemigos[i] = new Enemigo(this, a+1, b+1, i);

        }
        System.out.println(j1.getTipoDeVehiculoCombate(0, 0));


        objeto[0][rangoy - 1] = j1.getTipoDeVehiculoCombate(0, 0);
        if (j1.getModoDeJuego() == 1){
            objeto[rangox - 1][0] = j1.getTipoDeVehiculoCombate(1, 0);
        }
    }

    /**
     * Lee los 'click' que se le den al tablero
     */
    private void oyenteDeAccion(){

        for (int l = 0; l < rangoy; l++){
            for (int k = 0; k < rangox; k++){

                posicion[k][l].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        for (int j = 0; j < rangoy; j++){
                            for (int i = 0; i < rangox; i++){

                                if (posicion[i][j] == e.getSource()){
                                    System.out.println(i + "   " + j);
                                    if (objeto[i][j] == 4 || objeto[i][j] == 5) {
                                        accion1(i, j);
                                        posicion[i][j].setEnabled(false);
                                        detx = i;
                                        dety = j;
                                    }
                                    else{
                                        movimiento(i, j, detx, dety);
                                    }
                                    if (posicion[i][j].getObjeto() == 3)
                                        JOptionPane.showMessageDialog(null, ("Enemigo detectado en coordenadas ( "+i+" , "+j+" )"));
                                    turnoEnemigo();
                                }

                            }
                        }

                    }
                });

            }
        }

    }

    public void agregarObjetos (int x, int y, int object) {

        posicion[x - 1][y - 1].setObjeto(object);

    }

    /**
     * Crea un hilo coloreando los espacios en los cuales se podrá mover el vehículo
     * @param x
     * @param y
     */
    public void accion1(int x, int y){

        int num;
        dado = new Dado(6);
        num = dado.getNumero();
        hilo hh1 = new hilo(this, x, y, rangox, rangoy, num, j1);

        hh1.run();

    }

    /**
     * Lleva a cabo el movimiento de un vehículo
     * @param x -X final
     * @param y -Y final
     * @param xo -X inicial
     * @param yo -Y final
     */
    public void movimiento(int x, int y, int xo, int yo){

                if (mov[x][y] == 9){

                    objeto[x][y] = objeto[xo][yo];
                    objeto[xo][yo] = posicion[xo][yo].getObjeto();
                    pintarEscenario();

                    for (int j = 0; j < rangoy; j++){
                        for (int i = 0; i < rangox; i++){

                            mov[i][j] = 0;

                        }
                    }

                }

    }

    public void turnoEnemigo(){

        for(int i = 0; i < 3; i++){

            enemigos[i].deteccionDeVehículos();

        }

    }


}
