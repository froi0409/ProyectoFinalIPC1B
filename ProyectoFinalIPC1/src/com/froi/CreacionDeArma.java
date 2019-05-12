package com.froi;

import javax.swing.*;
import java.awt.*;

public class CreacionDeArma extends JFrame {

    private Juego j1;
    private JPanel panelArma = new JPanel();
    private JTextField nombre;
    private JButton agregarATienda, tienda, sumaDaño, sumaPunteria, restaDaño, restaPunteria;
    private JLabel ingresoNombre, daño, punteria;
    private double dañoTotal = 0, punteriaTotal = 0;
    private int precioDaño = 0, precioPunteria = 0, precioTotal = 0;

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

        sumaDaño = new JButton("AUMENTO DE DAÑO");
        sumaDaño.setBounds(100, 110, 200, 25);
        panelArma.add(sumaDaño);

        sumaPunteria = new JButton("AUMENTO DE PUNTERIA");
        sumaPunteria.setBounds(300, 110, 200, 25);
        panelArma.add(sumaPunteria);

        restaDaño = new JButton("RESTA DAÑO");
        restaDaño.setBounds(100, 135, 200, 25);
        panelArma.add(restaDaño);

        restaPunteria = new JButton("RESTA PUNTERIA");
        restaPunteria.setBounds(300, 135, 200, 25);
        panelArma.add(restaPunteria);

        agregarATienda = new JButton("AGREGAR A LA TIENDA");
        agregarATienda.setBounds(100, 160, 400, 25);
        panelArma.add(agregarATienda);

    }

    private void labels() {

        ingresoNombre = new JLabel("Ingrese Nombre del Arma");
        ingresoNombre.setOpaque(true);
        ingresoNombre.setHorizontalAlignment(SwingConstants.LEFT);
        ingresoNombre.setFont(new Font("default", Font.PLAIN, 15));
        ingresoNombre.setBounds(100, 65, 400, 15);
        panelArma.add(ingresoNombre);

        daño = new JLabel("Daño: 0");
        daño.setOpaque(true);
        daño.setHorizontalAlignment(SwingConstants.LEFT);
        daño.setFont(new Font("default", Font.BOLD, 15));
        daño.setBounds(100, 205, 200, 15);
        panelArma.add(daño);

        punteria = new JLabel("Punteria: 0");
        punteria.setOpaque(true);
        punteria.setHorizontalAlignment(SwingConstants.LEFT);
        punteria.setFont(new Font("default", Font.BOLD, 15));
        punteria.setBounds(100, 225, 200, 15);
        panelArma.add(punteria);

    }

    private void textFields() {
        nombre = new JTextField();
        nombre.setBounds(100, 80, 400, 25);
        panelArma.add(nombre);
    }

}
