package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionDeVehiculo extends JFrame {

    private Juego j1;

    /*
    0. Creacion desde Menú.
    1. Creacion por falta de vehiculos (en menú crear jugador)
     */
    private int tipoCreacion;
    private JPanel panelCreacionVechiculo = new JPanel();
    private JTextField nombre;
    private JButton tanque, avion, salir;
    private JLabel labelNombre, labelSeleccion, labelPrincipal;

    public CreacionDeVehiculo(Juego j1, int tipoCreacion) {

        this.j1 = j1;
        this.tipoCreacion = tipoCreacion;

        this.setSize(600, 300);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel();

    }

    private void panel(){

        this.add(panelCreacionVechiculo);
        panelCreacionVechiculo.setLayout(null);

        textfield();
        botones();
        labels();

    }

    private void textfield(){

        nombre = new JTextField();
        nombre.setBounds(100, 100, 400, 25);
        panelCreacionVechiculo.add(nombre);

    }

    private void botones(){

        //Configuracion botón tanque
        tanque = new JButton("TANQUE");
        tanque.setBounds(100, 150, 200, 45);
        panelCreacionVechiculo.add(tanque);

        //oyente de accion botón tanque
        tanque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nombre.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Ingrese nombre del vehiculo");
                }
                else{
                    vehiculoCreado(nombre.getText(), 4);
                    nombre.setText("");
                    j1.getVehiculo(j1.getVehiculosTotales() - 1);
                }

            }
        });


        //Configuracion boton avion
        avion = new JButton("AVION");
        avion.setBounds(300, 150, 200, 45);
        panelCreacionVechiculo.add(avion);

        //Oyente de accion botón avion
        avion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (nombre.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre del vehiculo");
                }
                else {
                    vehiculoCreado(nombre.getText(), 5);
                    nombre.setText("");
                    j1.getVehiculo(j1.getVehiculosTotales() - 1);
                }

            }
        });


        //Configuracion boton salir
        salir = new JButton("SALIR DE CREACION DE VEHICULOS");
        salir.setBounds(100, 200, 400, 45);
        panelCreacionVechiculo.add(salir);

        //Oyente de accion boton salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tipoCreacion == 0){
                    j1.jugar();
                    j1.cerrarCreacionDeVehiculos();
                }
                else if (tipoCreacion == 1){

                    if (j1.getVehiculosTotales() >= 3){
                        j1.abrirSeleccionDeVehiculos();
                        j1.cerrarCreacionDeVehiculos();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Se necesitan 3 vehiculos como mínimo para un jugador");
                    }

                }
            }
        });

    }

    private void labels() {

        labelPrincipal = new JLabel();
        labelPrincipal.setOpaque(true);
        labelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
        labelPrincipal.setText("INGRESE LOS DATOS");
        labelPrincipal.setFont(new Font("default", Font.PLAIN, 25));
        labelPrincipal.setBounds(100, 30, 400, 25);
        panelCreacionVechiculo.add(labelPrincipal);

        labelNombre = new JLabel("Nombre del vehículo");
        labelNombre.setOpaque(true);
        labelNombre.setHorizontalAlignment(SwingConstants.LEFT);
        labelNombre.setFont(new Font("default", Font.PLAIN, 15));
        labelNombre.setBounds(100, 85, 400, 15);
        panelCreacionVechiculo.add(labelNombre);

        labelSeleccion = new JLabel("Elija el tipo del vehículo");
        labelSeleccion.setOpaque(true);
        labelSeleccion.setHorizontalAlignment(SwingConstants.LEFT);
        labelSeleccion.setFont(new Font("default", Font.PLAIN, 15));
        labelSeleccion.setBounds(100, 130, 400, 15);
        panelCreacionVechiculo.add(labelSeleccion);

    }

    private void vehiculoCreado(String nom, int tip){

        j1.creacionDeVehiculo(nom, tip);

    }

    public void setTipoCreacion(int tipoCreacion) {
        this.tipoCreacion = tipoCreacion;
    }
}
