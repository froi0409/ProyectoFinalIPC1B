package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tienda extends JFrame {

    private Juego j1;
    private JButton[] vehiculos, armas;
    private JButton boot;
    private JLabel comprarBoot, comprarVehículos, comprarArmas, instruccion, labelComprador, labelVehiculo;
    private JComboBox comprador = new JComboBox();
    private JComboBox vehiculo = new JComboBox();
    private JPanel panelTienda = new JPanel();



    public Tienda(Juego j1){

        this.j1 = j1;
        int y = 145;

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
        boot.setBounds(100, 85, 400, 25);
        panelTienda.add(boot);

        //oyente de acción botón boot
        boot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });




        vehiculos = new JButton[j1.getVehiculosTotales()];

        int y = 115;

        for (int i = 0; i < j1.getVehiculosTotales(); i++){
            vehiculos[i] = new JButton(j1.getNombre(i));
            vehiculos[i].setBounds(100, y, 400, 25);
            panelTienda.add(vehiculos[i]);

            y += 30;

        }


    }

    private void labels(){

        labelComprador = new JLabel("Comprador:");
        labelComprador.setOpaque(true);
        labelComprador.setHorizontalAlignment(SwingConstants.LEFT);
        labelComprador.setFont(new Font("default", Font.PLAIN, 15));
        labelComprador.setBounds(100, 15, 200, 15);
        panelTienda.add(labelComprador);

        labelVehiculo = new JLabel("Vehiculo");
        labelVehiculo.setOpaque(true);
        labelVehiculo.setHorizontalAlignment(SwingConstants.LEFT);
        labelVehiculo.setFont(new Font("default", Font.PLAIN, 15));
        labelVehiculo.setBounds(300, 15, 200, 15);
        panelTienda.add(labelVehiculo);

        instruccion = new JLabel("Seleccione el articulo a comprar");
        instruccion.setOpaque(true);
        instruccion.setHorizontalAlignment(SwingConstants.LEFT);
        instruccion.setFont(new Font("default", Font.PLAIN, 15));
        instruccion.setBounds(100, 70, 400, 15);
        panelTienda.add(instruccion);

    }

    private void comboBox(){

        panelTienda.add(comprador);
        comprador.setBounds(100, 30, 200, 25);
        for (int i = 0; i < j1.getNumeroGamers(); i++){
            comprador.addItem(j1.getGamerNombre(i));
        }

        //oyente de acción comboBox comprador
        comprador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculo.removeAllItems();
                for (int i = 0; i < j1.getCantidadDeVehiculos(comprador.getSelectedIndex()); i++){
                    vehiculo.addItem(j1.getNombreDeVehiculo(comprador.getSelectedIndex(), i));
                }
            }
        });



        panelTienda.add(vehiculo);
        vehiculo.setBounds(300, 30, 200, 25);


    }
}
