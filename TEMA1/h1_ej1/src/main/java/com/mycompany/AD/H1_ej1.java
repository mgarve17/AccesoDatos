/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.AD;

import static com.mycompany.AD.Gestor.comprobar;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw2
 */
public class H1_ej1 {

    public static void main(String[] args) {

        //variables    
       // Path ruta;
        //Files file;
        int opcion;
        boolean salir = false;
        //menu

        System.out.println("");
        opcion = new Scanner(System.in).nextInt();

        do {

            switch (opcion) {
                
                case 0 -> {
                
                    salir = true;
                }

                case 1 -> {//comprobar si es directorio
                      
                    Path ruta = Gestor.pedirRuta();
                    
                    System.out.println(Gestor.comprobar(ruta));

                }

                case 2 -> {//obtener ficheros en directorio TEMRINAR METODO!!  
                    
                   Path ruta = Gestor.pedirRuta(); 
                   
                   Gestor.ObtenerFicheros(ruta);
                }

                case 3 -> {//obtener propiedades
                    
                     Path ruta = Gestor.pedirRuta();
                     
                     System.out.println(Gestor.PropiedadesFicheros(ruta));
                     
                }

                case 4 -> {//obtener ruta del directorio
                    
                    System.out.println(Gestor.ObtenerRutaActual());
                }

                case 5 -> {//controlar salida (true/false)
                    
                    Path ruta = Gestor.pedirRuta();
                    
                try {
                    if (Gestor.EliminarFichero(ruta)) {
                        
                        System.out.println("Fichero eliminado");
                    } else {
                    
                        System.out.println("El fichero no existe");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(H1_ej1.class.getName()).log(Level.SEVERE, null, ex);
                }
                }

                case 6 -> {
                }

                case 7 -> {
                }

                case 8 -> {
                }

                case 9 -> {
                }

                case 10 -> {
                }

                case 11 -> {
                }

            }
        } while (!salir);

    }
}
