package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionDeArma extends JFrame {

    private Juego j1;
    private JPanel panelArma = new JPanel();
    private JTextField nombre;
    private JButton agregarATienda, sumaDaño, sumaPunteria, restaDaño, restaPunteria;
    private JLabel ingresoNombre, daño, punteria, precio, principal;
    private double dañoTotal = 0, punteriaTotal = 0, precioTotal = 0;

    public CreacionDeArma(Juego j1){

        this.j1 = j1;

        this.setSize(600, 300);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel();

    }

    private void panel(){

        this.add(panelArma);
        this.panelArma.setLayout(null);

        botones();
        labels();
        textFields();

    }

    private void botones(){

        //configuración boton sumaDaño
        sumaDaño = new JButton("AUMENTO DE DAÑO");
        sumaDaño.setBounds(100, 110, 200, 25);
        panelArma.add(sumaDaño);

        //oyente de acción sumaDaño
        sumaDaño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dañoTotal < 10){
                    dañoTotal++;
                    precioTotal += 20;
                    daño.setText("Daño: " + dañoTotal);
                    precio.setText("$ " + precioTotal + "0");

                }
            }
        });


        //configuración botón sumaPuntería
        sumaPunteria = new JButton("AUMENTO DE PUNTERIA");
        sumaPunteria.setBounds(300, 110, 200, 25);
        panelArma.add(sumaPunteria);

        //oyente de acción botón sumaPuntería
        sumaPunteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (punteriaTotal < 40){
                    punteriaTotal += 5;
                    precioTotal += 25;
                    punteria.setText("Punteria: " + punteriaTotal);
                    precio.setText("$ " + precioTotal + "0");
                }
            }
        });



        restaDaño = new JButton("RESTA DAÑO");
        restaDaño.setBounds(100, 135, 200, 25);
        panelArma.add(restaDaño);

        //oyente de acción restaDaño
        restaDaño.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dañoTotal > 0){
                    dañoTotal--;
                    precioTotal -= 20;
                    daño.setText("Daño: " + dañoTotal);
                    precio.setText("$ " + precioTotal + "0");
                }
            }
        });


        //configuración botón restaPuntería.
        restaPunteria = new JButton("RESTA PUNTERIA");
        restaPunteria.setBounds(300, 135, 200, 25);
        panelArma.add(restaPunteria);

        //oyente de acción botón restaPuntería.
        restaPunteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (punteriaTotal > 0){
                    punteriaTotal -= 5;
                    precioTotal -= 25;
                    punteria.setText("Punteria: " + punteriaTotal);
                    precio.setText("$ " + precioTotal + "0");
                }
            }
        });

        //configuración botón agregar a tienda
        agregarATienda = new JButton("AGREGAR A LA TIENDA");
        agregarATienda.setBounds(100, 160, 400, 25);
        panelArma.add(agregarATienda);

        //oyente de acción botón agregar a tienda
        agregarATienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombre.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Ingrese nombre del Arma");
                }
                else{
                    if (dañoTotal == 0 && punteriaTotal == 0){
                        JOptionPane.showMessageDialog(null, "No es posible generar arma sin aumento de daño o punteria");
                    }
                    else{
                        crearArma();
                        j1.jugar();
                        j1.cerrarCreacionDeArma();
                    }
                }
            }
        });

    }

    private void labels() {

        principal = new JLabel("CREACIÓN DE ARMA");
        principal.setOpaque(true);
        principal.setBounds(100, 20, 400, 25);
        principal.setFont(new Font("default", Font.PLAIN, 25));
        principal.setHorizontalAlignment(SwingConstants.CENTER);
        panelArma.add(principal);

        ingresoNombre = new JLabel("Ingrese Nombre del Arma");
        ingresoNombre.setOpaque(true);
        ingresoNombre.setHorizontalAlignment(SwingConstants.LEFT);
        ingresoNombre.setFont(new Font("default", Font.PLAIN, 15));
        ingresoNombre.setBounds(100, 65, 400, 15);
        panelArma.add(ingresoNombre);

        daño = new JLabel("Daño: 0");
        daño.setOpaque(true);
        daño.setHorizontalAlignment(SwingConstants.CENTER);
        daño.setFont(new Font("default", Font.BOLD, 15));
        daño.setBounds(100, 205, 200, 15);
        panelArma.add(daño);

        punteria = new JLabel("Punteria: 0");
        punteria.setOpaque(true);
        punteria.setHorizontalAlignment(SwingConstants.CENTER);
        punteria.setFont(new Font("default", Font.BOLD, 15));
        punteria.setBounds(100, 225, 200, 15);
        panelArma.add(punteria);

        precio = new JLabel("$ 0.00");
        precio.setOpaque(true);
        precio.setHorizontalAlignment(SwingConstants.CENTER);
        precio.setFont(new Font("default", Font.BOLD, 35));
        precio.setBounds(300, 205, 200, 35);
        panelArma.add(precio);

    }

    private void textFields() {
        nombre = new JTextField();
        nombre.setBounds(100, 80, 400, 25);
        panelArma.add(nombre);
    }

    private void crearArma(){

        j1.agregarArmaATienda(nombre.getText(), dañoTotal, punteriaTotal, precioTotal);

    }

}
