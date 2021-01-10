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
public class Podio {
    
    private Jugador primerLugar;
    private Jugador segundoLugar;
    private Jugador tercerLugar;
    
    Podio(Jugador primerLugar, Jugador segundoLugar, Jugador tercerLugar){
    this.primerLugar=primerLugar;
    this.segundoLugar=segundoLugar;
    this.tercerLugar=tercerLugar;
    }
}
