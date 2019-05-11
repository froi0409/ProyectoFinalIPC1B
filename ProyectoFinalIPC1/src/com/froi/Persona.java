package com.froi;

import java.util.ArrayList;

public class Persona {

    private String nombres, apellidos;
    private int cantVeh = 0, edad, punteo;
    private int cantTanques = 0, cantAviones = 0, cantBoots = 0;
    private int dinero = 100;
    private ArrayList<Vehiculo> veh = new ArrayList<Vehiculo>();

    public Persona (String nombres, String apellidos, int edad){

        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;

    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantVeh() {
        return cantVeh;
    }

    public String getNombreDeVehiculo(int posicion){
        return veh.get(posicion).getNombre();
    }

    public void setVehiculo(Vehiculo vehi){
        veh.add(vehi);
        cantVeh++;
    }

    public void cambioDePosicionVehiculo(int posVo, int posVf){

        Vehiculo aux, aux2;

        aux = veh.get(posVf);
        aux2 = veh.get(posVo);
        veh.remove(posVf);
        veh.add(posVf, aux2);
        veh.remove(posVo);
        veh.add(posVo, aux);

    }

    public int getCantidadDeVehiculos(){
        return veh.size();
    }

    public Vehiculo getVehiculo(int posicion){
        return veh.get(posicion);
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void agregarBoot(){
        cantBoots++;
    }

    public void quitarBoot(){
        cantBoots--;
    }

    public int getBoots(){
        return cantBoots;
    }

    public void cambiarPosicion(int posVo, int posVf, Vehiculo vh){

    }
}
