package com.froi;

public class Avion extends Vehiculo {

    private int velocidad;

    public Avion() {

        setAtaque(7);
        setDefensa(3);
        setPunteria(70);
        this.velocidad = 1;

    }

    @Override
    public void setArma(Arma arma) {
        super.setArma(arma);
        setAtaque(getAtaque() + arma.getDaño());
        setPunteria(getPunteria() + arma.getPunteria());
    }
}
