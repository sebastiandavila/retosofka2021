/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.domain.juego;

import co.com.sofka.cargame.datos.BaseDatos;
import co.com.sofka.cargame.domain.juego.values.Pista;
import co.com.sofka.cargame.domain.juego.values.PistaValues;
import co.com.sofka.cargame.domain.juego.values.Podio;
import co.com.sofka.cargame.domain.juego.values.PodioProps;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.objects.NativeArray.map;

/**
 *
 * @author sebastian
 */
public class Juego {
    
    private Map<Integer, Jugador> jugadores;
    private String identificador;
    private Pista pista;
    private Boolean jugando;
    private Podio podio;
    BaseDatos consultas;
    
    public Juego(String identificador, Pista pista) {
        this.identificador = identificador;
        this.jugadores = new HashMap<Integer, Jugador>();
        this.pista = pista;
        this.jugando = false;
        this.podio = new Podio();
        this.consultas = new BaseDatos();
    }
    
    public String getIdentificador() {
        return identificador;
    }
    
    public void crearJugador(int jugadorId, String nombre, String color) {
        Jugador jugador = new Jugador(nombre, color, 0);
        jugadores.put(jugadorId, jugador);
        consultas.Conectar();
        
        Boolean existe = false;
        ResultSet rs;
        String strsql = "SELECT * FROM jugador;";
        rs = consultas.consulta(strsql);
        
        try {
            while (rs.next()) {
                if (nombre.equals(rs.getString("nombre"))) {
                    existe = true;
                }
            }
            if (!existe) {
                strsql = "INSERT INTO `jugador` (`Id`, `nombre`, `puntos`) VALUES (NULL, '" + nombre + "', '0');";
                consultas.insertar(strsql);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void asignarPrimerLugar(Jugador jugador) {
        jugador.setPuntos(jugador.getPuntos() + 1);
        podio.asignarPrimerLugar(jugador);
        consultas.Conectar();
        String nombre = jugador.getNombre();
        String updatePuntos = "UPDATE `jugador` SET `puntos`=`puntos`+1 WHERE `nombre`='" + nombre + "'";
        consultas.insertar(updatePuntos);
        
    }
    
    public void asignarSegundoLugar(Jugador jugador) {
        podio.asignarSegundoLugar(jugador);
    }
    
    public void asignarTercerLugar(Jugador jugador) {
        podio.asignarTercerLugar(jugador);
        
        consultas.Conectar();
        consultas.insertar("INSERT INTO `podio` (`IdentificadorCarrera`, `PrimerLugar`, `SegundoLugar`, `TercerLugar`) VALUES ('" + this.identificador + "', '" + podio.primerLugar().getNombre() + "', '" + podio.segundoLugar().getNombre() + "', '" + podio.tercerLugar().getNombre() + "');");
    }
    
    public void iniciarJuego() {
        this.jugando = true;
    }
    
    public void setJugando(Boolean jugando) {
        this.jugando = jugando;
    }
    
    public Map<Integer, Jugador> jugadores() {
        return this.jugadores;
    }
    
    public PistaValues pista() {
        return this.pista;
    }
    
    public Boolean jugando() {
        return this.jugando;
    }
    
    public PodioProps podio() {
        return this.podio;
    }
}
