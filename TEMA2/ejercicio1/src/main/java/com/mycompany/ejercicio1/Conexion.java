/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author daw2
 */
public class Conexion {

    private Connection conn = null;

    //private static final String BD = "mi_base_datos";
    private static final String USUARIO = "root";
    private static final String CLAVE = "r00tMy$ql";
    private static final String URL = "jdbc:mysql://localhost:3306/mi_base_datos";
    //private static final String URL = "jdbc:mysql://localhost:3306/" + BD;

    public Conexion() {

        try {
            Properties properties = new Properties();
            properties.setProperty("user", USUARIO);
            properties.setProperty("password", CLAVE);
            properties.setProperty("useSSL", "false");
            properties.setProperty("autoReconnect", "true");
            conn = (Connection) DriverManager.getConnection(URL, properties);

            if (conn == null) {
                System.out.println("Error en conexión");

            } else {

                System.out.println("Conexión correcta a: " + URL);
            }

        } catch (SQLException e) {

            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
        }
    }

    private static class AccesoBDHolder {

        private static final Conexion INSTANCE = new Conexion();
    }

    public static Conexion getInstance() {

        return AccesoBDHolder.INSTANCE;
    }

    public Connection getConn() {

        return conn;
    }

    public boolean cerrar() {

        boolean isCerrada = false;

        try {

            conn.close();

            if (conn.isClosed()) {
                isCerrada = true;
            }
        } catch (SQLException e) {

            System.out.println("Se produjo un error en el cierre");
        }

        return isCerrada;
    }

}
