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
public class Carro {

    private Conductor conductor;
    private int distancia;
    private String color;

    public Carro(String color) {
        this.distancia = 0;
        this.color = color;
    }

    public void asignarConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public void avanzarEnCarril(int movimiento) {
        
        this.distancia+=movimiento;
        
    }

    public Conductor conductor() {
        return this.conductor;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public int distancia() {
        return this.distancia;
    }

    public String color() {
        return this.color;
    }

}
