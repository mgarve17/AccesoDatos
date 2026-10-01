/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h5_ciudades;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;



/**
 *
 * @author daw2
 */
public class GestorCSV {
    
    public static void añadirCiudad(City ciudad, Path ruta) throws IOException{
    

        //comprobar si tiene cabecera
        if (Files.exists(ruta) && Files.size(ruta) > 0) {//si la tiene
            
            //escribir omitiendo cabecera
            try(ObjectOutputStream output = new SinCabecera(Files.newOutputStream(ruta, StandardOpenOption.APPEND))){
            
                output.writeObject(ciudad);
            }
        } else {//si no la tiene
        
            //escribir añadiendo cabecera
            try(ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(ruta))){
            
                output.writeObject(ciudad);
            }
        }
    }
    
      //leer fichero y meter cada linea en una coleccion
      public static List<String> mostrarContenido(Path ruta) throws IOException{
          return Files.readAllLines(ruta);
      }
      
      //saca el ultimo id de la coleccion para añadirlo en el constructor de Ciudad
      public static int getUltimoID(Path ruta) throws IOException{
          
          int id;
          
          
          
          
        return 0;
    }
      
    
}
