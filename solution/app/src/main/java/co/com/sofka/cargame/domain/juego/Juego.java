/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.domain.juego.values.Pista;
import co.com.sofka.cargame.domain.juego.values.PistaValues;
import co.com.sofka.cargame.domain.juego.values.Podio;
import co.com.sofka.cargame.domain.juego.values.PodioProps;
import java.util.Map;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author sebastian
 */
public class Juego {
    private Map<Integer, Jugador> jugadores;
    Pista pista;
    Boolean jugando;
    Podio podio;
    
    
    
    public void crearJugador(int jugadorId, String nombre,String color)
    {
       
    }
    
    public void asignarPrimerLugar(int jugadorId)
    {
    }
     public void asignarSegundoLugar(int jugadorId)
    {
    }
      public void asignarTercerLugar(int jugadorId)
    {
    }
      public void iniciarJuego()
      {}
      public Map<Integer, Jugador> jugadores()
      {
      return this.jugadores;}
      
      public PistaValues pista()
      {
          return this.pista;
      }
      
      public Boolean jugando()
      {
      return this.jugando;
      }
      
      public PodioProps podio()
      {
          return this.podio;
      }
}
