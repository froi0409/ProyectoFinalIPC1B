package com.froi;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class Tablero extends JFrame {

    Juego j1;
    private Posicion[][] posicion;
    private int rangox, rangoy, modoDeJuego;
    private JPanel panelBatalla = new JPanel();
    private JButton prueba, prueba2;
    private ImageIcon normal = new ImageIcon("fondos/normal.jpg");
    private ImageIcon montaña = new ImageIcon("iconos/montañas.png");
    private ImageIcon fondoMontaña = new ImageIcon("fondos/fondomontaña.jpg");
    private ImageIcon fondoAgua = new ImageIcon("fondos/fondoagua.jpg");
    private ImageIcon enemigo = new ImageIcon("iconos/enemigo.png");
    private ImageIcon tanque = new ImageIcon("iconos/tanque.png");
    private ImageIcon avion = new ImageIcon("iconos/avion.png");
    private ImageIcon boot = new ImageIcon("iconos/boot.png");
    private ImageIcon comodin = new ImageIcon("iconos/comodin.png");


    public Tablero(int rangox, int rangoy, int modoDeJuego, Juego j1){

        this.j1 = j1;

        this.rangox = rangox;
        this.rangoy = rangoy;
        this.modoDeJuego = modoDeJuego;

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

    private void pintarEscenario(){

        for (int j = 0; j < rangoy; j++){
            for (int i = 0; i < rangox; i++){

                if (posicion[i][j].getObjeto() == 0) {
                    posicion[i][j].setIcon(new ImageIcon(normal.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 1) {
                    posicion[i][j].setIcon(new ImageIcon(fondoMontaña.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                    //posicion[i][j].setIcon(new ImageIcon(montaña.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 2) {
                    posicion[i][j].setIcon(new ImageIcon(fondoAgua.getImage().getScaledInstance(375/rangox, 375/rangoy, Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 3) {
                    posicion[i][j].setBackground(Color.lightGray);
                    posicion[i][j].setIcon(new ImageIcon(enemigo.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 4) {
                    posicion[i][j].setBackground(Color.WHITE);
                    posicion[i][j].setIcon(new ImageIcon(tanque.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 5) {
                    posicion[i][j].setBackground(Color.WHITE);
                    posicion[i][j].setIcon(new ImageIcon(avion.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 6) {
                    posicion[i][j].setBackground(Color.PINK);
                    posicion[i][j].setIcon(new ImageIcon(boot.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 7) {
                    posicion[i][j].setBackground(Color.orange);
                    posicion[i][j].setIcon(new ImageIcon(comodin.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                }
                else if (posicion[i][j].getObjeto() == 8) {
                    posicion[i][j].setBackground(Color.WHITE);
                }

            }
        }

    }

    private void inicializacionDeObjetos(){

        posicion = new Posicion[rangox][rangoy];

        Random rand = new Random();
        boolean all = false;
        int contEnemigo = 0, contSuperficie = 0;


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

        }

        posicion[0][rangoy - 1].setObjeto(8);

    }

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
                                    if (posicion[i][j].getObjeto() == 3)
                                    JOptionPane.showMessageDialog(null, ("Enemigo detectado en coordenadas ( "+i+" , "+j+" )"));
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




}
