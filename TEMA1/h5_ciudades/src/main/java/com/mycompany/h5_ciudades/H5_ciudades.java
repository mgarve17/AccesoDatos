/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h5_ciudades;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class H5_ciudades {

    public static void main(String[] args) {

        //pedir ruta
        System.out.println("ruta del fichero: ");
        Path ruta = Path.of(new Scanner(System.in).nextLine().trim());
        
        

        if (!Files.isRegularFile(ruta)) {

            System.out.println("No existe este fichero");
            //CREAR CIUDADES.OBJ
            
            
        } else {
            
            boolean salir = false;

            do {

                //mostrar menu y recoger opcion seleccionada
                int opcion = menu();

                switch (opcion) {

                    case 0 -> {
                        salir = true;
                    }

                    case 1 -> {
                    }

                    case 2 -> {
                    }

                    case 3 -> {
                    }

                    case 4 -> {
                    }

                    case 5 -> {
                    }

                    default -> {
                        System.out.println("default");
                    }
                }

            } while (!salir);
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
    private static void opcion1(){
    
        
        //pedir datos
        System.out.println("Nombre: ");
        String nombre = new Scanner(System.in).nextLine().trim().toUpperCase();
        
        System.out.println("codigo de país: ");
        String codigoPais = new Scanner(System.in).nextLine().trim().toUpperCase();
        
        System.out.println("Provincia: ");
        String provincia = new Scanner(System.in).nextLine().trim().toUpperCase();
        
        System.out.println("Población: ");
        int poblacion = Integer.parseInt(new Scanner(System.in).nextLine().trim());
    }
}
