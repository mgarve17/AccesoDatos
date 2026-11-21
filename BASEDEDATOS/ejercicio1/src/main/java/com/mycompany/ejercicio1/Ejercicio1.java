/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.ejercicio1;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        boolean salir = false;
        PeliculaDAO dao = new PeliculaDAO();
       

        do {

            int opcion = mostrtarMenu();

            switch (opcion) {

                case 1 -> {
                    
                }
                
                case 2 -> {
                    
                }
                case 3 -> {
                    
                }
                case 4 -> {
                    
                    opcion4(dao);
                }
                case 5 -> {

                    salir = true;
                    
                }
                default -> {

                    System.out.println("default");
                }
            }

        } while (!salir);
    }

    private static int mostrtarMenu() throws NumberFormatException {
        System.out.println("GESTIÓN DE PELÍCULAS");
        System.out.println("1. actualizar");
        System.out.println("2. eliminar");
        System.out.println("3. agregar");
        System.out.println("4. listar");
        System.out.println("5. salir");

        return Integer.parseInt(new Scanner(System.in).nextLine());
    }
    
    private static void opcion1(PeliculaDAO dao){
          
        
        
    }
    
    private static void opcion2(PeliculaDAO dao){
    
    }
    
    private static void opcion3(PeliculaDAO dao){
    
    }
    
    private static void opcion4(PeliculaDAO dao){//listar peliculas
    
        List<Pelicula> peliculas = dao.listar();
        
        for (Pelicula pelicula : peliculas) {
            
            System.out.println(pelicula.toString());
        }
    }
    
    
}
