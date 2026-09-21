/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestorarchivo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author alumno
 */
public class GestorArchivos {

    public boolean existeRuta(Path ruta) {
        return Files.exists(ruta);
    }

    public boolean esDirectorio(Path ruta) {
        return Files.isDirectory(ruta);
    }

    public List<Path> verContenido(Path ruta) throws IOException {
        try (Stream<Path> stream = Files.list(ruta)) {
            return stream.toList(); // En Java 16+ (o .collect(Collectors.toList()) en versiones anteriores)
        }
    }

    public boolean esFichero(Path ruta) {
        return Files.isRegularFile(ruta);
    }

    public long tamanioFichero(Path ruta) throws IOException {

        return Files.size(ruta);
    }

    public boolean esDeLectura(Path ruta) {
        return Files.isReadable(ruta);
    }

    public boolean estaOCulto(Path ruta) throws IOException {
        return Files.isHidden(ruta);
    }

    public String directorioActual() {

        return System.getProperty("user.dir");
        //String directorioActual = Paths.get("").toAbsolutePath().toString(); sería otra forma válida
    }

    public void borrarFichero(Path ruta) throws IOException {
        Files.deleteIfExists(ruta);
    }

    public void RenombrarFichero(Path ruta, String nombre) {//Renombrar el fichero de la ruta si exsite, rechazar si el nombre ya existe

        if (Files.exists(ruta)) {

            ruta.resolveSibling(nombre);
        }

    }

    public void crearCarpeta(Path ruta) throws IOException {

        Files.createDirectory(ruta);

    }

    public void copiarFichero(Path origen, Path destino) throws IOException {
        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
    }

    public void moverFichero(Path origen, Path destino) throws IOException {

        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);

    }

    public String primeraLinea(Path ruta) throws IOException {
        try (Stream<String> lineas = Files.lines(ruta)) {
            return lineas.findFirst().orElse(null);
        }
    }

}
