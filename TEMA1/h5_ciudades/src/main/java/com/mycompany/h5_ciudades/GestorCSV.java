/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.h5_ciudades;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author daw2
 */
public class GestorCSV {

    public static void añadirCiudad(City ciudad, Path ruta) throws IOException {

        //comprobar si tiene cabecera
        if (Files.exists(ruta) && Files.size(ruta) > 0) {//si la tiene

            //escribir omitiendo cabecera
            try (ObjectOutputStream output = new SinCabecera(Files.newOutputStream(ruta, StandardOpenOption.APPEND))) {

                output.writeObject(ciudad);
            }
        } else {//si no la tiene

            //escribir añadiendo cabecera
            try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(ruta))) {

                output.writeObject(ciudad);
            }
        }
    }

    //leer fichero y meter cada linea en una coleccion
    public static List<City> obtenerCiudades(Path ruta) throws IOException, ClassNotFoundException {

        List<City> ciudades = new ArrayList<>();//colección para guardar las ciduades leidas

        try (ObjectInputStream entrada = new ObjectInputStream(Files.newInputStream(ruta))) {

            while (true) {//mientras haya ciudades que añadir

                ciudades.add((City) entrada.readObject());
            }

        } catch (EOFException e) {//salida

        }

        return Files.exists(ruta) && Files.size(ruta) == 0 ? null : ciudades;

    }

    //HACER CON MAPAS
    public static List<String> obtenerRepetidas(List<City> ciudades) {

        List<City> ordenadas = ordenarCiudades(ciudades);//recoger la lista ordenada para que los dupes esten consecutivos
        List<String> repetidas = new ArrayList<>();

        int i = 0;
        while (i < ordenadas.size()) {

            City actual = ordenadas.get(i);

            int veces = 1;

            //comparar la ciudad actual con la siguiente en la lista, veces++ si son iguales
            while ((i + veces) < ordenadas.size() && mismaCiudad(actual, ordenadas.get(i + veces))) {
                veces++;
            }

            if (veces > 1) {//añadir ciudad a la lista de repetidas si habia 
                repetidas.add(actual.toString());
            }
            i = i + veces;//mover el indice para saltar las copias que ya ha leido
        }

        return repetidas;

    }
    //1. comparar obj City por su nombre
    //2. comparar obj City por su codigo
    //3. si el resultado es 0 son iguales, otra cosa es false

    public static boolean mismaCiudad(City a, City b) {

        return Comparator.comparing(City::getNombre).thenComparing(City::getCodPais).compare(a, b) == 0;
    }

    public static List<City> ordenarCiudades(List<City> ciudades) {

        ciudades.sort(Comparator.comparing(City::getNombre).thenComparing(City::getCodPais));

        return ciudades;

    }

    //saca el ultimo id de la coleccion para añadirlo en el constructor de Ciudad
    public static int getUltimoID(List<City> ciudades) throws IOException {

        return ciudades.getLast().getId();
    }

}
