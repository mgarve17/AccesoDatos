/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.daw.prog.preguntastest;

import static com.daw.prog.preguntastest.AccesoBD.getConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


            System.out.println("Tipo de pregunta (1-5) :");
            int opcion = Integer.parseInt(new Scanner(System.in).nextLine());

        //probarCnn();

    }

    private static void probarCnn() {
        System.out.println("Probando la conexión a la base de datos...");

        try (Connection conexion = getConnection()) {
            if (conexion != null && !conexion.isClosed()) {
                System.out.println("¡Conexión establecida con éxito!");
                System.out.println("Catálogo actual: " + conexion.getCatalog());
            } else {
                System.out.println("No se pudo establecer la conexión (conexión nula o cerrada).");
            }
        } catch (SQLException e) {
            System.err.println("Error de SQL al intentar conectar:");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al cargar las propiedades o iniciar la conexión:");
            e.printStackTrace();
        }
    }

}
