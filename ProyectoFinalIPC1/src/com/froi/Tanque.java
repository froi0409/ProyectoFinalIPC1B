package com.froi;

public class Tanque extends Vehiculo {

    /**
     * Constructor de tanque, establece los atributos que el mismo tendrá al inicio.
     */
    public Tanque(){

        setAtaque(10);
        setAtaque(6);
        setPunteria(60);
        setTipo(4);

    }

    /**
     * Otorga arma a vehículo (para aumentar atributos)
     * @param arma -Arma a ingresar
     */
    @Override
    public void setArma(Arma arma) {
        super.setArma(arma);
        setAtaque((getAtaque() + arma.getDaño()));
        setPunteria(getPunteria() + arma.getPunteria());
    }
}
