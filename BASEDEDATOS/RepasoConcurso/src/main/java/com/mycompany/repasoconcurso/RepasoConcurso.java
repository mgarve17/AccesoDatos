/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.repasoconcurso;

import java.util.Scanner;

/**
 *
 * @author dam206@iesmhp.local
 */
public class RepasoConcurso {

    public static void main(String[] args) {

        boolean salir = false;

        do {

            int opcion = mostrarMenu();

            switch (opcion) {

                case 1 -> {//añadir usuario

                    añadirUsuario();
                }

                case 2 -> {//salir
                    salir = true;
                }

                default -> {

                }
            }

        } while (!salir);
    }

    private static int mostrarMenu() throws NumberFormatException {
        System.out.println("1. Añadir usuario a la BD");
        System.out.println("2. Salir");
        int opcion = Integer.parseInt(new Scanner(System.in).nextLine().trim());
        return opcion;
    }
    
    private static void añadirUsuario(){}
}
