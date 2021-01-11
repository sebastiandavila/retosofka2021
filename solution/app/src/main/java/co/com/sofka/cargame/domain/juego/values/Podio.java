/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego.values;

import co.com.sofka.cargame.domain.juego.Jugador;

/**
 *
 * @author sebastian
 */
public class Podio implements PodioProps {

    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;

    public Podio() {
        this.primerLugar = null;
        this.segundoLugar = null;
        this.tercerLugar = null;
    }

    public void asignarPrimerLugar(Jugador jugador) {
        this.primerLugar = jugador;
    }

    public void asignarSegundoLugar(Jugador jugador) {
        this.segundoLugar = jugador;
    }

    public void asignarTercerLugar(Jugador jugador) {
        this.tercerLugar = jugador;
    }

    @Override
    public Jugador primerLugar() {
        return this.primerLugar;
    }

    @Override
    public Jugador segundoLugar() {
        return this.segundoLugar;
    }

    @Override
    public Jugador tercerLugar() {
        return this.tercerLugar;
    }

    @Override
    public Boolean estaLleno() {
        if(this.primerLugar != null &&
        this.segundoLugar != null &&
        this.tercerLugar != null)
        {return true;}
        else
        {return false;}
        
    }
}
