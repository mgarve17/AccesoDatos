/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.AD;

import static com.mycompany.AD.Gestor.comprobar;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw2
 */
public class H1_ej1 {

    public static void main(String[] args) {

        //variables    
        // Path ruta;
        //Files file;
        int opcion;
        boolean salir = false;
        //menu

        try {

            System.out.println("");
            //int opcion = new Scanner(System.in).nextInt(); NO USAR
            opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());

            do {

                switch (opcion) {

                    case 0 -> {

                        salir = true;
                    }

                    case 1 -> {

                        opcion1();

                    }

                    case 2 -> {

                        opcion2();
                    }

                    case 3 -> {
                        
                        opcion3();

                    }

                    case 4 -> {
                        
                        opcion4();
                    }

                    case 5 -> {
                        
                        opcion5();

                    }

                    case 6 -> {
                    }

                    case 7 -> {
                    }

                    case 8 -> {
                    }

                    case 9 -> {
                    }

                    case 10 -> {
                    }

                    case 11 -> {
                    }

                    default -> {
                        System.out.println("opción no válida");
                    }

                }
            } while (!salir);

        } catch (IOException e) {

        } catch (InvalidPathException e) {

        } catch (NumberFormatException e) {

        }

    }

    private static void opcion5() throws IOException {
        //controlar salida (true/false)

        Path ruta = pedirRuta();

        if (Gestor.EliminarFichero(ruta)) {

            System.out.println("Fichero eliminado");
        } else {

            System.out.println("El fichero no existe");
        }
    }

    private static void opcion4() {
        //obtener ruta del directorio

        System.out.println(Gestor.ObtenerRutaActual());
    }

    private static void opcion3() throws IOException {
        //obtener propiedades

        Path ruta = pedirRuta();

        System.out.println(Gestor.PropiedadesFicheros(ruta));
    }

    private static void opcion2() throws IOException {
        //obtener ficheros en directorio TEMRINAR METODO!!

        Path ruta = pedirRuta();

        Gestor.ObtenerFicheros(ruta);
    }

    private static void opcion1() {
        //comprobar si es directorio

        Path ruta = pedirRuta();

        if (Files.exists(ruta)) {//comprobar que existe la ruta

            System.out.println("Existe la ruta");

            if (Gestor.comprobar(ruta)) {

                System.out.println("Es un directorio");
            }

        } else {

            System.out.println("No existe la ruta");
        }
    }

    public static Path pedirRuta() {//pedir ruta por teclado y devolver un Path

        System.out.println("Escribir ruta: ");
        String cadena = new Scanner(System.in).nextLine().trim();

        return Path.of(cadena);
    }
}
