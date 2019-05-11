package com.froi;

public class Vehiculo{

    private String nombre;
    private int tipo, HP = 50, PP = 5, ataque, defensa, punteria, nivel = 1, XP = 0;
    private Arma arma;

    public Vehiculo(){


    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setPunteria(int punteria) {
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