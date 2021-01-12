/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.sofka.cargame.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sebastian
 */
public class BaseDatos {

    private Connection conectar = null;

    public Connection Conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String conexion = "jdbc:mysql://localhost:3306/retosofkacargame";
            conectar = (Connection) DriverManager.getConnection(conexion, "root", "");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontró el DRIVER de conexión" + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error: No se encontró la Base de Datos" + ex.toString());
        }

        return conectar;

    }

    public void insertar(String strsql) {
        int cantRegs = 0;
        Statement st = null;
        try {
            st = conectar.createStatement();
            cantRegs = st.executeUpdate(strsql);
        } catch (SQLException ex) {
            System.out.println("Error en la consulta: " + ex.toString());
        }

    }

    public ResultSet consulta(String strsql) { 
        int cantRegs = 0;
        ResultSet rs = null;
        ResultSet rs1 = null;
        Statement st = null;

        try {
            st = conectar.createStatement();
            rs = st.executeQuery(strsql);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error con la conexión a la Base de Datos" + ex.toString());
        }
        return rs;

    }
}
