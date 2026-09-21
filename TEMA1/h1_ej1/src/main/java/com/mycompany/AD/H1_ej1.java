/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.AD;

import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;


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

                //enseñar el menu por consola
                mostrarMenu();
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
                        
                        opcion6();
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

            System.out.println("Ruta invalida");
            
        } catch (NumberFormatException e) {

            System.out.println("Formato incorrecto");
        }

    }

    private static void mostrarMenu() {

        System.out.println("\t ---MENÚ---");
        System.out.println("1. Comprobar si es directorio");
        System.out.println("2. Obtener ficheros en directorio");
        System.out.println("3. Obtener propiedades de fichero");
        System.out.println("4. Obtener ruta del directorio actual");
        System.out.println("5. Eliminar fichero");
        System.out.println("6. Mover fichero");
        System.out.println("7. Renombrar fichero");
        System.out.println("8. Copiar fichero");
        System.out.println("9. Ver/Crear directorio");
        System.out.println("10. Buscar por extensión en directorio");
        System.out.println("11. Mostrar primera línea de fichero de texto");
        System.out.println("0. salir");
    }

    
    //METER CONTROL DE EXCEPCIONES EN TODOS LAS OPCIONES EN VEZ DE LANZARLO
    
    private static void opcion6() {

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
                
            } else {

                System.out.println("es un archivo");
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
