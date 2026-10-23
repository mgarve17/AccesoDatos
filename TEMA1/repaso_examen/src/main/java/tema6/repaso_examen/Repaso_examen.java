/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package tema6.repaso_examen;

import java.util.Scanner;

/**
 *
 * @author M
 */
public class Repaso_examen {

    public static void main(String[] args) {
       
        boolean salir = false;
        
        do {
        
            System.out.println("\n========================================");
            System.out.println("   MENÚ INTEGRAL - ACCESO A DATOS (DAM) ");
            System.out.println("========================================");
            System.out.println("1. Comprobar y listar Directorio/Fichero (Hoja 4-01)");
            System.out.println("2. Buscar Byte en Fichero Binario (Hoja 4-02)");
            System.out.println("3. Analizar Columnas Vacías en CSV (Hoja 4-02bis)");
            System.out.println("4. Serializar y Listar Ciudades (Hoja 4-05)");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            
            int opcion = Integer.parseInt(new Scanner(System.in).nextLine());
            
            
        }while(!salir);
    }
}
