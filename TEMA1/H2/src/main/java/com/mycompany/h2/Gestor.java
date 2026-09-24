/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

/**
 *
 * @author daw2
 */
public class Gestor {

    public static byte[] leerEnBytes(Path ruta) throws IOException {//leer fichero y devolver un array de bytes

        byte[] b = null;

        if (Files.isReadable(ruta)) {
            
            b = Files.readAllBytes(ruta);
        }
        return b;

    }

    public static void leerEnChar(byte[] b) {//leer fichero y devolver un char[]?

       
        
    }

    public static byte buscarByte() {//mostrar si el byte esta en el fichero y cuantas veces

        return 0;

    }

    public static void modificarByte(Byte b1, Byte b2) {//buscar valor 1 y cambiarlo por valor 2

    }

    public static void anadirByte(Byte b) {//añadir valor al final del fichero

    }

    public static void eliminarByte(Byte b) {//borrar el byte introducido por teclado

    }

    public static boolean validarRuta(Path ruta) {//comprobar que exista la ruta

        return Files.isRegularFile(ruta);
    }

}
