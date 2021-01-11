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
public interface PodioProps {

    Jugador primerLugar();

    Jugador segundoLugar();

    Jugador tercerLugar();

    Boolean estaLleno();
}
