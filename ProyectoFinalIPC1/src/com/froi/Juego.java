package com.froi;

import java.util.ArrayList;

public class Juego {

    private int rangox, rangoy, modoDeJuego, numeroGamers = 0, vehiculosTotales = 0, tipoCreacion, personasEnCombate = 0;

    private ArrayList<Persona> gamer = new ArrayList<Persona>();
    private Ventana v1 = new Ventana(this);
    private Tablero t1;
    private CreacionDeJugador c1 = new CreacionDeJugador(this);
    private CreacionDeVehiculo cv1 = new CreacionDeVehiculo(this, tipoCreacion);
    private CreacionDeArma cda;
    private SeleccionDeVehiculos sv1;
    private SeleccionVehCombate svc;
    private SeleccionDeJugador sj1;
    private ArrayList<Vehiculo> todosLosVehiculos = new ArrayList<Vehiculo>();
    private ArrayList<Persona> personasEnJuego = new ArrayList<Persona>();
    private ArrayList<Arma> armasEnVenta = new ArrayList<Arma>();


    //VENTANA DE INICIO
    public Juego() {


    }

    public void jugar (){

        v1.setVisible(true);

    }

    public void cerrarVentanaInicio(){

        v1.setVisible(false);

    }

    public void setModoDeJuego(int modoDeJuego){
        this.modoDeJuego = modoDeJuego;
    }

    public int getModoDeJuego(){
        return modoDeJuego;
    }


    //TABLERO
    public void abirTablero(int rangox, int rangoy, int modoDeJuego) {

        this.rangox = rangox;
        this.rangoy = rangoy;
        this.modoDeJuego = modoDeJuego;

        t1 = new Tablero(rangox, rangoy, modoDeJuego, this);

        t1.setVisible(true);

    }

    public void cerrarTablero() {

        t1.setVisible(false);

    }


    //CARACTERISTICAS DE JUGADORES
    public void abrirCrearJugador(){

        c1.setVisible(true);

    } //ventana

    public void cerrarCrearJugador(){

        c1.setVisible(false);

    }

    public void crearJugador(String nombre, String apellido, int edad){

        gamer.add(new Persona(nombre, apellido, edad));
        numeroGamers++;

    } //Caracteristicas

    public String getGamerNombre(int posicion){
        return gamer.get(posicion).getNombres();
    }

    public String getGamerApellidos (int posicion){
        return gamer.get(posicion).getNombres();
    }

    public int getGamerEdad (int posicion){
        return gamer.get(posicion).getEdad();
    }

    public void getGamer(int posicion){

        System.out.println("Nombre: " + gamer.get(posicion).getNombres() + " " + gamer.get(posicion).getApellidos());
        System.out.println("Edad: " + gamer.get(posicion).getEdad());

    }

    public int getNumeroGamers() {
        return numeroGamers;
    }

    public int getCantVehi(int posicion){
        return gamer.get(posicion).getCantVeh();
    }

    public void setVG(int posGamer, int posVeh){

        int a;

        System.out.println("V " + todosLosVehiculos.size());
        System.out.println("G " + gamer.size());

        gamer.get(posGamer).setVehiculo(todosLosVehiculos.get(posVeh));

    }

    public void desplazarVehiculo(int posVeh){

        todosLosVehiculos.remove(posVeh);
        System.out.println("CANTIDAD DE VEHICULOS: " + todosLosVehiculos.size());
        vehiculosTotales--;

    }


    //CARACTERISTICAS DE VEHICULOS
    public void abrirCreacionDeVehiculos(){
        cv1.setVisible(true);
    }

    public void cerrarCreacionDeVehiculos() {
        cv1.setVisible(false);
    }

    public void setTipoCreacion(int tipo){
        cv1.setTipoCreacion(tipo);
    }

    public int getTipoCreacion() {
        return tipoCreacion;
    }

    public void creacionDeVehiculo(String nombre, int tipo){

        if (tipo == 4){
            todosLosVehiculos.add(new Tanque());
        }
        else if (tipo == 5){
            todosLosVehiculos.add(new Avion());
        }
        todosLosVehiculos.get(vehiculosTotales).setNombre(nombre);
        todosLosVehiculos.get(vehiculosTotales).setTipo(tipo);

        vehiculosTotales++;


    }

    public void getVehiculo(int posicion){

        System.out.println(todosLosVehiculos.get(posicion).getNombre() + " " + todosLosVehiculos.get(posicion).getTipo());

    }

    public String getNombre(int posicion){

        return todosLosVehiculos.get(posicion).getNombre();

    }

    public void setVehiculosTotales(int vehiculosTotales){
        this.vehiculosTotales = vehiculosTotales;
    }

    public int getVehiculosTotales(){
        return vehiculosTotales;
    }


    //SELECCION DE VEHICULO
    public void abrirSeleccionDeVehiculos(){

        sv1 = new SeleccionDeVehiculos(this);
        sv1.setVisible(true);
    }

    public void cerrarSeleccionDeVehiculos(){
        sv1.setVisible(false);
    }


    //SELECCION DE JUADOR
    public void abrirSeleccionDeJugador(){
        sj1 = new SeleccionDeJugador(this);
        sj1.setVisible(true);
    }

    public void cerrarSeleccionDeJugador(){
        sj1.setVisible(false);
    }


    //COMBATE
    public void agregarAlCombate(int pos){
        personasEnJuego.add(gamer.get(pos));
        personasEnCombate++;
    }

    public void agregarVehiculoACombate(int posJ, int posVo, int posVf){

        personasEnJuego.get(posJ).cambioDePosicionVehiculo(posVo, posVf);

    }

    public int getNumVehi(int posicion) {
        return personasEnJuego.get(posicion).getCantVeh();
    }

    public int getPersonasEnCombate(){
        return personasEnCombate;
    }

    public String getVehiculoEnCombate(int posicionJ, int posicionV){
        return personasEnJuego.get(posicionJ).getNombreDeVehiculo(posicionV);
    }

    public void limpiarCombate(){
        personasEnJuego.clear();
        personasEnCombate = 0;
    }

    public void abrirAgregarVehCombate(int jugador){
        svc = new SeleccionVehCombate(this);
        svc.setVisible(true);
        svc.setJugador(jugador);
    }

    //ARMAS
    public void abrirCreacionDeArma(){
        cda = new CreacionDeArma(this);
        cda.setVisible(true);
    }

}
