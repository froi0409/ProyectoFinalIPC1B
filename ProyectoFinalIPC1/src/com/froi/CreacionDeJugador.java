package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreacionDeJugador extends JFrame {

    private Juego j1;

    private JPanel panelCrear = new JPanel();
    private JButton ingresar;
    private JLabel nombres, apellidos, edad, principal;
    private JTextField textnombre, textapellidos, textedad;

    /**
     * constructor de Creación de jugador
     * @param j1 -Crea instancia a clase mayor
     */
    public CreacionDeJugador(Juego j1){

        this.j1 = j1;

        this.setSize(600,300);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        panel();

    }

    public void panel(){

        this.add(panelCrear);
        this.panelCrear.setLayout(null);
        botonesCrear();
        labelsCrear();
        textFieldsCrear();

    }

    /**
     * Crea jugadores
     */
    public void botonesCrear(){

        //configuracion de boton
        ingresar = new JButton("INGRESAR");
        ingresar.setBounds(100, 210, 400, 25);
        panelCrear.add(ingresar);

        //oyente de accion
        ingresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nom, ape;
                int age;

                try {
                    nom = textnombre.getText();
                    ape = textapellidos.getText();
                    age = Integer.parseInt(textedad.getText());

                    if (textnombre.getText().length() == 0){
                        JOptionPane.showMessageDialog(null,"Ingrese correctamente sus datos." );
                    }
                    else {
                        j1.crearJugador(nom, ape, age);

                        textnombre.setText("");
                        textapellidos.setText("");
                        textedad.setText("");

                        if (j1.getVehiculosTotales() < 3){

                            j1.setTipoCreacion(1);
                            j1.abrirCreacionDeVehiculos();
                            j1.cerrarCrearJugador();

                        }
                        else {
                            j1.abrirSeleccionDeVehiculos();
                            j1.cerrarCrearJugador();
                        }

                    }


                }
                catch (NumberFormatException ex){

                    JOptionPane.showMessageDialog(null, "Ingrese correctamente sus datos");

                }

            }
        });

    }

    public void textFieldsCrear(){

        textnombre = new JTextField();
        textnombre.setBounds(100, 80, 400, 25);
        panelCrear.add(textnombre);

        textapellidos = new JTextField();
        textapellidos.setBounds(100, 125, 400, 25);
        panelCrear.add(textapellidos);

        textedad = new JTextField();
        textedad.setBounds(100, 170, 400, 25);
        panelCrear.add(textedad);

    }

    private void labelsCrear() {

        principal = new JLabel();
        principal.setOpaque(true);
        principal.setText("INGRESE LOS DATOS");
        principal.setFont( new Font("default", Font.PLAIN, 25));
        principal.setBounds(100, 20, 400, 25);
        principal.setHorizontalAlignment(SwingConstants.CENTER);
        panelCrear.add(principal);

        nombres = new JLabel();
        nombres.setOpaque(true);
        nombres.setText("Nombres(*):");
        nombres.setHorizontalAlignment(SwingConstants.LEFT);
        nombres.setBounds(100, 65, 400, 15);
        nombres.setFont(new Font("default", Font.PLAIN, 15));
        panelCrear.add(nombres);

        apellidos = new JLabel();
        apellidos.setOpaque(true);
        apellidos.setText("Apellidos:");
        apellidos.setHorizontalAlignment(SwingConstants.LEFT);
        apellidos.setBounds(100, 110, 400, 15);
        apellidos.setFont(new Font("default", Font.PLAIN, 15));
        panelCrear.add(apellidos);

        edad = new JLabel();
        edad.setOpaque(true);
        edad.setText("Edad en Años(*):");
        edad.setHorizontalAlignment(SwingConstants.LEFT);
        edad.setFont(new Font("default", Font.PLAIN, 15));
        edad.setBounds(100, 155, 400, 15);
        panelCrear.add(edad);


    }

}
