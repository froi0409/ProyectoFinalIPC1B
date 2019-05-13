package com.froi;

public class Avion extends Vehiculo {

    private int velocidad;

    public Avion() {

        setAtaque(7);
        setDefensa(3);
        setPunteria(70);
        setTipo(5);
        this.velocidad = 1;

    }

    /**
     * Otorga arma a vehículo (para aumentar atributos)
     * @param arma -Arma a ingresar
     */
    @Override
    public void setArma(Arma arma) {
        super.setArma(arma);
        setAtaque(getAtaque() + arma.getDaño());
        setPunteria(getPunteria() + arma.getPunteria());
    }
}
