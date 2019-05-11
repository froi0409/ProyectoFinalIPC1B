package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionDeVehiculos extends JFrame {

    Juego j1;

    private int cont = 0, posicion;
    private int[] cambios;
    private JPanel panelSeleccion = new JPanel();
    private JLabel labelSeleccion;
    private JButton[] vehi;
    private JButton finalizar;

    public SeleccionDeVehiculos(Juego j1){

        cambios = new int[j1.getVehiculosTotales()];

        int x = 600, y = 115;
        this.j1 = j1;
        panel();

        for (int i = 0; i < j1.getVehiculosTotales(); i++){
            y += 30;
        }

        System.out.println(x + " " + y);
        this.setSize(x, y);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);


    }

    private void panel(){

        this.add(panelSeleccion);
        panelSeleccion.setLayout(null);
        botones();
        label();

    }

    private void botones(){



        int x = 100, y = 40, bot;

        //Configuracion botones de los vehiculos
        vehi = new JButton[j1.getVehiculosTotales()];
        for (int i = 0; i < j1.getVehiculosTotales(); i++){

            vehi[i] = new JButton(j1.getNombre(i));

            vehi[i].setBounds(x, y, 400, 25);
            panelSeleccion.add(vehi[i]);

            y += 30;

        }

        //oyente de accion botones
        for (int i = 0; i < j1.getVehiculosTotales(); i++){
            vehi[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (int j = 0; j < j1.getVehiculosTotales(); j++){

                    }

                    for (int j = 0; j < j1.getVehiculosTotales(); j++){
                        if (vehi[j] == e.getSource()){

                            cambios[cont] = j;

                            cont++;

                            vehi[j].setEnabled(false);

                            System.out.println(j);

                        }
                    }

                }
            });
        }


        //Configuracion botón finalizar
        finalizar = new JButton("FINALIZAR");
        finalizar.setBounds(100, y, 400, 25);
        panelSeleccion.add(finalizar);

        //oyente de accion boton finalizar
        finalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (cont >= 3) {

                    for (int i = 0; i < cont; i++) {

                        j1.setVG((j1.getNumeroGamers() - 1), cambios[i]);

                    }
                    int cont2 = 0;
                    for (int i = 0; i < cont; i++) {

                        j1.desplazarVehiculo(cambios[i] - cont2);
                        cont2++;

                    }

                    System.out.println(j1.getVehiculosTotales());

                    if ((j1.getCantVehi(j1.getNumeroGamers() - 1) >= 3)) {

                        System.out.println("VEHICULOS ESTABLECIDOS!!!");

                        if (j1.getTipoCreacion() == 0) {

                            JOptionPane.showMessageDialog(null, "¡JUGADOR CREADO CON EXITO!");
                            j1.jugar();
                            j1.cerrarSeleccionDeVehiculos();
                        }
                    }

                }
                else {

                    JOptionPane.showMessageDialog(null, "El jugador debe tener un minimo de 3 vehiculos");

                }
            }
        });

    }

    private void label(){
        labelSeleccion = new JLabel("Seleccione los vehículos que le asignara al jugador:");
        labelSeleccion.setOpaque(true);
        labelSeleccion.setBounds(100, 20, 400, 15);
        labelSeleccion.setFont(new Font("default", Font.PLAIN, 15));
        labelSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        panelSeleccion.add(labelSeleccion);
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
}
