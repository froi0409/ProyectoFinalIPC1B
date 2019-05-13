package com.froi;

import jdk.swing.interop.SwingInterOpUtils;

import javax.swing.*;
import java.awt.*;

public class hilo extends Thread {

    private Juego j1;
    private Tablero tablero;
    private int x, y, rangox, rangoy, dado;
    private int xizquierda, xderecha, yarriba, yabajo;
    private ImageIcon movimiento = new ImageIcon("fondos/movimiento.jpg");

    public hilo(Tablero tablero, int x, int y, int rangox, int rangoy, int dado, Juego j1){

        this.j1 = j1;
        this.tablero = tablero;
        this.x = x;
        this.y = y;
        this.rangox = rangox;
        this.rangoy = rangoy;
        this.dado = dado + 1;
        xizquierda = x; xderecha = x;
        yarriba = y; yabajo = y;

    }

    @Override
    public void run() {
        super.run();

        pintarCuadros();

    }

    public void pintarCuadros(){
        boolean bxizquierda = false, bxderecha = false, byarriba = false, byabajo = false;
        for (int i = 0; i < dado; i++){
            sleep(300);
            System.out.println("FUNCIONA");


            xizquierda--; xderecha++;
            yarriba--; yabajo++;
            String instruccion = "new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH))";

            if (xizquierda >= 0 && !bxizquierda){
                if (tablero.objeto[xizquierda][y] != 3){
                    if (j1.getTipoDeVehiculoCombate(tablero.jugador, tablero.vehiculoActivo1) == 4){

                        if (tablero.posicion[xizquierda][y].getObjeto() != 2){

                            tablero.posicion[xizquierda][y].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                            tablero.mov[xizquierda][y] = 9;

                        }
                        else{

                            bxizquierda = true;

                        }

                    }
                    else{

                        if (tablero.posicion[xizquierda][y].getObjeto() != 1){
                            tablero.mov[xizquierda][y] = 9;
                            tablero.posicion[xizquierda][y].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                        else{
                            bxizquierda = true;
                        }

                    }

                }
            }
            if (xderecha < rangox && !bxderecha){
                if (tablero.objeto[xderecha][y] != 3){
                    if (j1.getTipoDeVehiculoCombate(tablero.jugador, tablero.vehiculoActivo1) == 4){
                        if (tablero.posicion[xderecha][y].getObjeto() == 2){
                            bxderecha = true;
                        }
                        else{
                            tablero.mov[xderecha][y] = 9;
                            tablero.posicion[xderecha][y].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }
                    else{
                        if (tablero.posicion[xderecha][y].getObjeto() == 1){
                            bxderecha = true;
                        }
                        else{
                            tablero.mov[xderecha][y] = 9;
                            tablero.posicion[xderecha][y].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }
                }
            }
            if (yarriba >= 0 && !byarriba){
                if (tablero.objeto[x][yarriba] !=3){
                    if (j1.getTipoDeVehiculoCombate(tablero.jugador, tablero.vehiculoActivo1) == 4){
                        if (tablero.posicion[x][yarriba].getObjeto() == 2){
                            byarriba = true;
                            System.out.println();
                        }
                        else{
                            tablero.mov[x][yarriba] = 9;
                            tablero.posicion[x][yarriba].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }
                    else {
                        if (tablero.posicion[x][yarriba].getObjeto() == 1){
                            byarriba = true;
                        }
                        else {
                            System.out.println();
                            tablero.mov[x][yarriba] = 9;
                            tablero.posicion[x][yarriba].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }
                }
            }
            if (yabajo < rangox && !byabajo){

                if (tablero.objeto[x][yabajo] != 3){

                    if (j1.getTipoDeVehiculoCombate(tablero.jugador, tablero.vehiculoActivo1) != 4){
                        if (tablero.posicion[x][yabajo].getObjeto() == 1){
                            byabajo = true;
                            System.out.println();
                        }
                        else{
                            tablero.mov[x][yabajo] = 9;
                            tablero.posicion[x][yabajo].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }
                    else {
                        if (tablero.posicion[x][yabajo].getObjeto() == 2){
                            byabajo = true;
                        }
                        else{
                            tablero.mov[x][yabajo] = 9;
                            System.out.println();
                            tablero.posicion[x][yabajo].setIcon(new ImageIcon(movimiento.getImage().getScaledInstance(375/rangox, 375/(rangox + 1), Image.SCALE_SMOOTH)));
                        }
                    }

                }

            }
        }

    }

    public void sleep(int time){
        try{
            Thread.sleep(time);
        } catch (InterruptedException ex){

        }
    }
}
