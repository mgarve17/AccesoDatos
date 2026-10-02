/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.h5_ciudades;

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

            System.out.println("No existe este fichero");
            
        
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
                        
                        if (!Files.isRegularFile(ruta)) {
                            
                            System.out.println("no hay ciudades almacenadas");
                        } else {
                            List<String[]> tabla = null;//BORRAR LUEGO
                        
                            //opcion2(tabla);
                        }
                    }

                    case 3 -> {
                        
                        if (!Files.isRegularFile(ruta)) {
                            
                            System.out.println("no hay ciudades almacenadas");
                        } else {
                        
                            opcion3();
                        }
                        
                    }

                    case 4 -> {
                         if (!Files.isRegularFile(ruta)) {
                            
                            System.out.println("no hay ciudades almacenadas");
                        } else {
                         
                             opcion4();
                         }
                        
                    }

                    case 5 -> {
                        
                         if (!Files.isRegularFile(ruta)) {
                            
                            System.out.println("no hay ciudades almacenadas");
                        } else {
                         
                             opcion5();
                         }
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
        String nombre = new Scanner(System.in).nextLine().trim().toUpperCase();//mover el uppercase al constructor
        
        System.out.println("codigo de país: ");
        String codigoPais = new Scanner(System.in).nextLine().trim().toUpperCase();
        
        System.out.println("Provincia: ");
        String provincia = new Scanner(System.in).nextLine().trim().toUpperCase();
        
        System.out.println("Población: ");
        int poblacion = Integer.parseInt(new Scanner(System.in).nextLine().trim());
        
    }
    
//    //leer contenido: mostrar una ciudad por linea
//    private static void opcion2(List<String[]> tabla){
//        
//        for (String[] fila : tabla) {//recorrer las filas
//            
//            for (String columna : fila) {
//                
//                System.out.println(columna + " | ");
//            }
//            
//        }
//    
//    }
    
    //mostrar ciudades repetidas (mismo nombre y código de país) y el nº de veces que aparece
    private static void opcion3(){}
    
    //borrar una ciudad por su nombre y codigo, informar de cuantas se han borrado o si no se ha borrado
    private static void opcion4(){}
    
    //mostrar la ciudad o las ciudades mas pobladas si coinciden en poblacion
    private static void opcion5(){}
    
    private static List<String[]> tablaCSV(List<String> lista){
    
        List<String[]> tabla = null;
        try {
        
            //recorrer coleccion para meterla en la lista ya formateada
            for (String string : lista) {
                
                tabla.add(string.split(","));
            }
            
        } catch(NullPointerException e){
        
            System.out.println("Colección nula");
        }
        return tabla;
    }
}
