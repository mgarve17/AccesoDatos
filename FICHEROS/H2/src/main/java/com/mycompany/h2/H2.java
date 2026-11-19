/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class H2 {

    public static void main(String[] args) {

        //hacer un Path de la ruta introducida por teclado
        System.out.println("Introducir ruta del archivo: ");
        Path ruta = Path.of(new Scanner(System.in).nextLine().trim());

        if (!Gestor.validarRuta(ruta)) {//validar que existe el fichero y mostrar el menu (o no)

            System.out.println("No existe el fichero");

        } else {

            boolean salir = false;

            try {
                do {

                    //enseñar el menu
                    mostrarMenu();

                    int opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());

                    switch (opcion) {

                        case 0 -> {

                            salir = true;

                        }
                        case 1 -> {//llamar a leer bytes

                        }
                        case 2 -> {//llamar a leer como char

                        }
                        case 3 -> {//llamar a buscar byte

                        }
                        case 4 -> {//llamar a modificar

                        }
                        case 5 -> {//llamar a añadir byte

                        }
                        case 6 -> {//llamar a eliminar byte

                        }
                        default -> {

                            System.out.println("Nº no válido");

                        }

                    }

                } while (!salir);

            } catch (NumberFormatException e) {

                System.out.println("Formato erróneo");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("1. Leer valores de bytes");
        System.out.println("2. Leer valores como char");
        System.out.println("3. Buscar byte");
        System.out.println("4. Modificar byte");
        System.out.println("5. Añadir byte");
        System.out.println("6. Eliminar byte");
        System.out.println("0. Salir");
    }

    private static void opcion1(Path ruta) {

        try {

            byte[] valores = Gestor.leerEnBytes(ruta);

            if (valores != null) {//si no es nulo escribe los valores

                String cadena = "";

                for (byte c : valores) {

                    cadena += c + " ";//mostrar los valores separados por un espacio

                }

                System.out.println(cadena);//imprimir valores
                
            } else {//si el array es nulo el fichero está vacío

                System.out.println("El fichero está vacío");
            }

        } catch (IOException e) {

            System.out.println("Error");
        }
    }

}
