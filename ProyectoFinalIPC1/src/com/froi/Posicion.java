package com.froi;

import javax.swing.*;

public class Posicion extends JButton {

    /*
        0. Terreno normal.
        1. Montaña.
        2. Lago.
        3. Enemigo.
        4. Tanque.
        5. Avióo.
        6. Boot.
        7. comodin.
        8. Posicion Inicial.
        */

    private int objeto;
    private int x, y;
    Tablero tablero;

    public Posicion () {

    }

    public void setObjeto (int objeto) {
        this.objeto = objeto;
    }

    public int getObjeto() {
        return objeto;
    }
}
