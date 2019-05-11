package com.froi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class Ventana extends JFrame {

    private Juego j1;

    private JPanel panelInicio = new JPanel();
    private JPanel panelOpciones = new JPanel();
    private JPanel panelSeleccionDeTablero = new JPanel();
    private JButton unJugador, dosJugadores, opciones, salir;
    private JButton crearJugador, crearVehiculo, crearArma, tienda, regresar;
    private JButton esce1, esce2, esce3;
    private JLabel labelInicio, labelOpciones, labelSelecTab;

    private int modoDeJuegos;

    public Ventana(Juego j1){

        this.j1 = j1;

        this.setSize(600,300);
        this.setTitle("BATTLE OF HONOR");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        agregarPanelInicio();


    }

    private void agregarPanelInicio(){

        //configuración panel inicio;
        preparaPaneles();

        panelInicio.setVisible(true);
        this.add(this.panelInicio);
        this.panelInicio.setLayout(null);
        botonesPanelInicio();
        labelsPanelInicio();

    }

    public void agregarPanelOpciones(){

        //configuración panel opciones
        preparaPaneles();

        panelOpciones.setVisible(true);
        this.add(this.panelOpciones);
        this.panelOpciones.setLayout(null);
        botonesPanelOpciones();
        labelsPanelOpciones();

    }

    public void agregarPanelSeleccionDeTablero() {

        //configuracion de panel de seleccion de tablero.
        preparaPaneles();

        j1.limpiarCombate();
        panelSeleccionDeTablero.setVisible(true);
        this.add(this.panelSeleccionDeTablero);
        this.panelSeleccionDeTablero.setLayout(null);
        botonesSeleccionTablero();
        labelsSeleccionTablero();


    }

    private void preparaPaneles() {

        this.add(panelOpciones);
        panelOpciones.setVisible(false);
        this.remove(panelOpciones);

        this.add(panelInicio);
        panelInicio.setVisible(false);
        this.remove(panelInicio);

        this.add(panelSeleccionDeTablero);
        panelSeleccionDeTablero.setVisible(false);
        this.remove(panelSeleccionDeTablero);

    }

    private void botonesPanelInicio() {

        //Configuración de botón unJugador
        unJugador = new JButton("UN JUGADOR"); //Botón 1
        unJugador.setBounds(100, 100, 400, 25);
        panelInicio.add(unJugador);

        //Oyente de acción de botón unJugador
        unJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (j1.getNumeroGamers() < 1){
                    JOptionPane.showMessageDialog(null, "Favor crear un jugador");
                    agregarPanelOpciones();
                }
                else{
                    j1.setModoDeJuego(0);
                    j1.abrirSeleccionDeJugador();
                    agregarPanelSeleccionDeTablero();
                    j1.cerrarVentanaInicio();
                }

            }
        });



        //Configuración de botón dosJugadores
        dosJugadores = new JButton("DOS JUGADORES"); //Botón 2
        dosJugadores.setBounds(100, 130, 400, 25);
        panelInicio.add(dosJugadores);

        //Oyente de acción de botón dosJugadores
        dosJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int a = 2 - j1.getNumeroGamers();

                if (j1.getNumeroGamers() < 2){
                    JOptionPane.showMessageDialog(null, "Necesita crear " + a + " jugador(es) más para jugar este modo");
                }
                else {
                    j1.setModoDeJuego(1);
                    j1.abrirSeleccionDeJugador();
                    agregarPanelSeleccionDeTablero();
                    j1.cerrarVentanaInicio();
                }


            }
        });


        //Configuración de botón opciones
        opciones = new JButton("OPCIONES"); //Botón 4
        opciones.setBounds(100, 160, 400, 25);
        panelInicio.add(opciones);

        //Oyente de acción Botón Opciones
        opciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarPanelOpciones();
            }
        });


        //Configuración del botón salir
        salir = new JButton("SALIR"); //Botón 5
        salir.setBounds(100, 190, 400, 25);
        panelInicio.add(salir);

        //Oyente de acción botón Salir
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

    }

    private void labelsPanelInicio() {

        labelInicio = new JLabel();
        labelInicio.setOpaque(true);
        labelInicio.setText("ELIJA LA OPCIÓN DESEADA");
        labelInicio.setHorizontalAlignment(SwingConstants.CENTER);
        labelInicio.setForeground(Color.BLACK);
        labelInicio.setFont(new Font("default", Font.PLAIN, 25));
        labelInicio.setBounds(100, 25, 400, 40);
        panelInicio.add(labelInicio);

    }

    private void botonesPanelOpciones() {

        //configuración botón crearJugador
        crearJugador = new JButton("CREAR JUGADOR");
        crearJugador.setBounds(100, 100, 400, 25);
        panelOpciones.add(crearJugador);

        //oyente de accion votón crearJugador
        crearJugador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j1.abrirCrearJugador();
                j1.cerrarVentanaInicio();
            }
        });


        //configuración botón crearVehículo
        crearVehiculo = new JButton("CREAR VEHICULO");
        crearVehiculo.setBounds(100, 130, 400, 25);
        panelOpciones.add(crearVehiculo);

        //oyente de accion botón crearVehiculo
        crearVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j1.setTipoCreacion(0);
                j1.abrirCreacionDeVehiculos();
                j1.cerrarVentanaInicio();
            }
        });



        //configuracion botón crearArma
        crearArma = new JButton("CREAR ARMA");
        crearArma.setBounds(100, 160, 400, 25);
        panelOpciones.add(crearArma);

        //



        //configuración de botón regresar
        regresar = new JButton("REGRESAR");
        regresar.setBounds(100, 190, 400, 25);
        panelOpciones.add(regresar);

        //oyente de accion de botón regresar
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregarPanelInicio();

            }
        });

    }

    private void labelsPanelOpciones() {

        labelOpciones = new JLabel();
        labelOpciones.setOpaque(true);
        labelOpciones.setText("ELIJA LA OPCIÓN DESEADA");
        labelOpciones.setForeground(Color.BLACK);
        labelOpciones.setHorizontalAlignment(SwingConstants.CENTER);
        labelOpciones.setFont(new Font("default", Font.PLAIN, 25));
        labelOpciones.setBounds(100, 25, 400, 40);
        panelOpciones.add(labelOpciones);


    }

    private void botonesSeleccionTablero() {

        //configuración de botón 4 x 4
        esce1 = new JButton("4 X 4");
        esce1.setBounds(100, 90, 200, 55);
        panelSeleccionDeTablero.add(esce1);

        //oyente de accion de botón 4 x 4
        esce1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregarPanelInicio();
                j1.abirTablero(4, 4, modoDeJuegos);
                j1.cerrarVentanaInicio();

            }
        });



        //configuración de botón 6 x 4
        esce2 = new JButton("6 X 4");
        esce2.setBounds(300, 90, 200, 55);
        panelSeleccionDeTablero.add(esce2);

        //oyente de acción botón 6 x 4
        esce2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                agregarPanelInicio();
                j1.abirTablero(6, 4, modoDeJuegos);
                j1.cerrarVentanaInicio();

            }
        });



        //configuración de botón 8 x 9
        esce3 = new JButton("8 X 9");
        esce3.setBounds(100, 145, 200, 55);
        panelSeleccionDeTablero.add(esce3);

        //oyente de acciion de botón 8 x 9
        esce3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j1.abirTablero(8, 9, modoDeJuegos);
                j1.cerrarVentanaInicio();

            }
        });



        //configuración de boton regresar
        regresar = new JButton("REGRESAR");
        regresar.setBounds(300, 145, 200, 55);
        panelSeleccionDeTablero.add(regresar);

        //oyente de accion de botón regresar
        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                j1.limpiarCombate();
                agregarPanelInicio();

            }
        });



        //configuracion de botón tienda
        tienda = new JButton("TIENDA");
        tienda.setBounds(100, 205, 400, 25);
        panelSeleccionDeTablero.add(tienda);

        //oyente de accion botón tienda
        tienda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


    }

    private void labelsSeleccionTablero() {

        labelSelecTab = new JLabel();
        labelSelecTab.setOpaque(true);
        labelSelecTab.setText("SELECCIONE DIMENSIONES DEL TABLERO");
        labelSelecTab.setForeground(Color.BLACK);
        labelSelecTab.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelecTab.setFont(new Font("default", Font.PLAIN, 18));
        labelSelecTab.setBounds(100, 25, 400, 35);
        panelSeleccionDeTablero.add(labelSelecTab);

    }

}
