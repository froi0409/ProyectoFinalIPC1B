package com.froi;

public class Tanque extends Vehiculo {

    public Tanque(){

        setAtaque(10);
        setAtaque(6);
        setPunteria(60);
        setTipo(4);

    }

    @Override
    public void setArma(Arma arma) {
        super.setArma(arma);
        setAtaque((getAtaque() + arma.getDaño()));
        setPunteria(getPunteria() + arma.getPunteria());
    }
}
