package com.froi;

public class Vehiculo{

    private String nombre;
    private double HP = 50, PP = 5, ataque, defensa, punteria, nivel = 1, XP = 0;
    private int tipo;
    private Arma arma;

    public Vehiculo(){


    }

    public void setAtaque(double ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(double defensa) {
        this.defensa = defensa;
    }

    public void setPunteria(double punteria) {
        this.punteria = punteria;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipo() {
        return tipo;
    }
}