package com.froi;

import javax.swing.*;

public class CreacionDeArma extends JFrame {

    private Juego j1;
    private JPanel panelArma = new JPanel();
    private JTextField nombre;
    private JButton agregarATienda, tienda;
    private JLabel a;

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



    }

    private void labels() {

    }

    private void textFields() {

    }

}
