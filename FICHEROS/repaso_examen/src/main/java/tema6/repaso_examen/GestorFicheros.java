/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tema6.repaso_examen;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author M
 */
public class GestorFicheros {
    
    public static String listarFicheroDirectorio() {
        
        Path archivo = Path.of("C:\\Users\\cuent\\Documents\\GitHub\\dam2\\AccesoDatos\\TEMA1\\repaso_examen");
        String cadena = "No existe la ruta";
        
        if (Files.exists(archivo) && Files.isDirectory(archivo)) {
            
            cadena = "D " + archivo.toString();
        } else if (Files.exists(archivo) && Files.isRegularFile(archivo)) {
            
            cadena = "F " + archivo.toString();
        }
        
        return cadena;
    }
    
    public static int buscarByte() throws IOException {
        
        int contador = 0;
        
        Path ruta = Path.of("/fichero_binario_ejemplo.bin");
        
        if (Files.exists(ruta) && Files.size(ruta) > 0) {
            
            int valorBuscar = 2;
            
            try (InputStream input = Files.newInputStream(ruta)) {
                
                int baitComparar;
                
                while ((baitComparar = input.read()) != -1) {
                }
                
                if (baitComparar == valorBuscar) {
                    contador++;
                }
            }
        }
        
        return contador;
    }
    
    public static int contarFilasCSV() throws IOException {
        
        int filas = 0;
        Path ruta = Path.of("/titanic_ejercicio.csv");
        
        if (Files.exists(ruta) && Files.size(ruta) > 0) {
            
            List<String> lineas = Files.readAllLines(ruta);
            
            filas = lineas.size();
            
        }
        
        return filas;
    }
    
    public static void serializacion() throws IOException {
        
        Path ruta = Path.of("/ciudades.csv");
        
        City city = new City(01, "torrelavega", "39300", "cantabria", 55000);
        
        if (Files.exists(ruta) && Files.size(ruta) > 0) {
            
            try (ObjectOutputStream output = new SInCabecera(Files.newOutputStream(ruta, StandardOpenOption.APPEND))) {
                
                output.writeObject(city);
            }
            
        } else {
            
            try (ObjectOutputStream output = new SInCabecera()) {
                
                output.writeObject(city);
            }
        }
    }
    
    public static List<City> ordenarCiudades(List<City> ciudades){
    
        ciudades.sort(Comparator.comparing(City::getNombre).thenComparing(City::getCodPais));
        return ciudades;
    }
    
    public static boolean compararCiudades(City a, City b){
    
        return Comparator.comparing(City::getNombre).thenComparing(City::getCodPais).compare(a, b) == 0;
    }
    
}
