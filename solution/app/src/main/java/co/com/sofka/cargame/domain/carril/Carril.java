/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carril;

import co.com.sofka.cargame.domain.carril.values.Posicion;
import co.com.sofka.cargame.domain.carro.Carro;

/**
 *
 * @author sebastian
 */
public class Carril {

    private Carro carro;
    private Posicion posicion;
    private int metros;
    private Boolean desplazamientoFinal;

    public Carril(Posicion posicion, int metros, Boolean desplazamientoFinal) {
        this.carro = null;
        this.posicion = posicion;
        this.metros = metros;
        this.desplazamientoFinal = desplazamientoFinal;
    }

    public void agregarCarro(Carro carro) {
        this.carro=carro;
    }

    public void moverCarro(int movimiento) {
        carro.avanzarEnCarril(movimiento);
        if(carro.distancia()>=this.metros)
        {
            carro.setDistancia(this.metros);
        this.desplazamientoFinal=true;
        }
    }

    public int metros() {
        return this.metros;
    }

    public int posicionActual() {
        return this.posicion.actual();
    }

    public int posicionDeseada() {
        return this.posicion.meta();
    }

    public Boolean desplazamientoFinal() {
        return this.desplazamientoFinal;
    }

    public Carro carro() {
        return this.carro;
    }
}
