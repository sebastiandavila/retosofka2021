/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carro;

/**
 *
 * @author sebastian
 */
public class Conductor {

    private String nombre;

    public Conductor(String nombre) {
        this.nombre = nombre;
    }

    public String nombre() {
        return this.nombre;
    }

    public int lanzarDado() {
        return 1;
    }
}
