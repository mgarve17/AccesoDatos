/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.AD;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author daw2
 */
public class Gestor {

    public static boolean comprobar(Path ruta) {//comprobar si es directorio

        //String cadena;
        boolean directorio = false;

        if (Files.isDirectory(ruta)) {//indicar si es directorio

            directorio = true;
        }

        return directorio;
    }

    //TERMNAR!!!!!!!!!!!!!!!!!!
    public static void ObtenerFicheros(Path ruta) throws IOException {//listar ficheros y sub directorios. añadir D o F despues de los nombres

        //investigar esta movida
        try (DirectoryStream<Path> lista = Files.newDirectoryStream(ruta)) {

            //recorrer el stream
            for (Path file : lista) {
                String nombre = file.getFileName().toString(); //sacar el nombre del file
                if (Files.isDirectory(file)) {//mostrar nombre y si es D o F

                    System.out.println(nombre + " D");
                } else {

                    System.out.println(nombre + " F");
                }
            }
        }

    }

    public static String PropiedadesFicheros(Path ruta) throws IOException {//indicar si existe su tamaño y sus permisos

        String cadena;

        if (Files.exists(ruta)) {

            if (Files.isRegularFile(ruta)) {//comprobar que es un file

                //obtener info
                byte size = (byte) Files.size(ruta);
                boolean escritura = Files.isWritable(ruta);
                boolean oculto = Files.isHidden(ruta);

                cadena = "FICHERO \n TAMAÑO: " + size + " ESCRITURA: " + escritura + " OCULTO: " + oculto;

            } else {

                cadena = "es un directorio";
            }

        } else {

            cadena = "ruta no encontada";
        }

        return cadena;
    }

    public static Path ObtenerRutaActual() {//devolver la ruta del directorio de trabajo

        String dir = System.getProperty("user.dir");
        Path ruta = Path.of(dir);

        return ruta;
    }

    public static boolean EliminarFichero(Path ruta) throws IOException {//eliminar el fichero indicado en al ruta si existe

        return Files.deleteIfExists(ruta);
    }

    public static void MoverFichero(Path ruta1, Path ruta2) throws IOException {//mover un fichero existente de una ruta a otra

        if (Files.exists(ruta1) && Files.exists(ruta2)) {

            Files.move(ruta1, ruta2, REPLACE_EXISTING);//mover de ruta1 a ruta2 y reemplazarlo si ya existe

        }

    }

    public static void RenombrarFichero(Path ruta, String nombre) {//Renombrar el fichero de la ruta si exsite, rechazar si el nombre ya existe

        if (Files.exists(ruta)) {

            ruta.resolveSibling(nombre);
        }

    }

    public static void copiarFichero(Path ruta, Path ruta2) throws IOException {//copiar el fichero de una ruta a otra

        if (Files.exists(ruta) && Files.exists(ruta2)) {

            Files.copy(ruta, ruta2, REPLACE_EXISTING);//copiar de ruta1 a ruta2 y reemplazarlo si ya existe

        }
    }

    public static void VerOCrearDirectorio(Path ruta) throws IOException {//mostrar el contenido si existe y crearlo si no

        if (Files.exists(ruta) && Files.isDirectory(ruta)) {
            try (DirectoryStream<Path> lista = Files.newDirectoryStream(ruta)) {

                //recorrer el stream
                for (Path file : lista) {
                    String nombre = file.getFileName().toString(); //sacar el nombre del file
                    System.out.println(nombre);
                }
            }

        }

    }

    public static void ListarPorExt(Path ruta, String ext) throws IOException {//listar todo el contenido de la ruta que tenga esa extension

        if (Files.exists(ruta) && Files.isDirectory(ruta)) { //investigar esta movida

            try (DirectoryStream<Path> lista = Files.newDirectoryStream(ruta)) {

                //recorrer el stream
                for (Path file : lista) {
                    String nombre = file.getFileName().toString(); //sacar el nombre del file
                    if (nombre.endsWith(ext)) {//mostrar nombre si termina en la extension

                        System.out.println(nombre);
                    }
                }
            }
        }

    }

    public static void mostarPrimeraLinea(Path ruta) throws IOException {//comprobar que tiene ext .txt y leer la primera linea, mostrar advertencias

        String cadena;

        if (Files.exists(ruta) && Files.isRegularFile(ruta)) {
            String nombre = ruta.getFileName().toString();

            if (nombre.endsWith(".txt")) {//si el file termina en la extension txt leer la primera linea

                try (BufferedReader br = Files.newBufferedReader(ruta)) {

                    String linea = br.readLine();

                    if (linea.isEmpty()) {//comprbar si esta vacio

                        cadena = "fichero vacio";
                    } else {

                        cadena = linea;
                    }
                }
            } else {

                cadena = "no es un archivo .txt";
            }
        } else {

            cadena = "no existe el archivo";
        }
    }

}
