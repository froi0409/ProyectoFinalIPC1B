package com.froi;

public class Enemigo extends Vehiculo {

    private Tablero tablero;
    private int xizquierda, xderecha, yarriba, yabajo, x, y, posicion;

    /**
     * Constructor de enemigo
     * @param tablero -Crea instancia al tablero
     * @param x -Posición del enemigo en x
     * @param y -Posición del enemigo en y
     */

    public Enemigo(Tablero tablero, int x, int y, int posicion){

        this.tablero = tablero;
        this.x = x;
        this.y = y;
        this.posicion = posicion;
        setAtaque(15);
        setDefensa(5);
        setHP(-50);
        System.out.println(getPunteria());
        xderecha = x; xizquierda = x;
        yarriba = y; yabajo = y;

    }
    public void deteccionDeVehículos(){
        deteccionIzquierda();
    }

    private void deteccionIzquierda(){

        xizquierda--;
        if (xizquierda >= 0){

            if (tablero.objeto[xizquierda][y] == 4 || tablero.objeto[xizquierda][y] == 5){
                tablero.j1.setVida(tablero.jugador, tablero.vehiculoActivo1, tablero.enemigos[posicion].getAtaque() - tablero.j1.getDefensa(tablero.jugador, tablero.vehiculoActivo1));
                System.out.println("LO DAÑO!");
                if (tablero.j1.setVida(tablero.jugador, tablero.vehiculoActivo1, 0) == 0){



                }
                else {



                }
            }
            else{
                deteccionIzquierda();
            }

        }

    }

}
