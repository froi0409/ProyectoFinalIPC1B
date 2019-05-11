package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionDeJugador extends JFrame {

    private Juego j1;

    private JButton[] per;
    private JPanel panelSeleccion = new JPanel();
    private JLabel labelInicio;

    public SeleccionDeJugador(Juego j1){

        this.j1 = j1;
        int y = 115;

        for (int i = 0;  i < j1.getNumeroGamers(); i++){
            y += 30;
        }

        this.setSize(600, y);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel();


    }

    private void panel(){

        this.add(panelSeleccion);
        panelSeleccion.setLayout(null);
        botones();
        label();

    }

    private int cont = 0;

    private void botones(){

        int y = 40, a;
        per = new JButton[j1.getNumeroGamers()];
        System.out.println("Num Jugadores: " + j1.getNumeroGamers());
        for (int i = 0; i < j1.getNumeroGamers(); i++){

            per[i] = new JButton();
            per[i].setText(j1.getGamerNombre(i));
            per[i].setBounds(100, y, 400, 25);
            panelSeleccion.add(per[i]);

            y += 30;

        }
        //oyente de accion
        for (int i = 0; i < j1.getNumeroGamers(); i++){
            per[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    cont++;
                    for (int j = 0; j < j1.getNumeroGamers(); j++){
                        if (j1.getModoDeJuego() == 0) {
                            if (per[j] == e.getSource()) {
                                j1.agregarAlCombate(j);
                                if (j1.getNumVehi(0) == 3) {
                                    j1.jugar();
                                    j1.cerrarSeleccionDeJugador();
                                }
                                else{
                                    j1.abrirAgregarVehCombate(0);
                                    j1.cerrarSeleccionDeJugador();
                                }
                            }
                        }
                        else{
                            if (per[j] == e.getSource()) {
                                per[j].setEnabled(false);
                                j1.agregarAlCombate(j);
                                if (cont == 2) {
                                    labelInicio.setText("Seleccione al Jugador 2");
                                    j1.jugar();
                                    j1.cerrarSeleccionDeJugador();
                                }
                                if (j1.getNumVehi(cont - 1) != 3){
                                    j1.abrirAgregarVehCombate(cont - 1);
                                    j1.cerrarSeleccionDeJugador();
                                }
                            }
                        }

                    }
                }
            });
        }

    }

    private void label(){

        int a;
        a = cont + 1;
        labelInicio = new JLabel("Seleccione al Jugador 1");
        labelInicio.setOpaque(true);
        labelInicio.setHorizontalAlignment(SwingConstants.LEFT);
        labelInicio.setBounds(100, 25, 400, 15);
        labelInicio.setFont(new Font("default", Font.PLAIN, 15));
        panelSeleccion.add(labelInicio);


    }

}
