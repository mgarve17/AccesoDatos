/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h2_titanic;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author daw2
 */
public class H2_titanic {

    public static void main(String[] args) {

        System.out.println("Introducir ruta del archivo: ");
        Path ruta = Path.of(new Scanner(System.in).nextLine().trim());

        if (!GestorCSV.validarRuta(ruta)) {

            System.out.println("Fichero no encontrado");
        } else {

            boolean salir = false;

            do {
                int opcion = menu();//recoger opcion del menu

                switch (opcion) {

                    case 0 -> {

                        salir = true;
                    }

                    case 1 -> {//mostrar lista formateada

                        opcion1(ruta);
                    }

                    case 2 -> {//buscar un valor en una columna

                    }

                    case 3 -> {//contar columnas

                    }

                    case 4 -> {
                    }

                    case 5 -> {
                    }

                }
            } while (!salir);
        }
    }

    private static int menu() {//mostrar menu

        System.out.println("""
                           1. Ver contenido 
                            2. Buscar un valor en una columna
                            3. Contar columnas 
                            4. A\u00f1adir una fila al final 
                            5. Buscar filas con datos incompletos""");
        int opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());

        return opcion;

    }

    private static void opcion1(Path ruta) {

        List<String[]> lista = tablaCSV(ruta);

        for (String[] fila : lista) {//recorrer filas

            for (String columna : fila) {//imprimir datos separados por |

                System.out.print(columna + " |");
            }
            System.out.println("");//salto de linea
        }
    }

    //llamar a contar columnas
    private static void opcion3(Path ruta) throws IOException {

       int columnas = GestorCSV.contarColumnas(tablaCSV(ruta));
       
        System.out.println("Nº de columnas: " + columnas);
    }

    //ver contenido
    private static List<String[]> tablaCSV(Path ruta) {

        List<String[]> lista2 = null;//usar array de String para representar las columnas
        try {
            //recoger el listado
            List<String> lista = GestorCSV.mostrarContenido(ruta);

            //llenar segunda lista
            for (String string : lista) {

                //añadir a la segunda lista un String[] por cada fila
                //separando la cadena por la ,
                lista2.add(string.split(","));

            }
        } catch (NullPointerException e) {

            System.out.println("La lista es nula");
        } catch (IOException ex) {
            Logger.getLogger(H2_titanic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PatternSyntaxException e) {

            System.out.println("Patrón erroneo");
        }

        return lista2;

    }
}
