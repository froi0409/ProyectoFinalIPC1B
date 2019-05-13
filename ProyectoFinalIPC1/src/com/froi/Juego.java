package com.froi;

import java.util.ArrayList;

public class Juego {

    private int rangox, rangoy, modoDeJuego, numeroGamers = 0, vehiculosTotales = 0, tipoCreacion, personasEnCombate = 0, numeroArmas = 0;

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
    private Tienda store;


    //VENTANA DE INICIO

    /**
     * Constructor juego (sin parametros).
     */
    public Juego() {


    }


    /**
     * abre la ventana de inicio
     */
    public void jugar (){

        v1.setVisible(true);

    }

    /**
     * cierra la ventana de inicio
     */
    public void cerrarVentanaInicio(){

        v1.setVisible(false);

    }

    /**
     * nos permite indicar el modo de juego
     * @param modoDeJuego 0-un jugador, 1-dos jugadores
     */
    public void setModoDeJuego(int modoDeJuego){
        this.modoDeJuego = modoDeJuego;
    }

    /**
     * Nos devuelve el modo de juego
     * @return -devuelve el modo de juego
     */
    public int getModoDeJuego(){
        return modoDeJuego;
    }


    //TABLERO

    /**
     * Da inicio al juego poniendo un tablero
     * @param rangox -El rango del tablero en x
     * @param rangoy -El rango del tablero en y
     * @param modoDeJuego -El modo de juego
     */
    public void abirTablero(int rangox, int rangoy, int modoDeJuego) {

        this.rangox = rangox;
        this.rangoy = rangoy;
        this.modoDeJuego = modoDeJuego;

        t1 = new Tablero(rangox, rangoy, modoDeJuego, this);

        t1.setVisible(true);

    }

    /**
     * termina el juego cerrando el tablero
     */
    public void cerrarTablero() {

        t1.setVisible(false);

    }


    //CARACTERISTICAS DE JUGADORES

    /**
     * Abre la ventana de creación de jugador
     */
    public void abrirCrearJugador(){

        c1.setVisible(true);

    } //ventana

    /**
     * cierra la ventana de creación de jugador
     */
    public void cerrarCrearJugador(){

        c1.setVisible(false);

    }

    /**
     * crea un jugador
     * @param nombre -Nombre
     * @param apellido -Apellidos
     * @param edad -Edad
     */
    public void crearJugador(String nombre, String apellido, int edad){

        gamer.add(new Persona(nombre, apellido, edad));
        numeroGamers++;

    } //Caracteristicas

    /**
     * Devuelve el nombre del jugador
     * @param posicion -Posición en el ArrayList
     * @return -Nombre del jugador
     */
    public String getGamerNombre(int posicion){
        return gamer.get(posicion).getNombres();
    }

    /**
     * devuelve los apellidos del jugador
     * @param posicion -Posición en ArrayList
     * @return Apellidos
     */
    public String getGamerApellidos (int posicion){
        return gamer.get(posicion).getNombres();
    }

    /**
     * Devuelve la edad del jugador
     * @param posicion -Posición en ArrayList
     * @return -Edad
     */
    public int getGamerEdad (int posicion){
        return gamer.get(posicion).getEdad();
    }

    /**
     * Devuelve el número de jugadores creados
     * @return -Numero de jugadores creados
     */
    public int getNumeroGamers() {
        return numeroGamers;
    }

    /**
     * devuelve la cantidad de vehiculos que tiene un jugador en específico
     * @param posicion -Posición del jugador en ArrayList
     * @return -Cantidad de vehículos del jugador
     */
    public int getCantVehi(int posicion){
        return gamer.get(posicion).getCantVeh();
    }

    /**
     * Le dá un vehículo al jugador
     * @param posGamer -Posición del jugador en ArrayList
     * @param posVeh -Posición del vehículo en ArrayList
     */
    public void setVG(int posGamer, int posVeh){

        int a;

        System.out.println("V " + todosLosVehiculos.size());
        System.out.println("G " + gamer.size());

        gamer.get(posGamer).setVehiculo(todosLosVehiculos.get(posVeh));

    }

    /**
     * Devuelve la cantidad de vehículos de un jugador en específico
     * @param posJ -Posición de jugador en ArrayList
     * @return -Cantidad de vehículos
     */
    public int getCantidadDeVehiculos(int posJ){
        return gamer.get(posJ).getCantidadDeVehiculos();
    }

    /**
     * Devuelve el nombre de algún vehículo de un jugador en especifico
     * @param posJ -posición de jugador en arraylist
     * @param posV -posición del vehículo en arraylist
     * @return -nombre del vehículo
     */
    public String getNombreDeVehiculo(int posJ, int posV){
        return gamer.get(posJ).getNombreDeVehiculo(posV);
    }

    /**
     * Elimina el vehículo del arraylist principal
     * @param posVeh -posición del vehículo
     */
    public void desplazarVehiculo(int posVeh){

        todosLosVehiculos.remove(posVeh);
        System.out.println("CANTIDAD DE VEHICULOS: " + todosLosVehiculos.size());
        vehiculosTotales--;

    }


    //CARACTERISTICAS DE VEHICULOS

    /**
     * abre la ventana para la creación de un vehículo
     */
    public void abrirCreacionDeVehiculos(){
        cv1.setVisible(true);
    }

    /**
     * cierra la ventana para la creación de un vehículo
     */
    public void cerrarCreacionDeVehiculos() {
        cv1.setVisible(false);
    }

    /**
     * Inidica si la creación del vehiculo se da por necesidad de vehículos a la hora de que se crea un jugador, o si es creación voluntaria
     * @param tipo -tipo de creación
     */
    public void setTipoCreacion(int tipo){
        cv1.setTipoCreacion(tipo);
    }

    /**
     * devuelve el tipo de creación del vehículo
     * @return -tipo de creación de vehículo
     */
    public int getTipoCreacion() {
        return tipoCreacion;
    }

    /**
     * Crea un vehículo nuevo
     * @param nombre -Nombre del vehículo
     * @param tipo -Tipo del vehículo
     */
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

    /**
     * Imprime en consola el los datos del vehículo (para fines desarrollativos)
     * @param posicion -posición de vehículo en arraylist principal
     */
    public void getVehiculo(int posicion){

        System.out.println(todosLosVehiculos.get(posicion).getNombre() + " " + todosLosVehiculos.get(posicion).getTipo());

    }

    /**
     * devuelve el tipo del vehículo
     * @param posicion -posición del vehículo en ArrayList
     * @return -tipo de vehículo
     */
    public int getTipoDeVehiculo(int posicion){
        return todosLosVehiculos.get(posicion).getTipo();
    }

    /**
     * Devuelve el nombre del vehículo en el ArrayList
     * @param posicion -posición del vehículo en ArrayList
     * @return -nombre del vehículo
     */
    public String getNombre(int posicion){

        return todosLosVehiculos.get(posicion).getNombre();

    }

    /**
     * Devuelve el número total de vehículos creados (No dados a un jugador)
     * @return -número de vehículos
     */
    public int getVehiculosTotales(){
        return vehiculosTotales;
    }


    //SELECCION DE VEHICULO

    /**
     * Abre la selección de vehículos
     */
    public void abrirSeleccionDeVehiculos(){

        sv1 = new SeleccionDeVehiculos(this);
        sv1.setVisible(true);
    }

    /**
     * cierra la creación de vehículos
     */
    public void cerrarSeleccionDeVehiculos(){
        sv1.setVisible(false);
    }


    //SELECCION DE JUADOR

    /**
     * Abre la selección de jugador
     */
    public void abrirSeleccionDeJugador(){
        sj1 = new SeleccionDeJugador(this);
        sj1.setVisible(true);
    }

    /**
     * cierra la selección de jugador
     */
    public void cerrarSeleccionDeJugador(){
        sj1.setVisible(false);
    }


    //COMBATE

    /**
     * Agrega jugador al combate
     * @param pos -posición del jugador en ArrayList
     */
    public void agregarAlCombate(int pos){
        personasEnJuego.add(gamer.get(pos));
        personasEnCombate++;
    }

    /**
     * Hace una selección de algún vehiculo que el usuario desee llevar al combate
     * @param posJ -posición de jugador en arraylist
     * @param posVo -posición del vehículo a ingresar
     * @param posVf -posición de ingreso
     */
    public void agregarVehiculoACombate(int posJ, int posVo, int posVf){

        personasEnJuego.get(posJ).cambioDePosicionVehiculo(posVo, posVf);

    }

    /**
     * regresa el tipo de un vehículo en combate
     * @param posJ -posición de jugador en arraylist
     * @param posV -posición de vehículo en arraylist
     * @return -tipo de vehículo
     */
    public int getTipoDeVehiculoCombate(int posJ, int posV){
        return personasEnJuego.get(posJ).getVehiculo(posV).getTipo();
    }

    /**
     * regresa el numero de vehículos que el jugador tiene en combate
     * @param posicion -posición de jugador en arraylist
     * @return -numero de vehículos en combate
     */
    public int getNumVehi(int posicion) {
        return personasEnJuego.get(posicion).getCantVeh();
    }

    /**
     * Regresa el número de personas que hay en el combate
     * @return - número de personas en combate
     */
    public int getPersonasEnCombate(){
        return personasEnCombate;
    }

    /**
     * regresa el nombre de algún vehículo en combate
     * @param posicionJ - posición de jugador en ArrayList
     * @param posicionV - posición de vehículo en ArrayLisy
     * @return -nombre de vehículo en combate
     */
    public String getVehiculoEnCombate(int posicionJ, int posicionV){
        return personasEnJuego.get(posicionJ).getNombreDeVehiculo(posicionV);
    }

    /**
     * reinicia el combate
     */
    public void limpiarCombate(){
        personasEnJuego.clear();
        personasEnCombate = 0;
    }

    /**
     * abre ventana para agregar algún vehículo al combate
     * @param jugador -posición de jugador en combate
     */
    public void abrirAgregarVehCombate(int jugador){
        svc = new SeleccionVehCombate(this);
        svc.setVisible(true);
        svc.setJugador(jugador);
    }

    public int setVida(int posJ, int posV, double daño){
        personasEnJuego.get(posJ).getVehiculo(posV).setHP(daño);
        if (personasEnJuego.get(posJ).getVehiculo(posV).getHP() <= 0){
            return 1;
        }
        else{
            return 0;
        }
    }

    public double getDefensa(int posJ, int posV){
        return personasEnJuego.get(posJ).getVehiculo(posV).getDefensa();
    }

    //ARMAS

    /**
     * abre ventana de creación de arma
     */
    public void abrirCreacionDeArma(){
        cda = new CreacionDeArma(this);
        cda.setVisible(true);
    }

    /**
     * cierra la ventana de creación de arma
     */
    public void cerrarCreacionDeArma(){
        cda.setVisible(false);
    }

    /**
     * Crea un arma para ser agragada a la tienda
     * @param nombre -nombre del arma
     * @param daño -daño del arma
     * @param punteria -puntería del arma
     * @param precio -precio del arma
     */
    public void agregarArmaATienda(String nombre, double daño, double punteria, double precio){
        armasEnVenta.add(new Arma(nombre, daño, punteria, precio));
        numeroArmas++;
    }

    //Tienda

    /**
     * regresa el número de armas que hay en venta
     * @return -número de armas en venta
     */
    public int getNumeroArmas() {
        return numeroArmas;
    }

    /**
     * abre ventana de la tienda
     */
    public void abrirTienda(){
        store = new Tienda(this);
        store.setVisible(true);
    }

    /**
     * regresa la cantidad de dinero disponible de un jugador
     * @param posJ -posición de jugador en ArrayList
     * @return -cantidad de dinero disponible
     */
    public double getDinero(int posJ){
        return gamer.get(posJ).getDinero();
    }

    /**
     * regresa el nombre de un arma en venta
     * @param pos -posición del arma en ArrayList
     * @return -nombre del arma
     */
    public String getNombreArma(int pos){
        return armasEnVenta.get(pos).getNombre();
    }

    /**
     * regresa el precioo que ha sido asignado al arma
     * @param pos -posición de arma en ArrayList
     * @return -precio
     */
    public double getPrecioArma(int pos){
        return armasEnVenta.get(pos).getPrecio();
    }

    /**
     * agrega boot a jugador
     * @param pos -posición de jugador en ArrayList
     */
    public void agregarBoot(int pos){
        gamer.get(pos).agregarBoot();
    }

    /**
     * Asigna arma a algún vehículo de algún jugador
     * @param posJ -posición de jugador en ArrayList
     * @param posV -posición de vehículo en ArrayList
     * @param posA -posición de arma en ArrayList
     */
    public void setAG(int posJ, int posV, int posA){
        gamer.get(posJ).setAV(posV, armasEnVenta.get(posA));
    }

    /**
     * quita algún arma de la tienda
     * @param posA -posición de arma en ArrayList
     */
    public void desplazarArmas(int posA){
        armasEnVenta.remove(posA);
        numeroArmas--;
        System.out.println("Armas: " + numeroArmas);
    }

    /**
     * le quita dinero al jugador para efectuar transacciones
     * @param posJ -posición de jugador en ArrayList
     * @param dinero -asigna cantidad de dinero
     */
    public void comprar(int posJ, double dinero) {
        gamer.get(posJ).setDinero(dinero);
    }

    /**
     * cierra la tienda
     */
    public void cerrarTienda(){
        store.setVisible(false);
        store = null;
    }
}
