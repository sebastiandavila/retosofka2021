package co.com.sofka;

import co.com.sofka.cargame.datos.BaseDatos;
import co.com.sofka.cargame.domain.carril.Carril;
import co.com.sofka.cargame.domain.carril.values.Posicion;
import co.com.sofka.cargame.domain.carro.Carro;
import co.com.sofka.cargame.domain.carro.Conductor;
import co.com.sofka.cargame.domain.juego.Juego;
import co.com.sofka.cargame.domain.juego.Jugador;
import co.com.sofka.cargame.domain.juego.values.Pista;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 * Hello world!
 *
 */
public class App {

    static Juego juego;
    static Pista pista;
    static List<Carril> carriles;
    static List<Carro> carros;
    static List<Conductor> conductores;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*BaseDatos consultas = new BaseDatos();
        consultas.Conectar();
        consultas.insertar("dd");*/
        int i = 0;
        while (i != 100) {
            i = Integer.parseInt(JOptionPane.showInputDialog("Opciones \n "
                    + "1.empezar juego \n "
                    + "100.salir"));
            switch (i) {

                case 1:
                    IniciarJuego();

                    break;
            }

        }

    }

    static void IniciarJuego() {
        int numeroDeCarriles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores"));
        int kilometros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de kilometros que tendrá la carrera"));
        pista = new Pista(kilometros, numeroDeCarriles);
        juego = new Juego(pista);
        carriles = new ArrayList();
        carros = new ArrayList();
        conductores = new ArrayList();
        for (int x = 1; x <= numeroDeCarriles; x++) {
            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + x);
            String color = JOptionPane.showInputDialog("Ingrese el color del jugador " + x);
            juego.crearJugador(x, nombre, color);
            Conductor conductor = new Conductor(nombre);
            Carro carro = new Carro(color);
            carro.asignarConductor(conductor);
            Posicion posicion = new Posicion();
            Carril carril = new Carril(carro, posicion, kilometros * 1000, false);
            carriles.add(carril);
            carros.add(carro);
            conductores.add(conductor);
        }

    }

    static void ProgresoJuego() {

    }
}
