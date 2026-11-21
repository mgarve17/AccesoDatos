/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.conexionbdprueba;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 
 */
public class PruebaConexion {

    private static final String URL
            = "jdbc:mysql://localhost:3306/mi_base_datos";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "r00tMy$ql";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(URL, USUARIO, PASSWORD)) {

            System.out.println("-> Conectado a: "
                    + con.getMetaData().getDatabaseProductName() + " "
                    + con.getMetaData().getDatabaseProductVersion());

            // Lista las tablas de mi_base_datos
            System.out.println("\nTablas de mi_base_datos:");
            try (Statement st = con.createStatement(); ResultSet rs = st.executeQuery("SHOW TABLES")) {
                boolean hay = false;
                while (rs.next()) {
                    System.out.println("  - " + rs.getString(1));
                    hay = true;
                }
                if (!hay) {
                    System.out.println("  (la base de datos está vacía)");
                }
            }

        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
            System.err.println("  SQLState: " + e.getSQLState()
                    + "  Código: " + e.getErrorCode());
        }
    }

}
