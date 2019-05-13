package com.froi;

import java.util.Random;

public class Dado {

    private Random tiro = new Random();
    private int caras;


    public Dado (int caras){

        this.caras = caras;

    }

    public int getNumero(){
        int a = tiro.nextInt(caras);
        return a;
    }

}
