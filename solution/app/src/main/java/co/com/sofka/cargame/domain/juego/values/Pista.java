/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego.values;

/**
 *
 * @author sebastian
 */
public class Pista implements PistaValues {

    private int kilometros;
    private int numeroDeCarriles;

    public Pista(int kilometros, int numeroDeCarriles) {
        this.kilometros = kilometros;
        this.numeroDeCarriles = numeroDeCarriles;
    }

    @Override
    public int kilometros() {
        return this.kilometros;
    }

    @Override
    public int numeroDeCarriles() {
        return this.numeroDeCarriles;
    }

}
