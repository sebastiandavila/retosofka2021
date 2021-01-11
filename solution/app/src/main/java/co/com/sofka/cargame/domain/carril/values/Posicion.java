/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.carril.values;

/**
 *
 * @author sebastian
 */
public class Posicion implements PosicionProps {

    private int actual;
    private int meta;

    public Posicion() {
        this.actual = 0;
        this.meta = 0;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    public void setMeta(int meta) {
        this.meta = meta;
    }

    @Override
    public int actual() {
        return this.actual;
    }

    @Override
    public int meta() {
        return this.meta;
    }

}
