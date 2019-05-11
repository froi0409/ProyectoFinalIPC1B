package com.froi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionVehCombate extends JFrame {

    private Juego j1;

    private int jugador, cont = 0;
    private int[] ordenador = new int[3];
    private JPanel panelVehCombate = new JPanel();
    private JButton[] vehiculo;
    private JLabel instruccion;

    public SeleccionVehCombate(Juego j1){

            this.j1 = j1;

            vehiculo = new JButton[j1.getNumVehi(jugador)];
            int y = 115;

            for (int i = 0; i < j1.getNumVehi(jugador); i++) {
                y += 30;
            }
            this.setSize(600, y);
            this.setTitle("BATTLE OF HONOR");
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setLocationRelativeTo(null);

            panel();
    }

    public void panel(){

        this.add(panelVehCombate);
        panelVehCombate.setLayout(null);

        botones();
        label();

    }

    public void botones(){

        int y = 45;

        //configuracion botones vehiculos
        for (int i = 0; i < j1.getNumVehi(jugador); i++){

            vehiculo[i] = new JButton();

            vehiculo[i].setText(j1.getVehiculoEnCombate(jugador, i));
            vehiculo[i].setBounds(100, y, 400, 25);
            panelVehCombate.add(vehiculo[i]);

            y += 30;

        }

        //oyente de accion botones vehiculos
        for (int i = 0; i < j1.getNumVehi(jugador); i++){
            vehiculo[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int j = 0; j < j1.getNumVehi(jugador); j++){

                        if (vehiculo[j] == e.getSource()){

                            ordenador[cont] = j;
                            cont++;
                            vehiculo[j].setEnabled(false);
                            if (cont == 3){
                                irAlCombate();
                            }

                        }

                    }
                }
            });
        }


    }

    public void label(){

    }

    public void setJugador(int jugador){
        this.jugador = jugador;
    }

    private void irAlCombate(){
        for (int i = 0; i < 3; i++) {
            j1.agregarVehiculoACombate(jugador, ordenador[i], i);
        }
        j1.jugar();
        this.setVisible(false);
    }

}
