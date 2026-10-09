/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicio1;

import java.util.Scanner;

/**
 *
 * @author daw2
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        
        boolean salir = false;
        
        do{
            
            int opcion = mostrtarMenu();
            
            switch(opcion){
            
                case 1 -> {}
                case 2 -> {}
                case 3 -> {}
                case 4 -> {}
                case 5 -> {}
                default -> {
                
                    System.out.println("default");
                }
            }
        
        }while(!salir);
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
}
