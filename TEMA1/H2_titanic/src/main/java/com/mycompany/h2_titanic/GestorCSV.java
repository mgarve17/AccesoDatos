/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h2_titanic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author daw2
 */
public class GestorCSV {
    
      public static boolean validarRuta(Path ruta) {//comprobar que exista la ruta

        return Files.isRegularFile(ruta);
    }
      
      //leer fichero y meter cada linea en una coleccion
      public static List<String> mostrarContenido(Path ruta){
          return null;
      }
      
      //buscar valor en el fichero y devolver todas filas 
      public List<String> mostrarValor(String columna, String valor){
          
          
          return null;
      }
      
      //contar columnas del fichero 
      public int contarColumnas(){
          return 0;
      }
      
      //añadir una fila al final del documento sin alterar las demás
      public void anadirFinal(Path ruta, String columna){}
      
      //devolver cuantos valores tiene incompletos tiene una columna y su % sobre el total
      public void detectarVacios(){}
      
//      //formatear salida del csv
//      public List<String> formatearSalida(List<String> lista){
//          
//          List<String> listaArreglada = null;
//          
//          for (String string : lista) {//sustituir , por |
//              
//             listaArreglada.add(string.replace(',', '|'));
//          }
//          
//          
//          return listaArreglada;
//      }
}
