package com.froi;

public class Arma {


    private double daño, punteria, precio;
    private String nombre;

    public Arma(String nombre, double daño, double punteria, double precio){
        this.nombre = nombre;
        this.daño = daño;
        this.punteria = punteria;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }
}
