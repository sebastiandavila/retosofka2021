package co.com.sofka;

import co.com.sofka.cargame.datos.BaseDatos;
import co.com.sofka.cargame.domain.carril.Carril;
import co.com.sofka.cargame.domain.carril.values.Posicion;
import co.com.sofka.cargame.domain.carro.Carro;
import co.com.sofka.cargame.domain.carro.Conductor;
import co.com.sofka.cargame.domain.juego.Juego;
import co.com.sofka.cargame.domain.juego.Jugador;
import co.com.sofka.cargame.domain.juego.values.Pista;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    static Map<String, Conductor> PodioAux;

    public static void main(String[] args) {

        //El archivo sql para el funcionamiento del proyecto se encuentra en el repositorio y tiene por nombre retosofkacargame.sql
        BaseDatos consultas = new BaseDatos();
        consultas.Conectar();
//consulta del historial de victorias de los jugadores
        ResultSet rs;
        String strsql = "SELECT * FROM jugador ORDER BY puntos DESC;";

        int i = 0;
        while (i != 100) {
            String Historial = "";
            rs = consultas.consulta(strsql);

            try {
                while (rs.next()) {
                    Historial += rs.getString("nombre") + ": " + rs.getString("puntos") + "\n";
                }

            } catch (SQLException ex) {
                Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
            }
            i = Integer.parseInt(JOptionPane.showInputDialog("Historial de victorias \n" + Historial + "\n Opciones \n "
                    + "1.empezar juego \n "
                    + "100.salir"));
            switch (i) {

                case 1:
                    Empezar();
                    JOptionPane.showMessageDialog(null, "El juego comenzara con el lanzamiento de dados del jugador numero 1");
                    ProgresoJuego();
                    mostrarResultados();
                    break;
            }

        }

    }
//Se pide la informacion necesaria para crear el juego y los objetos requeridos

    static void Empezar() {
        String identificador = JOptionPane.showInputDialog("Ingrese el nombre de la carrera que servira como identificador");
        int numeroDeCarriles = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de jugadores (3 jugadores como minimo)"));
        int kilometros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de kilometros que tendrá la carrera"));
        pista = new Pista(kilometros, numeroDeCarriles);
        juego = new Juego(identificador, pista);
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
            Carril carril = new Carril(posicion, kilometros * 1000, false);
            carril.agregarCarro(carro);
            carriles.add(carril);
            carros.add(carro);
            conductores.add(conductor);

        }
        juego.iniciarJuego();
    }
//se lleva a cabo el progreso del juego, re realiza el lanzamiento del dado para avanzar hasta llegar a la meta

    static void ProgresoJuego() {
        Boolean terminar = false;
        PodioAux = new LinkedHashMap();
        while (terminar == false) {
            terminar = true;
            String mostrar = "";

            for (int x = 1; x <= carriles.size(); x++) {
                mostrar = "";

                if (!carriles.get(x - 1).desplazamientoFinal()) {

                    terminar = false;
                    int dado = carriles.get(x - 1).carro().conductor().lanzarDado();
                    mostrar = mostrar + " el jugador " + carriles.get(x - 1).carro().conductor().nombre() + " ha lanzado el dado y ha sacado: "
                            + dado
                            + " por lo tanto avanza: " + dado * 100 + " metros" + "\n";
                    carriles.get(x - 1).moverCarro(dado * 100);
                    for (int y = 1; y <= carriles.size(); y++) {

                        mostrar = mostrar + carriles.get(y - 1).carro().conductor().nombre() + " ha avanzado en total: " + carriles.get(y - 1).carro().distancia() + " metros \n";
                    }

                    JOptionPane.showMessageDialog(null, mostrar);

                } else {
                    PodioAux.put(carriles.get(x - 1).carro().conductor().nombre(), carriles.get(x - 1).carro().conductor());
                }
            }

        }
        int puesto = 1;
        Iterator it = PodioAux.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();

            for (int x = 1; x <= juego.jugadores().size(); x++) {
                if (juego.jugadores().get(x).getNombre().equals(PodioAux.get(key).nombre())) {
                    Jugador jugador = juego.jugadores().get(x);
                    if (puesto == 1) {
                        juego.asignarPrimerLugar(jugador);
                        puesto++;
                    } else if (puesto == 2) {
                        juego.asignarSegundoLugar(jugador);
                        puesto++;
                    } else if (puesto == 3) {
                        juego.asignarTercerLugar(jugador);
                        puesto++;

                    }
                }
            }

        }

    }

    static void mostrarResultados() {
        String resultados = "Resultados de la carrera " + juego.getIdentificador() + ": \n";
        int puesto = 1;
        Iterator it = PodioAux.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            resultados += puesto + ". " + PodioAux.get(key).nombre() + "\n";
            puesto++;
        }

        JOptionPane.showMessageDialog(null, resultados);
    }
}
