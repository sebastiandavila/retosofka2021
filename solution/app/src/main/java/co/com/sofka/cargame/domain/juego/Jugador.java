/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego;

/**
 *
 * @author sebastian
 */
public class Jugador {
    private String nombre;
    private String color;
    private int puntos;

    public Jugador(String nombre, String color, int puntos) {
        this.nombre = nombre;
        this.color = color;
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }


    public String getColor() {
        return color;
    }


    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
}
