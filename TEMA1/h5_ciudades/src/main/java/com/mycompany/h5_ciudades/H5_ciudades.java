/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h5_ciudades;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class H5_ciudades {

    public static void main(String[] args) {

        //pedir ruta
        //System.out.println("ruta del fichero: ");
        Path ruta = Path.of("ciudades.csv");

        Path fileCiudades = Path.of("ciudades.obj");//crear fichero obj

        if (!Files.isRegularFile(ruta)) {

            System.out.println("No existe este fichero CSV");

        } else {

            gestionMenu(fileCiudades, ruta);

        }
    }

    private static void gestionMenu(Path fileCiudades, Path ruta) {
        //llenar obj

        if (fileCiudades != null) {
            boolean salir = false;

            do {

                //mostrar menu y recoger opcion seleccionada
                int opcion = menu();

                switch (opcion) {

                    case 0 -> {
                        salir = true;
                    }

                    case 1 -> {

                        opcion1(ruta, fileCiudades);
                    }

                    case 2 -> {

                        if (!Files.isRegularFile(ruta)) {

                            System.out.println("no hay ciudades almacenadas");
                        } else {
                            opcion2(fileCiudades);
                        }
                    }

                    case 3 -> {

                        if (!Files.isRegularFile(ruta)) {

                            System.out.println("no hay ciudades almacenadas");
                        } else {

                            opcion3(fileCiudades);
                        }

                    }

                    case 4 -> {
                        if (!Files.isRegularFile(ruta)) {

                            System.out.println("no hay ciudades almacenadas");
                        } else {

                            opcion4(fileCiudades);
                        }

                    }

                    case 5 -> {

                        if (!Files.isRegularFile(ruta)) {

                            System.out.println("no hay ciudades almacenadas");
                        } else {

                            opcion5(fileCiudades);
                        }
                    }

                    default -> {
                        System.out.println("default");
                    }
                }

            } while (!salir);
        } else {

            System.out.println("fichero obj no encontrado");
        }
    }

    private static int menu() {

        System.out.println("""
                           1. A\u00f1adir ciudad 
                           2. Leer Contenido
                           3. Obtener ciudades repetidas
                           4. Eliminar ciudad
                           5. Obtener ciudad más poblada
                           0. Salir""");

        return Integer.parseInt(new Scanner(System.in).nextLine().trim());
    }

    //añadir ciudad al .obj
    private static void opcion1(Path rutaCSV, Path rutaOBJ) {

        try {
            System.out.println("nº línea del csv: ");
            int numLinea = Integer.parseInt(new Scanner(System.in).nextLine().trim());

            City ciudad = GestorCSV.obtenerCiudades(rutaCSV).get(numLinea);//obtener ciudad del csv

            if (ciudad == null) {
                System.out.println("No hay una ciudad en esa posición");
            } else {

                GestorCSV.añadirCiudad(ciudad, rutaOBJ);
            }

        } catch (NumberFormatException e) {

            System.out.println("Formato incorrecto");
        } catch (IOException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    //mostrar todas las ciudades almacenadas
    private static void opcion2(Path rutaOBJ) {

        try {

            List<City> ordenadas = GestorCSV.ordenarCiudades(GestorCSV.obtenerCiudades(rutaOBJ));

            for (City ordenada : ordenadas) {

                System.out.println(ordenada.toString());
            }

        } catch (IOException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    //mostrar ciudades repetidas (mismo nombre y código de país) y el nº de veces que aparece
    private static void opcion3(Path rutaOBJ) {

        try {

            List<City> ordenadas = GestorCSV.ordenarCiudades(GestorCSV.obtenerCiudades(rutaOBJ));

            List<String> repetidas = GestorCSV.obtenerRepetidas(ordenadas);

            System.out.println("Nº REPETIDAS: " + repetidas.size());
            
            for (String repetida : repetidas) {
                System.out.println(repetida);
                
            }
        } catch (IOException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    //borrar una ciudad por su nombre y codigo, informar de cuantas se han borrado o si no se ha borrado
    private static void opcion4(Path rutaOBJ) {
        
        System.out.println("Nombre de la ciudad: ");
        String ciudad = new Scanner(System.in).nextLine().toUpperCase().trim();
        
        //AÑADIR EL REGEX LLUEGO
        System.out.println("Codigo de pais: ");
        String codigo = new Scanner(System.in).nextLine().toUpperCase().trim();
        
        
    }

    //mostrar la ciudad o las ciudades mas pobladas si coinciden en poblacion
    private static void opcion5(Path rutaOBJ) {
        
        try {
            City ciudad = GestorCSV.masPoblada(GestorCSV.obtenerCiudades(rutaOBJ));
            
            System.out.println("CIUDAD MÁS POBLADA: " + ciudad.toString());
            
            
        } catch (IOException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (ClassNotFoundException ex) {
            System.getLogger(H5_ciudades.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
