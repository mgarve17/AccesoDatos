/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.AD;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daw2
 */
public class Gestor {

    public static String comprobar(Path ruta) {//comprobar si es directorio

        String cadena;

        if (existe(ruta)) {

            cadena = "ruta encontrada";

            if (Files.isDirectory(ruta)) {//indicar si es directorio

                cadena += ", es un directorio";
            }

        } else {

            cadena = "ruta no encontada";
        }

        return cadena;
    }

    //TERMNAR!!!!!!!!!!!!!!!!!!
    public static String ObtenerFicheros(Path ruta) {//listar ficheros y sub directorios. añadir D o F despues de los nombres

        String cadena = "";

        if (existe(ruta) && Files.isDirectory(ruta)) {

            //investigar Streams 
        }

        return cadena;

    }

    public static String PropiedadesFicheros(Path ruta) {//indicar si existe su tamaño y sus permisos

        String cadena = "";

        if (existe(ruta)) {

            if (Files.isRegularFile(ruta)) {//comprobar que es un file

                try {

                    //obtener info
                    byte size = (byte) Files.size(ruta);
                    boolean escritura = Files.isWritable(ruta);
                    boolean oculto = Files.isHidden(ruta);

                    cadena = "FICHERO \n TAMAÑO: " + size + " ESCRITURA: " + escritura + " OCULTO: " + oculto;

                } catch (IOException ex) {
                    Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {

                cadena = "es un directorio";
            }

        } else {

            cadena = "ruta no encontada";
        }

        return cadena;
    }

    public static String ObtenerRutaActual() {//devolver la ruta del directorio de trabajo

        String rutaAbs="";

        try {

            Path ruta = FileSystems.getDefault().getPath("");//sacar la ruta actual
           rutaAbs = ruta.toAbsolutePath().toString();//hacerla absoluta y pasarla a String
            
        } catch (IOError ex) {//por toAbsolutePath()
                    Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        return rutaAbs;

    }

    public static boolean EliminarFichero(Path ruta) throws IOException {//eliminar el fichero indicado en al ruta si existe

        return Files.deleteIfExists(ruta);
    }

    public static void MoverFichero(Path ruta1, Path ruta2) {//mover un fichero existente de una ruta a otra

         if (existe(ruta1) && existe(ruta2)) {
            
             try {
                 
                 Files.move(ruta1, ruta2, REPLACE_EXISTING);//mover de ruta1 a ruta2 y reemplazarlo si ya existe
                                  
             } catch (IOException ex) {
                 Logger.getLogger(Gestor.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
        
    }

    public static void RenombrarFichero(Path ruta) {//Renombrar el fichero de la ruta si exsite, rechazar si el nombre ya existe
        
       
    }

    public static void copiarFichero(Path ruta, Path ruta2) {//copiar el fichero de una ruta a otra

    }

    public static void VerOCrearDirectorio(Path ruta) {//mostrar el contenido si existe y crearlo si no

        
    }

    public static void ListarPorExt(Path ruta, String ext) {//listar todo el contenido de la ruta que tenga esa extension

    }

    public static void mostarPrimeraLinea(Path ruta) {//comprobar que tiene ext .txt y leer la primera linea, mostrar advertencias

    }

    private static boolean existe(Path ruta) {//metodo para comprobar la existencia de un archivo

        boolean validar = false;

        if (Files.exists(ruta)) {

            validar = true;
        }

        return validar;
    }
    
    public static Path pedirRuta(){//pedir ruta por teclado y devolver un Path
    
        System.out.println("Escribir ruta: ");
        String cadena = new Scanner(System.in).nextLine().trim();
        
        return Path.of(cadena);
    }

}
