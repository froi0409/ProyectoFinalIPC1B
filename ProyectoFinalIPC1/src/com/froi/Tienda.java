package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Tienda extends JFrame {

    private Juego j1;
    private JButton[] vehiculos, armas;
    private JButton boot, salir;
    private JLabel labelDinero, instruccion, labelComprador, labelVehiculo;
    private JComboBox comprador = new JComboBox();
    private JComboBox vehiculo = new JComboBox();
    private JPanel panelTienda = new JPanel();
    private int[] veh, arm;
    protected int contv = 0, contA = 0;



    public Tienda(Juego j1){

        this.j1 = j1;
        int y = 195;
        veh = new int[j1.getVehiculosTotales()];
        arm = new int[j1.getNumeroArmas()];

        for (int i = 0; i < j1.getNumeroArmas(); i++){
            y += 30;
        }
        y += 20;
        for (int i = 0; i < j1.getVehiculosTotales(); i++){
            y += 30;
        }

        this.setSize(600, y);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel();

    }

    private void panel(){

        this.add(panelTienda);
        panelTienda.setLayout(null);
        comboBox();
        botones();
        labels();

    }

    private void botones(){

        boot = new JButton("Boot - $50.00");
        boot.setBounds(100, 105, 400, 25);
        panelTienda.add(boot);

        //oyente de acción botón boot
        boot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (j1.getDinero(comprador.getSelectedIndex()) >= 50) {
                    JOptionPane.showMessageDialog(null, "Boot comprado por jugador " + j1.getGamerNombre(comprador.getSelectedIndex()));
                    j1.comprar(comprador.getSelectedIndex(), 50);
                    j1.agregarBoot(comprador.getSelectedIndex());
                    labelDinero.setText("Dinero: $" + j1.getDinero(comprador.getSelectedIndex()) + "0");
                }
                else {
                    JOptionPane.showMessageDialog(null, "NO TIENE DINERO SUFICIENTE");
                }

            }
        });


        vehiculos = new JButton[j1.getVehiculosTotales()];

        int y = 135;

        for (int i = 0; i < j1.getVehiculosTotales(); i++){
            vehiculos[i] = new JButton(j1.getNombre(i));

            if (j1.getTipoDeVehiculo(i) == 4)
                vehiculos[i].setText("Tanque " + j1.getNombre(i) + " - $50.00");
            else
                vehiculos[i].setText("Avion " + j1.getNombre(i) + " - $45.00");
            vehiculos[i].setBounds(100, y, 400, 25);
            panelTienda.add(vehiculos[i]);

            y += 30;

        }

        //oyente de Accion botonesVehiculos
        for (int j = 0; j < j1.getVehiculosTotales(); j++){
            vehiculos[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < j1.getVehiculosTotales(); i++){

                        if (vehiculos[i] == e.getSource()){

                            if (j1.getTipoDeVehiculo(i) == 4){

                                if (j1.getDinero(comprador.getSelectedIndex()) >= 50){

                                    JOptionPane.showMessageDialog(null, "Tanque " + j1.getNombre(i) + " comprado por jugador " + j1.getGamerNombre(comprador.getSelectedIndex()));
                                    j1.comprar(comprador.getSelectedIndex(), 50);
                                    j1.setVG(comprador.getSelectedIndex(), i);
                                    veh[contv] = i;
                                    labelDinero.setText("Dinero: $" + j1.getDinero(comprador.getSelectedIndex()) + "0");
                                    vehiculos[i].setEnabled(false);
                                    contv++;

                                }
                                else{

                                    JOptionPane.showMessageDialog(null, "NO TIENE DINERO SUFICIENTE");

                                }

                            }
                            else {

                                if (j1.getDinero(comprador.getSelectedIndex()) >= 45){

                                    JOptionPane.showMessageDialog(null, "Avión " + j1.getNombre(i) + " comprado por jugador " + j1.getGamerNombre(comprador.getSelectedIndex()));
                                    j1.comprar(comprador.getSelectedIndex(), 45);
                                    j1.setVG(comprador.getSelectedIndex(), i);
                                    veh[contv] = i;
                                    System.out.println();
                                    labelDinero.setText("Dinero: $" + j1.getDinero(comprador.getSelectedIndex()) + "0");
                                    vehiculos[i].setEnabled(false);
                                    contv++;


                                }
                                else{

                                    JOptionPane.showMessageDialog(null, "NO TIENE SUFICIENTE DINERO");

                                }

                            }

                        }

                    }
                }
            });
        }


        //configuración botonesArmas
        armas = new JButton[j1.getNumeroArmas()];
        for (int i = 0; i < j1.getNumeroArmas(); i++){
            armas[i] = new JButton("Arma " + j1.getNombreArma(i) + " - $" + j1.getPrecioArma(i) + "0");
            armas[i].setBounds(100, y, 400, 25);
            panelTienda.add(armas[i]);

            y+= 30;

        }

        //oyente de accion botonesArmas
        for (int j = 0; j < j1.getNumeroArmas(); j++){

            armas[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for (int i = 0; i < j1.getNumeroArmas(); i++){

                        if (armas[i] == e.getSource()){

                            if (j1.getDinero(comprador.getSelectedIndex()) >= j1.getPrecioArma(i)){

                                JOptionPane.showMessageDialog(null, "Arma " + j1.getNombreArma(i) + " establecida a vehiculo " + j1.getNombreDeVehiculo(comprador.getSelectedIndex(), vehiculo.getSelectedIndex()) + " de jugador " + j1.getGamerNombre(comprador.getSelectedIndex()));
                                j1.comprar(comprador.getSelectedIndex(), j1.getPrecioArma(i));
                                j1.setAG(comprador.getSelectedIndex(), vehiculo.getSelectedIndex(), i);
                                arm[contA] = i;
                                labelDinero.setText("Dinero: $" + j1.getDinero(comprador.getSelectedIndex()) + "0");
                                armas[i].setEnabled(false);
                                contA++;

                            }
                            else {

                                JOptionPane.showMessageDialog(null, "NO TIENE SUFICIENTE DINERO");

                            }

                        }

                    }

                }
            });

        }



        //configuracion botón salir
        salir = new JButton("SALIR DE LA TIENDA");
        salir.setBounds(100, y, 400, 25);
        panelTienda.add(salir);

        //oyende de acción botón salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                desplazamiento();
                j1.jugar();
                j1.cerrarTienda();

            }
        });


    }

    private void labels(){

        labelComprador = new JLabel("Comprador:");
        labelComprador.setOpaque(true);
        labelComprador.setHorizontalAlignment(SwingConstants.LEFT);
        labelComprador.setFont(new Font("default", Font.PLAIN, 15));
        labelComprador.setBounds(100, 35, 200, 15);
        panelTienda.add(labelComprador);

        labelVehiculo = new JLabel("Vehiculo");
        labelVehiculo.setOpaque(true);
        labelVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
        labelVehiculo.setFont(new Font("default", Font.PLAIN, 15));
        labelVehiculo.setBounds(300, 35, 200, 15);
        panelTienda.add(labelVehiculo);

        instruccion = new JLabel("Seleccione el articulo a comprar");
        instruccion.setOpaque(true);
        instruccion.setHorizontalAlignment(SwingConstants.LEFT);
        instruccion.setFont(new Font("default", Font.PLAIN, 15));
        instruccion.setBounds(100, 90, 400, 15);
        panelTienda.add(instruccion);

        labelDinero = new JLabel("Dinero: $0.00");
        labelDinero.setOpaque(true);
        labelDinero.setHorizontalAlignment(SwingConstants.LEFT);
        labelDinero.setBounds(100, 10, 400, 20);
        labelDinero.setFont(new Font("default", Font.BOLD, 20));
        panelTienda.add(labelDinero);
    }

    private void comboBox(){

        panelTienda.add(comprador);
        comprador.setBounds(100, 50, 200, 25);
        for (int i = 0; i < j1.getNumeroGamers(); i++){
            comprador.addItem(j1.getGamerNombre(i));
        }

        //oyente de acción comboBox comprador
        comprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                labelDinero.setText("Dinero: $" + j1.getDinero(comprador.getSelectedIndex()) + "0");

                vehiculo.removeAllItems();
                for (int i = 0; i < j1.getCantidadDeVehiculos(comprador.getSelectedIndex()); i++){
                    vehiculo.addItem(j1.getNombreDeVehiculo(comprador.getSelectedIndex(), i));
                }
            }
        });




        panelTienda.add(vehiculo);
        vehiculo.setBounds(300, 50, 200, 25);


    }

    private void desplazamiento(){

        for (int i = 0; i < contv - 1; i++){
            for (int j = 0; j < contv - 1; j++){

                if (veh[j] > veh[j + 1]){

                    int tmp = veh[j+1];
                    veh[j+1] = veh[j];
                    veh[j] = tmp;

                }

            }
        }

        for (int i = 0; i < contA - 1; i++){
            for (int k = 0; k < contA - 1; k++){

                if (arm[k] > arm[k + 1]){

                    System.out.println();
                    int aux = arm[k+1];
                    arm[k+1] = arm[k];
                    arm[k] = aux;

                }

            }
        }

        for (int i = 0; i < contv; i++){
            j1.desplazarVehiculo(veh[i]);
        }

        for (int i = 0; i < contA; i++){
            j1.desplazarArmas(arm[i]);
        }

    }
}
