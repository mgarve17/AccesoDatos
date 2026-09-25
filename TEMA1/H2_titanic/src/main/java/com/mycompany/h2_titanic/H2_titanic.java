/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h2_titanic;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

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
                        
                        List<String> lista = opcion1(ruta);
                        
                        for (String string : lista) {
                            
                            System.out.println(string);
                        }
                    }

                    case 2 -> {
                    }

                    case 3 -> {
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
    
    //ver contenido
    private static List<String> opcion1(Path ruta){
    
        //recoger listado
       List<String> lista = GestorCSV.mostrarContenido(ruta);
       List<String> lista2 = null;
       
       try {
        for (String string : lista) {//formatear salida del 
            
            lista2.add(string.replace(',', '|'));
            
        }
       } catch(NullPointerException e){
       
           System.out.println("La lista es nula");
       }
       
       return lista2;
       
    }
}
