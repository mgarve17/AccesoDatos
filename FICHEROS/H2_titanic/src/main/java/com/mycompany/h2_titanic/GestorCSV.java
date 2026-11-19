/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h2_titanic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
      public static List<String> mostrarContenido(Path ruta) throws IOException{
          return Files.readAllLines(ruta);
      }
      
      //buscar valor en el fichero y devolver todas filas 
      public static List<String[]> mostrarValor(List<String[]> lista, String valor,int columna){
          
         List<String[]> listadoValores = null;
         
         
          for (String[] fila : lista) {
              
              if (fila[columna].equals(valor)) {
                  
                  listadoValores.add(fila);
              }
          }
          
          return listadoValores;
//          NO HACER ASI!!! 
//         //recorrer toda la lista y sacar las filas que tienen un valor coincidente
//          for (String[] fila : lista) {
//              for (String columna : fila) {
//                  
//                  if(columna.equals(valor)){
//                  
//                      listadoValores.add(fila);
//                  }
//              }
//          }
//          
          
      }
      
      //contar columnas del fichero 
      public static int contarColumnas(List<String[]> lista) throws IOException{
          
          
          //devolver recuento de columnas      
          return lista.get(0).length;
      }
      
      //añadir una fila al final del documento sin alterar las demás
      public static void anadirFinal(Path ruta, String linea) throws IOException{
      
          Files.writeString(ruta, linea, StandardOpenOption.APPEND);
      }
      
     
      //devolver cuantos valores tiene incompletos tiene una columna y su % sobre el total
      public static void detectarVacios(List<String[]> lista){
      
          // recorrer toda la lista y sacar las filas que tienen un valor coincidente
          for (String[] fila : lista) {
              for (String columna : fila) {
                  
                  if(columna == null){//buscar huecos vacios
                  
                      
                  }
              }
          }
      
      }
      //HACER ESTO EN MAIN
      
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
