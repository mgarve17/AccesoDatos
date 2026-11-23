/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasoconcurso;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author dam206@iesmhp.local
 */
public class Teclado {
    
    private static final Scanner SC = new Scanner(System.in);

    public static String texto(String mensaje) {

        System.out.println(mensaje);
        
        return SC.hasNextLine() ? SC.nextLine().trim() : "";
    }

    public static int entero(String mensaje) {

        
        while(true){
        
            String s = texto(mensaje);
            try{
            
                return Integer.parseInt(s);
            } catch(NumberFormatException e){
            
                if(!SC.hasNextLine() && s.isEmpty()){
                
                    return 0;
                }
                System.out.println("Escribe un nº entero");
            }
        }
      
    }

    public static boolean SiNo(String mensaje) {

        
        return texto(mensaje + "(S/N): ").toUpperCase().startsWith("S");
    }

}
